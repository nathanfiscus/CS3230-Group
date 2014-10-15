package Lab8.Deck.Cards;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by Nathan on 10/9/2014.
 */
public class Card10 extends Card8 {

    public Card10(Suits suit, String cornervalue){
        super(suit,cornervalue);
        paint();
    }

    public Card10(Suits suit, String cornervalue,boolean showface){
        super(suit,cornervalue,showface);
        paint();
    }

    private void paint(){

        //Top Face Value
        Text symbol;
        symbol = new Text(42, 55, this.getSuitSymbol());
        symbol.setFont(new Font(24));
        symbol.setStroke(this.getSuitColor());
        symbol.setFill(this.getSuitColor());
        this.addFrontNodes(symbol);

        symbol = new Text(42, 111, this.getSuitSymbol());
        symbol.setFont(new Font(24));
        symbol.setStroke(this.getSuitColor());
        symbol.setFill(this.getSuitColor());
        this.addFrontNodes(symbol);
    }
}
