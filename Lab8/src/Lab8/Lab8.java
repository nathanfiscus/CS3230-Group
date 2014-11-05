package Lab8;

import Lab8.Deck.Cards.Card;
import Lab8.Deck.Deck;
import Lab8.Hand.Hand;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Lab8 extends Application {
    private Stage primaryStage;
    private Pane rootPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(getRootPane(), 800, 700, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.DARKGREEN);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private Pane getRootPane() {

        if(null == rootPane) {
            rootPane = new Pane();
            rootPane.setId("rootPanel");
            Deck cardDeck = new Deck();
            cardDeck.shuffle();
            //Create the 1st hand
            ArrayList<Card> card1 = new ArrayList<>();
            card1.add(cardDeck.deal());
            card1.add(cardDeck.deal());
            card1.add(cardDeck.deal());
            card1.add(cardDeck.deal());
            card1.add(cardDeck.deal());
            card1.get(3).setFaceShown(true);
            card1.get(4).setFaceShown(true);

            Hand hand1 = new Hand(card1);
            hand1.setRotate(180.0);
            hand1.setTranslateX(275.0);
            hand1.setTranslateY(50);

            //Create the 2nd hand
            ArrayList<Card> card2 = new ArrayList<>();
            card2.add(cardDeck.deal());
            card2.add(cardDeck.deal());
            card2.add(cardDeck.deal());
            card2.add(cardDeck.deal());
            card2.add(cardDeck.deal());
            card2.get(3).setFaceShown(true);
            card2.get(4).setFaceShown(true);

            Hand hand2 = new Hand(card2);
            hand2.setRotate(270.0);
            hand2.setTranslateX(550.0);
            hand2.setTranslateY(275.0);

            //Create the 3rd hand
            ArrayList<Card> card3 = new ArrayList<>();
            card3.add(cardDeck.deal());
            card3.add(cardDeck.deal());
            card3.add(cardDeck.deal());
            card3.add(cardDeck.deal());
            card3.add(cardDeck.deal());
            card3.get(3).setFaceShown(true);
            card3.get(4).setFaceShown(true);

            Hand hand3 = new Hand(card3);
            hand3.setRotate(90.0);
            hand3.setTranslateX(25.0);
            hand3.setTranslateY(275.0);

            //Create the 4th hand
            ArrayList<Card> card4 = new ArrayList<>();
            card4.add(cardDeck.deal());
            card4.add(cardDeck.deal());
            card4.add(cardDeck.deal());
            card4.add(cardDeck.deal());
            card4.add(cardDeck.deal());
            card4.get(3).setFaceShown(true);
            card4.get(4).setFaceShown(true);

            Hand hand4 = new Hand(card4);
            hand4.setTranslateX(275.0);
            hand4.setTranslateY(500.0);

            rootPane.getChildren().addAll(hand1, hand2, hand3, hand4);

        }

        return rootPane;
    }
}
