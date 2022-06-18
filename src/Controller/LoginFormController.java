package Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyEvent;

public class LoginFormController {
    public Button btnlogin;
    public CheckBox checkBtnShowpw;
    public JFXPasswordField pwdPassword;
    public JFXTextField txtUserName;
    public Button btnLogout;
    public JFXTextField TxtShowPw;

    public void logoutOnAction(ActionEvent actionEvent) {
    }

    public void EnterOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
    }

    public void loginOnaction(ActionEvent actionEvent) {
        String userName = txtUserName.getText();
        String pawd = pwdPassword.getText();
        if (userName.equalsIgnoreCase("gihan") && pawd.equalsIgnoreCase("123")) {
        } else {
            new Alert(Alert.AlertType.WARNING, "please try again").show();
        }
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
}
