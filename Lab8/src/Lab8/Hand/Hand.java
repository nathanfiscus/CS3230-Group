package Lab8.Hand;

import Lab8.Deck.Cards.*;
import javafx.scene.Group;

import java.util.ArrayList;

/**
 * Created by Nathan on 10/9/2014.
 */
public class Hand {

    private ArrayList<Card> playerHand;

    public Hand(){
        playerHand = new ArrayList<Card>();
    }

    public Hand(ArrayList<Card> cards){
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

    }
}
