package Controller;

import Bo.BOFactory;
import Bo.custom.ProcessBo;
import Bo.custom.ReserveBo;
import Dto.RoomsDto;
import Dto.StudentDto;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProcessFormController {
    public ComboBox cmbStudentId;
    public Label lblDate;
    public ComboBox cmbRoomId;
    public TableView tblRejistration;
    public Button btnRegistration;
    public JFXTextField txtKeyMoney;
    public Label lblReId;
    public Button btnRemove;
    public AnchorPane root;



     ProcessBo processBo= (ProcessBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROCESS);
     public  void initialize(){
          try {
              loadAllStudentId();
              loadAllRoomId();
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
         generateDateTime();


      }
      public void loadAllRoomId() throws SQLException, IOException, ClassNotFoundException {
         ArrayList<RoomsDto> all=processBo.getAllRoom();
          for (RoomsDto rtm:all
               ) {
              cmbRoomId.getItems().add(rtm.getRoom_id());
          }
      }
      public void loadAllStudentId() throws SQLException, IOException, ClassNotFoundException {
          ArrayList<StudentDto>all=processBo.getAllStudent();
          for (StudentDto stu:all
               ) {
              cmbStudentId.getItems().add(stu.getStudent_id());
          }
      }
    private void generateDateTime() {
        lblDate.setText(LocalDate.now().toString());

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
   private void setUI(String location) throws IOException {
       Stage stage = (Stage) root.getScene().getWindow();
       stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
       stage.setTitle("AdminForm");
   }
    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUI("AdminForm");
    }
}
