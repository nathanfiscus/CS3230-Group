package Lab8.Deck;

import Lab8.Deck.Cards.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Nathan on 10/9/2014.
 */
public class Deck {
    ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        for(int j = 0; j<Card.Suits.values().length-1; j++){
            for (int i = 0; i < 13; i++) {
                switch(i){
                    case 1:
                       deck.add(new Card1(Card.Suits.values()[j],"A"));
                        break;
                    case 2:
                        deck.add(new Card2(Card.Suits.values()[j],"2"));
                        break;
                    case 3:
                        deck.add(new Card3(Card.Suits.values()[j],"3"));
                        break;
                    case 4:
                        deck.add(new Card4(Card.Suits.values()[j],"4"));
                        break;
                    case 5:
                        deck.add(new Card5(Card.Suits.values()[j],"5"));
                        break;
                    case 6:
                        deck.add(new Card6(Card.Suits.values()[j],"6"));
                        break;
                    case 7:
                        deck.add(new Card7(Card.Suits.values()[j],"7"));
                        break;
                    case 8:
                        deck.add(new Card8(Card.Suits.values()[j],"8"));
                        break;
                    case 9:
                        deck.add(new Card9(Card.Suits.values()[j],"9"));
                        break;
                    case 10:
                        deck.add(new Card10(Card.Suits.values()[j],"10"));
                        break;
                    case 11:
                        deck.add(new Card1(Card.Suits.values()[j],"J"));
                        break;
                    case 12:
                        deck.add(new Card1(Card.Suits.values()[j],"Q"));
                        break;
                    case 13:
                        deck.add(new Card1(Card.Suits.values()[j],"K"));
                        break;
                    default:
                        break;
                }
            }
        }
        deck.add(new Card1(Card.Suits.Joker,"J"));
        deck.add(new Card1(Card.Suits.Joker,"J"));
    }

    public Deck(boolean addJokers){
        deck = new ArrayList<Card>();
        for(int j = 0; j<Card.Suits.values().length-1; j++){
            for (int i = 0; i < 13; i++) {
                switch(i){
                    case 1:
                        deck.add(new Card1(Card.Suits.values()[j],"A"));
                        break;
                    case 2:
                        deck.add(new Card2(Card.Suits.values()[j],"2"));
                        break;
                    case 3:
                        deck.add(new Card3(Card.Suits.values()[j],"3"));
                        break;
                    case 4:
                        deck.add(new Card4(Card.Suits.values()[j],"4"));
                        break;
                    case 5:
                        deck.add(new Card5(Card.Suits.values()[j],"5"));
                        break;
                    case 6:
                        deck.add(new Card6(Card.Suits.values()[j],"6"));
                        break;
                    case 7:
                        deck.add(new Card7(Card.Suits.values()[j],"7"));
                        break;
                    case 8:
                        deck.add(new Card8(Card.Suits.values()[j],"8"));
                        break;
                    case 9:
                        deck.add(new Card9(Card.Suits.values()[j],"9"));
                        break;
                    case 10:
                        deck.add(new Card10(Card.Suits.values()[j],"10"));
                        break;
                    case 11:
                        deck.add(new Card1(Card.Suits.values()[j],"J"));
                        break;
                    case 12:
                        deck.add(new Card1(Card.Suits.values()[j],"Q"));
                        break;
                    case 13:
                        deck.add(new Card1(Card.Suits.values()[j],"K"));
                        break;
                    default:
                        break;
                }
            }
        }
        if(addJokers) {
            deck.add(new Card1(Card.Suits.Joker, "J"));
            deck.add(new Card1(Card.Suits.Joker, "J"));
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card deal(){
       Card temp = deck.get(0);
       deck.remove(0);
       return temp;
    }

    public Card getCard(int index){
        return deck.get(index);
    }

    public void removeCard(int index){
        deck.remove(index);
    }

    public void removeCard(Card card){
        deck.remove(card);
    }

    public void addCard(Card card){
        deck.add(card);
    }

    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    public void insertCard(int index,Card card){
        deck.add(index,card);
    }

    public void clear(){
        deck.clear();
    }

    public int count(){
        return deck.size();
    }


}
