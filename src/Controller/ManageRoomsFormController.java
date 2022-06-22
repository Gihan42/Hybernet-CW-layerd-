package Controller;

import Bo.BOFactory;
import Bo.custom.RoomsBo;
import Bo.custom.StudentBo;
import Dto.RoomsDto;
import Entity.Student;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageRoomsFormController {
    public ImageView home;
    public AnchorPane root;

    public JFXTextField txtSaveRoomId;
    public JFXTextField txtSaveType;
    public JFXTextField txtSaveMonthlyrent;
    public JFXTextField txtSaveQty;

    public ComboBox<String> cmbSaveRoomType;

    public TextField txtseatRoomId;
    public JFXTextField txtUpdateRoomId;
    public JFXTextField txtUpdateRoomMonthlyrent;
    public JFXTextField txtUpdateRoomqty;

    public ComboBox<String> cmbUpdateRoomtype;
    public Button btnupdate;
    public Button btndelete;

    RoomsBo roomsBo= (RoomsBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.ROOM);
    public void initialize(){
        cmbSaveRoomType.getItems().add("Non-AC");
        cmbSaveRoomType.getItems().add("Non-AC / Food");
        cmbSaveRoomType.getItems().add("AC");
        cmbSaveRoomType.getItems().add("AC / Food");

        cmbUpdateRoomtype.getItems().add("Non-AC");
        cmbUpdateRoomtype.getItems().add("Non-AC / Food");
        cmbUpdateRoomtype.getItems().add("AC");
        cmbUpdateRoomtype.getItems().add("AC / Food");

        btndelete.setDisable(true);
        btnupdate.setDisable(true);
    }

    public void homeButtonOnAction(ActionEvent actionEvent) throws IOException {
        setUI("AdminForm");
    }
    private void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.setTitle("AdminForm");
    }

    public void AddroomOnAction(ActionEvent actionEvent) {
        String id=txtSaveRoomId.getText();
        String type=cmbSaveRoomType.getValue();
        double monthlyrent=Double.parseDouble(txtSaveMonthlyrent.getText());
        int qty=Integer.parseInt(txtSaveQty.getText());

        try {
            boolean b = roomsBo.saveRooms(new RoomsDto(id, type, monthlyrent, qty));
            if(b){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Room").show();
            }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.WARNING,"Something Went Wrong").show();
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SearchRoomIdOnAction(ActionEvent actionEvent) {
        btndelete.setDisable(false);
        btnupdate.setDisable(false);
        try {
            RoomsDto roomsDto = roomsBo.searchRooms(txtseatRoomId.getText());
            txtUpdateRoomId.setText(roomsDto.getRoom_id());
            cmbUpdateRoomtype.setValue(roomsDto.getType());
            txtUpdateRoomMonthlyrent.setText(String.valueOf(roomsDto.getMonthly_rent()));
            txtUpdateRoomqty.setText(String.valueOf(roomsDto.getQty()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void RoomUpdateOnAction(ActionEvent actionEvent) {
        String id=txtUpdateRoomId.getText();
        String type=cmbUpdateRoomtype.getValue();
        double monthlyrent=Double.parseDouble(txtUpdateRoomMonthlyrent.getText());
        int qty=Integer.parseInt(txtUpdateRoomqty.getText());
        try {
            boolean b = roomsBo.updateRoomst(new RoomsDto(id, type, monthlyrent, qty));
            if(b){
                new Alert(Alert.AlertType.CONFIRMATION,"Room Updated").show();
            }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.CONFIRMATION,"Something Went Wrong").show();
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean b = roomsBo.deleteRooms(txtseatRoomId.getText());
            if(b){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Room").show();
            }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.WARNING,"Please Check Room Id"+txtseatRoomId.getText()).show();
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
