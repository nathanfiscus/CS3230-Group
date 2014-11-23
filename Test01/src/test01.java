/**
 * Created by Trevor on 11/4/2014.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class test01 extends Application {
    private Stage primaryStage;
    private Pane rootPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(getRootPane(), 400, 400, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.DARKGREEN);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();


    }

    private Pane getRootPane() {

        Menu menu = new Menu();
        menu.setText("Trevor");

        if (null == rootPane) {
            rootPane = new Pane();
            rootPane.setId("rootPanel");

            final Label myLabel = new Label("TREVOR");
            myLabel.setTranslateX(250);
            myLabel.setTranslateY(200);

            final CheckBox myCheckbox = new CheckBox();
            myCheckbox.setTranslateX(100);
            myCheckbox.setTranslateY(100);

            final MenuBar myMenu = new MenuBar();
            myMenu.getMenus().add(menu);

            final Button myButton = new Button("Trevor's Button");
            myButton.setTranslateX(150);
            myButton.setTranslateY(200);
            myButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (myLabel.getText() == "ANDERSON"){
                        myLabel.setText("TREVOR");
                        myButton.setTextFill(Color.CRIMSON);

                    }

                    else if (myLabel.getText() == "TREVOR"){
                        myLabel.setText("ANDERSON");
                        myButton.setTextFill(Color.BLACK);
                    }
                }

            });

            rootPane.getChildren().addAll(myButton, myLabel, myCheckbox);
            return rootPane;

        }
        return null;
    }
}
