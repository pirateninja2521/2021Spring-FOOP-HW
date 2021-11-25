import java.util.List;

public class Single extends CardPattern{
    private static final Exception exception = null;

    public Single(){
        return;
    }

    public Single(List<Card> cards) throws Exception{
        if (cards.size() != 1){
            throw exception;
        }
        this.type = "single";
        this.cards = cards;
    }
    public Single makeNew(List<Card> cards) throws Exception{
        try{
            Single newpair = new Single(cards);
            return newpair;
        }
        catch(Exception exception){
            throw exception;
        }
            
    }
    public Card leadCard(){
        return this.cards.get(0);
    }
}
