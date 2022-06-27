package Controller;

import Bo.BOFactory;
import Bo.custom.StudentBo;
import Dto.StudentDto;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class ManageRegistrationFormController {
    public AnchorPane root;
    public ImageView home;
    
    public JFXTextField txtSaveStudentId;
    public JFXTextField txtStudentBDay;
    public JFXTextField txtSaveStudentGander;
    public JFXTextField txtSaveStudentContactNo;
    public JFXTextField txtSaveStudentName;
    public JFXTextField txtSaveStudentAddress;
    

    public JFXTextField txtUpdateStudentContactNo;
    public JFXTextField txtUpdateStudentBDay;
    public JFXTextField txtUpdateStudentId;
    public JFXTextField txtUpdateStudentName;
    public JFXTextField txtUpdateStudentAddress;
    public JFXTextField txtUpdateStudentGender;

    public TextField txtSearchStudentId;
    public Button btnUpdate;
    public Button btnDelete;


    StudentBo studentBo= (StudentBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.STUDENT);
   public void initialize(){
    btnDelete.setDisable(true);
    btnUpdate.setDisable(true);
}
    public void homebuttonOnAction(ActionEvent actionEvent) throws IOException {
        setUI("AdminForm");
    }
    private void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.setTitle("AdminForm");
    }

    public void AddnewStudentOnAction(ActionEvent actionEvent) {
        String id=txtSaveStudentId.getText();
        String name=txtSaveStudentName.getText();
        String address=txtSaveStudentAddress.getText();
        String Bday=txtStudentBDay.getText() ;
        String contactNo=txtSaveStudentContactNo.getText();
        String gender=txtSaveStudentGander.getText();

        try {
          boolean b=  studentBo.saveStudent(new StudentDto(id,name,address,contactNo,Bday ,gender));
          if(b){
              new Alert(Alert.AlertType.CONFIRMATION,"Save").show();
          }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchStudentOnAction(ActionEvent actionEvent) {
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
        try {
          /*  if (!isExistsStudent(txtSearchStudentId.getText())){
                new Alert(Alert.AlertType.ERROR, "There is no such Customer associated with the id ").show();
            }
            else {
                boolean b = studentBo.existStudent(txtSearchStudentId.getText());
                if (!b) {
                    new Alert(Alert.AlertType.ERROR, " Please Check Id " + txtSearchStudentId.getText()).show();
                }*/
                StudentDto studentDto = studentBo.searchStudent(txtSearchStudentId.getText());
                txtUpdateStudentId.setText(studentDto.getStudent_id());
                txtUpdateStudentName.setText(studentDto.getStudent_name());
                txtUpdateStudentAddress.setText(studentDto.getAddress());
                txtUpdateStudentContactNo.setText(studentDto.getContact_no());
                txtUpdateStudentBDay.setText(studentDto.getDob());
                txtUpdateStudentGender.setText(studentDto.getGender());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void StudentUpdateOnAction(ActionEvent actionEvent) {
        String id=txtUpdateStudentId.getText();
        String name=txtUpdateStudentName.getText();
        String address=txtUpdateStudentAddress.getText();
        String Bday=txtUpdateStudentBDay.getText();
        String contactNo=txtUpdateStudentContactNo.getText();
        String gender=txtUpdateStudentGender.getText();

        try {
         boolean b= studentBo.updateStudent(new StudentDto(id,name,address,contactNo,Bday,gender));
         if(b){
             new Alert(Alert.AlertType.CONFIRMATION,"Student Updated").show();
         }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        try {
         boolean b= studentBo.deleteStudent(txtSearchStudentId.getText());
         if (b){
             new Alert(Alert.AlertType.CONFIRMATION,"Student Deleted").show();
         }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.WARNING,"Check AgainStudent Id"+txtSearchStudentId.getText()).show();
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean isExistsStudent(String id) throws SQLException, IOException, ClassNotFoundException {
            return   studentBo.existStudent(id);
    }
}
