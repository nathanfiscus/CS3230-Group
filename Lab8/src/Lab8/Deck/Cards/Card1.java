package Lab8.Deck.Cards;

import javafx.scene.image.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by Nathan on 10/9/2014.
 */
public class Card1 extends Card {

    public Card1(Suits suit, String cornervalue){
        super(suit, cornervalue);
        paint();
    }

    public Card1(Suits suit, String cornervalue,boolean showface){
        super(suit,cornervalue,showface);
        paint();
    }

    private void paint(){
        Text valueTop;
        switch(this.getCornerValue()) {
            case "A":
                //Top Face Value
                valueTop = new Text(35, 90, this.getSuitSymbol());
                valueTop.setFont(new Font(48));
                valueTop.setStroke(this.getSuitColor());
                valueTop.setFill(this.getSuitColor());
                this.addFrontNodes(valueTop);
                break;
            case "K":
                Image imgKing = new Image("/Lab8/Deck/Cards/captainamerica.jpg",0,0,false,false);
                ImageView imgViewKing = new ImageView(imgKing);
                imgViewKing.setFitHeight(110);
                imgViewKing.setFitWidth(70);
                imgViewKing.setX(15);
                imgViewKing.setY(15);
                this.addFrontNodes(imgViewKing);
                break;
            case "Q":
                Image imgQueen = new Image("/Lab8/Deck/Cards/blackwidow.jpg",0,0,false,false);
                ImageView imgViewQueen = new ImageView(imgQueen);
                imgViewQueen.setFitHeight(100);
                imgViewQueen.setFitWidth(65);
                imgViewQueen.setX(15);
                imgViewQueen.setY(25);
                this.addFrontNodes(imgViewQueen);
            break;
            case "J":
                Image imgJack = new Image("/Lab8/Deck/Cards/IronMan.jpg",0,0,false,false);
                ImageView imgViewJack = new ImageView(imgJack);
                imgViewJack.setFitHeight(110);
                imgViewJack.setFitWidth(55);
                imgViewJack.setX(20);
                imgViewJack.setY(20);
                this.addFrontNodes(imgViewJack);
                break;
            case "Joker":
            default:
                Image imgJoker = new Image("/Lab8/Deck/Cards/Thor.jpg",0,0,false,false);
                ImageView imgViewJoker = new ImageView(imgJoker);
                imgViewJoker.setFitHeight(100);
                imgViewJoker.setFitWidth(65);
                imgViewJoker.setX(15);
                imgViewJoker.setY(25);
                this.addFrontNodes(imgViewJoker);
                break;
        }
    }
}
