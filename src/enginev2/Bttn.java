package enginev2;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;

public class Bttn {
    Button button;
    ButtonAction action;
    public Bttn(String s, String icon,double x, double y, ButtonAction a) {
        button = new Button(s);
        if (icon!=null) {
            button.setGraphic(new ImageView(new Image(getClass().getClassLoader().getResource(icon).toString())));
        }
        button.setLayoutX(x);
        button.setLayoutY(y);
        action = a;
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                action.action();
            }
        });
    }
    public Bttn(String s, double x, double y, ButtonAction a) {
        this(s,null,x,y,a);
    }
    public Bttn(String s,double x, double y) {
        this(s,null,x,y,null);
    }
    public void setAction(ButtonAction a) {
        action=a;
    }
    public void setX(double x) {
        button.setLayoutX(x);
    }
    public void setY(double y) {
        button.setLayoutY(y);
    }
    Button getButton() {
        return button;
    }
}