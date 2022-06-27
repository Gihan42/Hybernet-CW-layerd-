package Controller;

import Bo.BOFactory;
import Bo.custom.ProcessBo;
import Bo.custom.ReserveBo;
import Bo.custom.RoomsBo;
import Dto.RoomsDto;
import Dto.StudentDto;
import Entity.Room;
import Tm.CartTm;
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

    public TableColumn colStudentId;
    public TableColumn colRoomId;
    public TableColumn ColKeyMoney;
    public TableColumn colDate;
    public JFXTextField txtqty;
    public TableColumn colResId;


    ProcessBo processBo= (ProcessBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROCESS);
    RoomsBo roomsBo= (RoomsBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ROOM);
    ObservableList<CartTm> tmList= FXCollections.observableArrayList();
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
         colStudentId.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
         colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
         colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_id"));
         ColKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
         colResId.setCellValueFactory(new PropertyValueFactory<>("res_id"));

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
        double keymoney=Double.parseDouble(txtKeyMoney.getText());

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
}
