package Lab7.Deck.Card;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 9/25/2014.
 */
public class Card1 extends Card {

    public Card1(Card.Suits suit,String value){
        super(suit,value);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setColor(super.getSuitColor());

        if(super.getCardValue().equals("A")) {
            graphics2D.setFont(new Font("Arial", Font.BOLD, 65));
            graphics2D.drawString(super.getSuitSymbol(), 80, 171);
        }else {
            graphics2D.setStroke(new BasicStroke(3));
            graphics2D.drawRect(50,95,100,100);
            graphics2D.setColor(Color.GRAY);
            graphics2D.setFont(new Font("Arial", Font.BOLD, 100));
            graphics2D.drawString(super.getCardValue(), 65, 185);
            graphics2D.setColor(super.getSuitColor());
            graphics2D.setFont(new Font("Arial", Font.BOLD, 100));
            graphics2D.drawString(super.getCardValue(), 62, 182);
        }
    }

    public static void main(String[] args) {
        final Card1 Queen = new Card1(Suits.Hearts,"Q");
        final Card1 King = new Card1(Suits.Diamonds,"K");
        final Card1 Ace = new Card1(Suits.Spades,"A");
        final Card1 Jack = new Card1(Suits.Clubs,"J");
        final Card1 Joker = new Card1(Suits.Joker,"J");

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(Ace);
        frame.add(King);
        frame.add(Queen);
        frame.add(Jack);
        frame.add(Joker);
        frame.pack();
        frame.setVisible(true);
    }
}
