package Controller;

import Bo.BOFactory;
import Bo.custom.UserBo;
import Dto.UserDto;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class MnageUserFormController {
    public TextField pwd;
    public TextField username;
    public TextField pwdAgain;
    public AnchorPane mainPane;


      UserBo userBO = (UserBo) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.USER);



    public void signup(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if(username.getText().length()>=3 & pwd.getText().length()>=8) {
           UserDto dto = new UserDto();
            if (pwd.getText().equals(pwdAgain.getText())) {
                dto.setPassword(pwd.getText());
                dto.setUsername(username.getText());
                userBO.save(dto);
            }
            clearUI();
        }else new Alert(Alert.AlertType.WARNING,"Please check the credential length!").show();
    }

    private void clearUI(){
        username.clear();
        pwd.clear();
        pwdAgain.clear();
    }

    /*public void navigateToBack(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("View/loginForm.fxml");
        Parent mainPane = FXMLLoader.load(resource);
        Scene scene = new Scene(mainPane);
        Stage primaryStage = (Stage) (this.mainPane.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }*/

    public void homeButtonOnAction(ActionEvent actionEvent) throws IOException {
        setUI("loginForm");
    }
    private void setUI(String location) throws IOException {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.setTitle("AdminForm");
    }
}
