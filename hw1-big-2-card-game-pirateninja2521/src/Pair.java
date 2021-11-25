import java.util.List;

public class Pair extends CardPattern{
    private static final Exception exception = null;

    public Pair(){
        return;
    }
    public Pair(List<Card> cards) throws Exception{
        if (cards.size() == 2 && cards.get(0).rank.equals(cards.get(1).rank)){
            this.type = "pair";
            this.cards = cards;
        }
        else{
            throw exception;
        }
    } 

    public Pair makeNew(List<Card> cards) throws Exception{
        try{
            Pair newpair = new Pair(cards);
            return newpair;
        }
        catch(Exception exception){
            throw exception;
        }
            
    }

    public Card leadCard(){
        return this.cards.get(1);
    }
}
