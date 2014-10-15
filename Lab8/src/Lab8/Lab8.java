package Lab8;

import Lab8.Deck.Cards.Card;
import Lab8.Hand.Hand;
import javafx.application.Application;
import javafx.scene.Group;
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

            //Create the 1st hand
            ArrayList<Card> card1 = new ArrayList<>();
            card1.add(new Card(Card.Suits.Diamonds, "K", false));
            card1.add(new Card(Card.Suits.Diamonds,"Q",false));
            card1.add(new Card(Card.Suits.Diamonds,"5",false));
            card1.add(new Card(Card.Suits.Diamonds,"8",true));
            card1.add(new Card(Card.Suits.Diamonds,"10",true));

            Hand hand1 = new Hand(card1);
            hand1.setRotation(180.0);
            hand1.setXTranslation(275.0);
            hand1.setYTranslation(50);

            //Create the 2nd hand
            ArrayList<Card> card2 = new ArrayList<>();
            card2.add(new Card(Card.Suits.Spades, "K", false));
            card2.add(new Card(Card.Suits.Spades,"Q",false));
            card2.add(new Card(Card.Suits.Spades,"5",false));
            card2.add(new Card(Card.Suits.Spades,"8",true));
            card2.add(new Card(Card.Suits.Spades,"10",true));

            Hand hand2 = new Hand(card2);
            hand2.setRotation(270.0);
            hand2.setXTranslation(550.0);
            hand2.setYTranslation(275.0);

            //Create the 3rd hand
            ArrayList<Card> card3 = new ArrayList<>();
            card3.add(new Card(Card.Suits.Clubs, "K", false));
            card3.add(new Card(Card.Suits.Clubs,"Q",false));
            card3.add(new Card(Card.Suits.Clubs,"5",false));
            card3.add(new Card(Card.Suits.Clubs,"8",true));
            card3.add(new Card(Card.Suits.Clubs,"10",true));

            Hand hand3 = new Hand(card3);
            hand3.setRotation(90.0);
            hand3.setXTranslation(25.0);
            hand3.setYTranslation(275.0);

            //Create the 4th hand
            ArrayList<Card> card4 = new ArrayList<>();
            card4.add(new Card(Card.Suits.Hearts, "K", false));
            card4.add(new Card(Card.Suits.Hearts,"Q",false));
            card4.add(new Card(Card.Suits.Hearts,"5",false));
            card4.add(new Card(Card.Suits.Hearts,"8",true));
            card4.add(new Card(Card.Suits.Hearts,"10",true));

            Hand hand4 = new Hand(card4);
            hand4.setXTranslation(275.0);
            hand4.setYTranslation(500.0);

            rootPane.getChildren().addAll(hand1.getHand(), hand2.getHand(), hand3.getHand(), hand4.getHand());

        }

        return rootPane;
    }
}
