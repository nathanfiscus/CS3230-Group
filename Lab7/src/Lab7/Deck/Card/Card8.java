package Lab7.Deck.Card;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Trevor on 9/30/2014.
 */
public class Card8 extends Card4 {

    public Card8(Card.Suits suit,String value){
        super(suit, value);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(super.getSuitColor());

        graphics2D.setFont(new Font("Arial", Font.BOLD, 65));

        graphics2D.drawString(super.getSuitSymbol(), 30, 142);
        graphics2D.drawString(super.getSuitSymbol(), 30, 199);
        graphics2D.drawString(super.getSuitSymbol(), 130, 142);
        graphics2D.drawString(super.getSuitSymbol(), 130, 199);
    }

    public static void main(String[] args) {
        final Card8 Queen = new Card8(Card.Suits.Diamonds,"8");

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(Queen);

        frame.pack();
        frame.setVisible(true);
    }
}
