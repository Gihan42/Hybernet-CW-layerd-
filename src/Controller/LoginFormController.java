package Controller;

import Bo.BOFactory;
import Bo.custom.UserBo;
import Dto.UserDto;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public Button btnlogin;
    public CheckBox checkBtnShowpw;
    public JFXPasswordField pwdPassword;
    public JFXTextField txtUserName;
    public Button btnLogout;
    public JFXTextField TxtShowPw;
    public Label lblsign;
    public AnchorPane root;
    public ImageView manageuser;

    UserBo userBo= (UserBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.USER);

    public void logoutOnAction(ActionEvent actionEvent) {
    }

    public void EnterOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
    }

    public void loginOnaction(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {
        UserDto dto = userBo.search(txtUserName.getText());
        checkup(dto);
    }
    private void checkup(UserDto dto) throws SQLException, ClassNotFoundException, IOException {
        if(dto!=null){
            String passcode = pwdPassword.getText();

            if(passcode.equals(dto.getPassword())){
                // log in successful
                System.out.printf("successful");
                Stage stage = (Stage) root.getScene().getWindow();
                Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("View/AdminForm.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
            }else  new Alert(Alert.AlertType.ERROR,"Password is incorrect!").show();
        }else new Alert(Alert.AlertType.ERROR,"User not found!").show();
    }

    public void ShowPasswordOnAction(ActionEvent actionEvent) {
        if (checkBtnShowpw.isSelected()) {
            pwdPassword.setVisible(false);
            TxtShowPw.setVisible(true);
            TxtShowPw.setText(pwdPassword.getText());
        } else {
            pwdPassword.setVisible(true);
            TxtShowPw.setVisible(false);
        }
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "manageuser":
                    root = FXMLLoader.load(this.getClass().getResource("/View/manageUserForm.fxml"));
                    break;
            }
            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

        public void playMouseExitAnimation (MouseEvent mouseEvent) {
            if (mouseEvent.getSource() instanceof ImageView) {
                ImageView icon = (ImageView) mouseEvent.getSource();
                ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
                scaleT.setToX(1);
                scaleT.setToY(1);
                scaleT.play();

                icon.setEffect(null);
            }
        }
    }

