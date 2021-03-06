package helloworld.Component;

import helloworld.DataType.UserInfo;
import helloworld.Share.Common;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Created by painter on 17-1-3.
 */
public class Chatbubbles extends AnchorPane {
    ImageView Avatar = new ImageView();
    Label Nickname = new Label();
    Label Messagetext= new Label();

    public UserInfo userInfo;
    public Chatbubbles(String message,UserInfo userInfo,int state){
        this.userInfo= userInfo;
        this.setStyle(
                "-fx-pref-width: 200px;"
        );
        this.Avatar.setImage(new Image(Common.GetAvatarPath(userInfo.avatar)));
        this.Avatar.setFitHeight(50.0);
        this.Avatar.setFitWidth(50.0);
        this.Avatar.setStyle(
                "-fx-border-width: 5px;" +
                "-fx-border-color: white;"
        );

        this.Nickname.setText(userInfo.nickname);
        this.Nickname.setWrapText(true);
        this.Nickname.setMaxWidth(50);
        this.Nickname.setMinWidth(50);
        this.Nickname.setPrefWidth(50);
        this.Nickname.setAlignment(Pos.CENTER);
        this.Nickname.setStyle(
                "-fx-font-family: 'Noto Sans CJK JP Black';" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;"
        );

        this.Messagetext.setText(message);
        this.Messagetext.setWrapText(true);
        this.Messagetext.setMaxWidth(150);
        this.Messagetext.getStyleClass().add("rounded-label");
        this.Messagetext.setStyle(
                "-fx-background-color: gray; " +
                "-fx-padding: 12px; " +
                "-fx-background-radius: 10px; " +
                "-fx-font-family: 'Noto Sans CJK JP Black'; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 13px;" +
                "-fx-text-fill: white; "
        );

        this.getChildren().add(this.Avatar);
        this.getChildren().add(this.Messagetext);
        this.getChildren().add(this.Nickname);

        this.setTopAnchor(this.Avatar, 5.0);
        this.setTopAnchor(this.Nickname, 60.0);
        this.setTopAnchor(this.Messagetext, 10.0);

        if(state == 1)//别人说话
        {
            this.setLeftAnchor(this.Avatar, 10.0);
            this.setLeftAnchor(this.Nickname, 10.0);
            this.setLeftAnchor(this.Messagetext, 70.0);
        }else if(state == 0)//自己说话
        {
            this.setRightAnchor(this.Avatar, 10.0);
            this.setRightAnchor(this.Nickname, 10.0);
            this.setRightAnchor(this.Messagetext, 70.0);
        }
/*
        if(Messagetext.getText().length() > 25){
            this.setRightAnchor(this.Messagetext,40.0);}
            */


    }
}
