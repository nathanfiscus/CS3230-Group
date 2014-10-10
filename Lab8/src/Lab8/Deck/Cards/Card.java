package Lab8.Deck.Cards;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by Nathan on 10/9/2014.
 */
public class Card extends Group {

    public enum Suits{
        Hearts,
        Diamonds,
        Clubs,
        Spades,
        Joker
    }

    private Rectangle cardBG;
    private Group frontGroup;
    private Group backGroup;
    private Suits cardSuit;
    private String cornerValue;
    private boolean showFace;

    public Card(Suits suit, String cornervalue){
        frontGroup = new Group();
        backGroup = new Group();
        this.cardSuit = suit;
        this.cornerValue = cornervalue;
        this.showFace=false;
        frontGroup.setVisible(false);
        backGroup.setVisible(true);
        paint();
    }

    public Card(Suits suit, String cornervalue,boolean showface){
        frontGroup = new Group();
        backGroup = new Group();
        this.cardSuit = suit;
        this.cornerValue = cornervalue;
        this.showFace = showface;
        if(!showFace){
            frontGroup.setVisible(false);
            backGroup.setVisible(true);
        }else{
            frontGroup.setVisible(true);
            backGroup.setVisible(false);
        }
        paint();
    }

    public String getSuitSymbol() {
        switch (this.cardSuit.name()) {
            case "Clubs":
                return "♣";
            case "Spades":
                return "♠";
            case "Diamonds":
                return "♦";
            case "Hearts":
                return "♥";
            case "Joker":
            default:
                return "";
        }
    }

    public Color getSuitColor(){
        switch(this.cardSuit.name()){
            case "Diamonds":
            case "Hearts":
                return Color.RED;
            case "Clubs":
            case "Spades":
            case "Joker":
            default:
                return Color.BLACK;
        }
    }

    public Suits getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(Suits cardSuit) {
        this.cardSuit = cardSuit;
    }

    public String getCornerValue() {
        return cornerValue;
    }

    public void setCornerValue(String cornerValue) {
        this.cornerValue = cornerValue;
    }

    public boolean isFaceShown() {
        return showFace;
    }

    public void setFaceShown(boolean showFace) {
        this.showFace = showFace;
        if(!showFace){
            getChildren().get(getChildren().indexOf(frontGroup)).setVisible(false);
            getChildren().get(getChildren().indexOf(backGroup)).setVisible(true);
        }else{
            getChildren().get(getChildren().indexOf(frontGroup)).setVisible(true);
            getChildren().get(getChildren().indexOf(backGroup)).setVisible(false);
        }

    }

    protected void addFrontNodes(Node ... elements){
        ((Group) getChildren().get(getChildren().indexOf(frontGroup))).getChildren().addAll(elements);
    }

    private void paint(){
        cardBG = new Rectangle(100,150);
        cardBG.setArcWidth(10);
        cardBG.setArcHeight(10);
        cardBG.setFill(Color.WHITE);
        cardBG.setStroke(Color.BLACK);
        //Back of Card
        Rectangle cardBack = new Rectangle(100,150);
        cardBack.setArcWidth(10);
        cardBack.setArcHeight(10);
        cardBack.setFill(Color.CORNFLOWERBLUE);
        cardBack.setStroke(Color.ORANGE);
        cardBack.setStrokeWidth(5);
        //Top Face Value
        Text valueTop = new Text(5, 18, this.getCornerValue());
        valueTop.setFont(new Font(18));
        valueTop.setStroke(this.getSuitColor());
        valueTop.setFill(this.getSuitColor());
        //Top Suit Symbol
        Text suitTop = new Text(5, 32, this.getSuitSymbol());
        suitTop.setFont(new Font(14));
        suitTop.setStroke(this.getSuitColor());
        suitTop.setFill(this.getSuitColor());
        //Bottom Face Value
        Text valueBottom = new Text(85, 145, this.getCornerValue());
        valueBottom.setFont(new Font(18));
        valueBottom.setStroke(this.getSuitColor());
        valueBottom.setFill(this.getSuitColor());
        valueBottom.setRotate(180);
        //Bottom Suit Symbol
        Text suitBottom = new Text(85, 126, this.getSuitSymbol());
        suitBottom.setFont(new Font(14));
        suitBottom.setStroke(this.getSuitColor());
        suitBottom.setFill(this.getSuitColor());
        suitBottom.setRotate(180);
        frontGroup.getChildren().addAll(valueTop, suitTop, valueBottom, suitBottom);
        backGroup.getChildren().addAll(cardBack);
        getChildren().addAll(cardBG, frontGroup, backGroup);
    }




}
