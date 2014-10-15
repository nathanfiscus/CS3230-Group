package Lab8.Hand;

import Lab8.Deck.Cards.*;
import javafx.scene.Group;

import java.util.ArrayList;

public class Hand extends Group{

    private ArrayList<Card> playerHand;
    //public Group displayHand;

    public Hand(){
        playerHand = new ArrayList<Card>();
    }

    public Hand(ArrayList<Card> cards){
        playerHand = new ArrayList<Card>(cards);
        draw();
    }

    public Card getCard(int index){
        return playerHand.get(index);
    }

    public void removeCard(int index){
        playerHand.remove(index);
        draw();
    }

    public void removeCard(Card card){
        playerHand.remove(card);
        draw();
    }

    public void addCard(Card card){
        playerHand.add(card);
        draw();
    }

    public void addCards(ArrayList<Card> cards){
        playerHand.addAll(cards);
        draw();
    }

    public void insertCard(int index,Card card){
        playerHand.add(index,card);
        draw();
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

    private void draw(){
        double displayAngle = -30.0;
        double displayPositionX = 0.0;

        for( int i = 0; i < playerHand.size(); i++){
            playerHand.get(i).setRotate(displayAngle);
            playerHand.get(i).setTranslateX(displayPositionX);;

            this.getChildren().add(playerHand.get(i));

            displayAngle += 15.0;
            displayPositionX += 35.0;
        }
    }

}