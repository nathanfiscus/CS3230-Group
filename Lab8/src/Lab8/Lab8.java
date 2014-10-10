package Lab8;

import Lab8.Deck.Cards.Card;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Nathan on 10/9/2014.
 */
public class Lab8 extends Application {
    private Stage primaryStage;
    private Pane rootPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(getRootPane(), 800, 600, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.DARKGREEN);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private Pane getRootPane() {
        if(null == rootPane) {
            rootPane = new Pane();
            rootPane.setId("rootPanel");
            ArrayList<Card> cards = new ArrayList<>();
            Card myCard = new Card(Card.Suits.Diamonds,"K",true);
            cards.add(myCard);

            rootPane.getChildren().addAll(cards);
        }

        return rootPane;
    }
}
