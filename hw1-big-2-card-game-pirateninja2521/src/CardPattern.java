import java.util.List;

public class CardPattern {

    public List<Card> cards;
    public String type;
    
    public Card leadCard(){
        return null;
    }

    @Override
    public String toString(){
        String out = new String(this.type);
        for (int i=0; i<this.cards.size(); i++){
            out = String.join( " ", out, this.cards.get(i).str);
        }
        return out;
    }

    public boolean hasType(String s) {
        return this.type.equals(s);
    }
    public boolean sameType(CardPattern p) {
        return this.type.equals(p.type);
    }
    public CardPattern makeNew(List<Card> cards) throws Exception {
        return null;
    }
    
}
