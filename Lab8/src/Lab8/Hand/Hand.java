package Lab8.Hand;

import Lab8.Deck.Cards.*;
import javafx.scene.Group;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> playerHand;
    public Group displayHand;

    public Hand(){
        playerHand = new ArrayList<Card>();
    }

    public Hand(ArrayList<Card> cards){
        displayHand = new Group();
        playerHand = new ArrayList<Card>(cards);

    }

    public Card getCard(int index){
        return playerHand.get(index);
    }

    public void removeCard(int index){
        playerHand.remove(index);
    }

    public void removeCard(Card card){
        playerHand.remove(card);
    }

    public void addCard(Card card){
        playerHand.add(card);
    }

    public void addCards(ArrayList<Card> cards){
        playerHand.addAll(cards);
    }

    public void insertCard(int index,Card card){
        playerHand.add(index,card);
    }

    public void clear(){
        playerHand.clear();
    }

    public int count(){
        return playerHand.size();
    }

    public void getHandValue(){

    }

    private void getHighestHand(){

    }

    public Group getHand(){

        double displayAngle = -30.0;
        double displayPositionX = 0.0;

        for( int i = 0; i < playerHand.size(); i++){
            playerHand.get(i).setRotate(displayAngle);
            playerHand.get(i).setTranslateX(displayPositionX);;

            displayHand.getChildren().add(playerHand.get(i));

            displayAngle += 15.0;
            displayPositionX += 35.0;
        }

        return displayHand;
    }

    public void setRotation(double rotate){
        displayHand.setRotate(rotate);
    }

    public void setXTranslation(double xTranslation){
        displayHand.setTranslateX(xTranslation);
    }

    public void setYTranslation(double yTranslation){
        displayHand.setTranslateY(yTranslation);
    }
}