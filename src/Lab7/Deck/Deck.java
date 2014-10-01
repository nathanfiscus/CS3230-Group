package Lab7.Deck;

import Lab7.Deck.Card.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Nathan on 9/23/2014.
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

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card deal(){
       Card temp = deck.get(0);
       deck.remove(0);
       return temp;
}

}
