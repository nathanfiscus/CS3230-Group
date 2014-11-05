package Lab7.Deck.Card;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 9/30/2014.
 */
public class Card7 extends Card6 {

    public Card7(Card.Suits suit,String value){
        super(suit, value);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(super.getSuitColor());

        graphics2D.setFont(new Font("Arial", Font.BOLD, 65));

        graphics2D.drawString(super.getSuitSymbol(), 80, 128);

    }

    public static void main(String[] args) {
        final Card7 Queen = new Card7(Suits.Diamonds,"7");

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(Queen);

        frame.pack();
        frame.setVisible(true);
    }
}
