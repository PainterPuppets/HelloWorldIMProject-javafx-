package helloworld.Form;

import helloworld.Component.Move;
import helloworld.Controller.ChatFormController;
import helloworld.DataType.UserInfo;
import helloworld.Share.Common;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChatForm extends Application {

    public Stage n_stage;

    public UserInfo userInfo;

    @Override
    public void start(Stage primaryStage) throws Exception{
        n_stage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "../Resources/FXML/ChatForm.fxml"
                )
        );
        Parent root = loader.load();
        ChatFormController chatFormController = loader.<ChatFormController>getController();
        chatFormController.chatForm = this;
        chatFormController.InitUserInfo();
        Common.mainFormController.Chattable.remove(userInfo.uid);
        Common.mainFormController.Chattable.put(userInfo.uid,chatFormController);
        Scene scene = new Scene(root);
        Move move = new Move(primaryStage,scene);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void Close(){
        n_stage.close();
    }

}