package Lab7.Deck.Card;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 9/23/2014.
 */
public class Card extends JComponent {
    public enum Suits{
        Hearts,
        Diamonds,
        Clubs,
        Spades,
        Joker
    }

    private Suits cardSuit;
    private String cornerValue;
    private Color suitColor;
    private String suitSymbol;

    public Card(Suits suit, String cornerValue){
        this.setPreferredSize(new Dimension(200,300));
        this.cardSuit = suit;
        this.cornerValue = cornerValue;

        switch(this.cardSuit.name()){
            case "Clubs":
                this.suitColor = Color.BLACK;
                this.suitSymbol = "♣";
                break;
            case "Spades":
                this.suitSymbol = "♠";
                this.suitColor = Color.BLACK;
                break;
            case "Diamonds":
                this.suitSymbol = "♦";
                this.suitColor = Color.RED;
                break;
            case "Hearts":
                this.suitSymbol = "♥";
                this.suitColor = Color.RED;
                break;
            case "Joker":
                this.suitSymbol = "";
                this.suitColor = Color.BLACK;
                break;
        }
    }

    public Color getSuitColor() {
        return suitColor;
    }

    public String getSuitSymbol() {
        return suitSymbol;
    }

    public String getCardValue(){
        return cornerValue;
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        //Card Background
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillRoundRect(0,0,200,300,20,20);

        GradientPaint background = new GradientPaint(10, 250, Color.WHITE,0,(float)getHeight(), Color.LIGHT_GRAY);
        graphics2D.setPaint(background);

        //graphics2D.setColor(Color.WHITE);
        graphics2D.fillRoundRect(2,2,196,296,20,20);

        graphics2D.setColor(this.suitColor);

        switch(this.cardSuit.name()) {
            case "Joker":
                graphics2D.setFont(new Font("Lucida Console", Font.BOLD, 24));
                graphics2D.drawString("J", 10, 35);
                graphics2D.drawString("O", 10, 55);
                graphics2D.drawString("K", 10, 75);
                graphics2D.drawString("E", 10, 95);
                graphics2D.drawString("R", 10, 115);
                //Bottom Right Corner
                graphics2D.setFont(new Font("Lucida Console", Font.BOLD, -24));
                graphics2D.drawString("J", 190, 260);
                graphics2D.drawString("O", 190, 240);
                graphics2D.drawString("K", 190, 220);
                graphics2D.drawString("E", 190, 200);
                graphics2D.drawString("R", 190, 180);
                break;
            default:
                //Top Left Corner
                graphics2D.setFont(new Font("Arial", Font.BOLD, 36));
                graphics2D.drawString(this.cornerValue, 10, 40);
                graphics2D.setFont(new Font("Arial", Font.BOLD, 24));
                graphics2D.drawString(this.suitSymbol, 15, 60);

                //Bottom Right Corner
                graphics2D.setFont(new Font("Arial", Font.BOLD, -36));
                graphics2D.drawString(this.cornerValue, 190, 260);
                graphics2D.setFont(new Font("Arial", Font.BOLD, -24));
                graphics2D.drawString(this.suitSymbol, 185, 240);
                break;
        }
    }

    public static void main(String[] args) {
        final Card myCard = new Card(Suits.Clubs,"J");

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(myCard);

        frame.pack();
        frame.setVisible(true);
    }
}
