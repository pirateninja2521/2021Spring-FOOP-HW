import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    public String name;
    public List<Card> hand;

    public Player(String name2) {
        this.name = name2;
        this.hand = new ArrayList<>();
    }

    public int leftCards(){
        return hand.size();
    }

    public void setHand(Card[] deck, int player){
        for (int i=0; i<13; i++){
            // System.out.println(deck[4*i+player].toString());
            String str = new String(deck[51 -4*i-player].toString());
            Card card = new Card(str);
            this.hand.add(card);
        }
        Collections.sort(this.hand);
    }

    public void printHand(){
        StringBuilder numbers = new StringBuilder();
        StringBuilder cards = new StringBuilder();
        for (int i = 0; i < leftCards(); i++) {
            String card = hand.get(i).toString();
            numbers.append(String.format("%"+(-card.length())+"s", i)).append(" ");
            cards.append(card).append(" ");
        }
        System.out.println(numbers.toString().stripTrailing());  // strip the trailing whitespaces
        System.out.println(cards.toString().stripTrailing()); // strip the trailing whitespaces
    }

    public void playCard(CardPattern pattern) {
        System.out.println("Player " + this.name + " plays a " + pattern + ".");
        for (int i=0; i<pattern.cards.size(); i++){
            if (this.hand.contains(pattern.cards.get(i))){
                this.hand.remove(pattern.cards.get(i));
            }
        }
        Collections.sort(this.hand);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
