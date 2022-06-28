package Controller;

import Bo.BOFactory;
import Bo.custom.ProcessBo;
import Bo.custom.ReserveBo;
import Bo.custom.RoomsBo;
import Bo.custom.StudentBo;
import Dao.DAOFactory;
import Dao.custom.RoomsDao;
import Dto.ReserveDto;
import Dto.RoomsDto;
import Dto.StudentDto;
import Entity.Room;
import Tm.CartTm;
import Tm.RegistrationTm;
import Tm.RoomTm;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProcessFormController {
    public ComboBox<String> cmbStudentId;
    public Label lblDate;
    public ComboBox<String> cmbRoomId;
    public TableView<CartTm> tblRejistration;
    public Button btnRegistration;
    public JFXTextField txtKeyMoney;
    public Label lblReId;
    public Button btnRemove;
    public AnchorPane root;
    public JFXTextField txtUnitprice;
    public JFXTextField txtPayment;

    public TableColumn colStudentId;
    public TableColumn colRoomId;
    public TableColumn ColKeyMoney;
    public TableColumn colDate;
    public JFXTextField txtqty;
    public TableColumn colResId;

    public TableView<RoomTm> tblRoom;
    public TableColumn colroomId;
    public TableColumn colRoomType;
    public TableColumn colMonthlyRent;
    public TableColumn colQty;


    public TableView<RegistrationTm> tblAllRegistration;
    public TableColumn colRDate1;
    public TableColumn colRStudentId1;
    public TableColumn colRRoomId1;
    public TableColumn ColRKeyMoney1;
    public TableColumn colrResId1;

    public JFXTextField txtAStudentId;
    public JFXTextField txtAStudentName;
    public JFXTextField txtARoomId;
    public JFXTextField txtAroomType;
    public JFXTextField txtAReserveId;



    private String reid =null;
    private double keymoney=00;

    ProcessBo processBo= (ProcessBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROCESS);
    RoomsBo roomsBo= (RoomsBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ROOM);
    ReserveBo reserveBo= (ReserveBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.RESEVE);
    StudentBo studentBo= (StudentBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.STUDENT);
    RoomsDao roomsDao= (RoomsDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOMS);

    ObservableList<CartTm> tmList= FXCollections.observableArrayList();
     public  void initialize(){
          try {
              loadAllStudentId();
              loadAllRoomId();
              getAllRooms();
              loadAllRejistration();
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
         generateDateTime();
         colStudentId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
         colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
         colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_id"));
         ColKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
         colResId.setCellValueFactory(new PropertyValueFactory<>("res_id"));

         colroomId.setCellValueFactory(new PropertyValueFactory<>("room_id"));
         colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
         colMonthlyRent.setCellValueFactory(new PropertyValueFactory<>("monthly_rent"));
         colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            lblReId.setText(genaratenewId());
            btnRegistration.setDisable(true);
            btnRemove.setDisable(true);

         colRDate1.setCellValueFactory(new PropertyValueFactory<>("date"));
         colRStudentId1.setCellValueFactory(new PropertyValueFactory<>("room_id"));
         colRRoomId1.setCellValueFactory(new PropertyValueFactory<>("student_id"));
         ColRKeyMoney1.setCellValueFactory(new PropertyValueFactory<>("key_money"));
         colrResId1.setCellValueFactory(new PropertyValueFactory<>("res_id"));

        tblAllRegistration.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
             if(newValue !=null){
                 txtAStudentId.setText(newValue.getRoom_id());
                 txtARoomId.setText(newValue.getStudent_id());
                 txtAReserveId.setText(newValue.getRes_id());
                getAllDetails();
             }
         });
        tblAllRegistration.refresh();
     }

    private void getAllDetails() {
        try {
            RoomsDto roomsDto = roomsBo.searchRooms(txtARoomId.getText());
            txtAroomType.setText(roomsDto.getType());
            StudentDto studentDto = studentBo.searchStudent(txtAStudentId.getText());
            txtAStudentName.setText(studentDto.getStudent_name());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void addtoCartOnActions(ActionEvent actionEvent) {
        String res_id=lblReId.getText();
        String s_id=cmbStudentId.getValue();
        String r_id=cmbRoomId.getValue();
        int qty=Integer.parseInt(txtqty.getText());
        double monthlyRent=Double.parseDouble(txtUnitprice.getText());
        double payment=Double.parseDouble(txtPayment.getText());
        keymoney=monthlyRent-payment;
        txtKeyMoney.setText(String.valueOf(keymoney));
        CartTm tm = new CartTm(
                lblReId.getText(),
                lblDate.getText(),
                keymoney,
                s_id,
                r_id
        );
        tmList.add(tm);
        tblRejistration.setItems(tmList);
        tblRejistration.refresh();
        btnRegistration.setDisable(false);
        btnRemove.setDisable(false);
    }

    public void cmbRoomIdOnAction(ActionEvent actionEvent) {
        String id= cmbRoomId.getValue();
        try {
            RoomsDto roomsDto = roomsBo.searchRooms(id);
            txtUnitprice.setText(String.valueOf( roomsDto.getMonthly_rent()));
            txtqty.setText(String.valueOf(roomsDto.getQty()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        tblRejistration.getItems().remove(tblRejistration.getSelectionModel().getSelectedItem());
        tblRejistration.getSelectionModel().clearSelection();

    }
    public void getAllRooms() throws SQLException, IOException, ClassNotFoundException {
         tblRoom.getItems().clear();
         List<RoomsDto> arrayList=roomsBo.getAllRoomst();
        for (RoomsDto rm:arrayList
             ) {
            tblRoom.getItems().add(new RoomTm(rm.getRoom_id(),rm.getType(),rm.getMonthly_rent(),rm.getQty()));
        }

    }

    public void RejistraOnAction(ActionEvent actionEvent) {
        String res_id = lblReId.getText();
        String s_id = cmbStudentId.getValue();
        String r_id = cmbRoomId.getValue();
        int qty = Integer.parseInt(txtqty.getText());
        double monthlyRent = Double.parseDouble(txtUnitprice.getText());
        double keymoney = Double.parseDouble(txtKeyMoney.getText());

        RoomsDto reserveDto = new RoomsDto();
        try {
                boolean b = reserveBo.saveReserve(new ReserveDto(res_id, lblDate.getText(), keymoney, s_id, r_id));
                lblReId.setText(genaratenewId());

            if(b){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Register")
.show();           tblAllRegistration.refresh();
            }
            roomsDao.updateRoomsQty(r_id,reserveDto.getQty());
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong")
                    .show();
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String genaratenewId(){
        try {
            reid = reserveBo.genarateId();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, e.toString());
            alert.show();
        }
        return reid;
    }

    public void loadAllRejistration() throws SQLException, IOException, ClassNotFoundException {

        List<ReserveDto> allReserve = reserveBo.getAllReserve();
        for (ReserveDto dto: allReserve){
            tblAllRegistration.getItems().add(new RegistrationTm(dto.getRes_id(),dto.getDate(),dto.getKey_money(), dto.getStudent_id(), dto.getRoom_id()));
        }
        tblAllRegistration.refresh();
    }

    public void removeRegistrationOnAction(ActionEvent actionEvent) {

        try {
            boolean b = reserveBo.deleteReserve(txtAReserveId.getText());
            if (b){
                tblAllRegistration.getItems().remove(tblAllRegistration.getSelectionModel().getSelectedItem());
                tblAllRegistration.getSelectionModel().clearSelection();
                new Alert(Alert.AlertType.CONFIRMATION,"Registration Has Been Deleted").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
