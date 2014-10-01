package Lab7;

import Lab7.Deck.Deck;

import java.awt.*;
import javax.swing.*;


public class Lab7 extends JFrame{
    public static void main(String[] args) {
        Deck myDeck = new Deck();
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        myDeck.shuffle();

        frame.add(myDeck.deal());
        frame.add(myDeck.deal());
        frame.add(myDeck.deal());
        frame.add(myDeck.deal());
        frame.add(myDeck.deal());

        frame.pack();
        frame.setVisible(true);


    }
}
