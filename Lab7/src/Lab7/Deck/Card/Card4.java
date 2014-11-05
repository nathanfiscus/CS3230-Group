package Lab7.Deck.Card;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 9/26/2014.
 */
public class Card4 extends Card{

    public Card4(Card.Suits suit,String value){
        super(suit, value);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(super.getSuitColor());

        graphics2D.setFont(new Font("Arial", Font.BOLD, 65));
        graphics2D.drawString(super.getSuitSymbol(), 30, 86);
        graphics2D.drawString(super.getSuitSymbol(), 30, 255);
        graphics2D.drawString(super.getSuitSymbol(), 130, 86);
        graphics2D.drawString(super.getSuitSymbol(), 130, 255);
    }

    public static void main(String[] args) {
        final Card4 Queen = new Card4(Card.Suits.Diamonds,"4");

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(Queen);

        frame.pack();
        frame.setVisible(true);
    }
}
