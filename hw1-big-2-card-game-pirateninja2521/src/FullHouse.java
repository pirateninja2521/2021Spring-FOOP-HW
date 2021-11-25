import java.util.List;

public class FullHouse extends CardPattern{
    private static final Exception exception = null;

    public FullHouse(){
        return;
    }
    public FullHouse(List<Card> cards) throws Exception{
        if (cards.size() != 5)
            throw exception;

        this.type = "full house";
        this.cards = cards;
        if (cards.get(0).getRankNum() == cards.get(2).getRankNum() && cards.get(3).getRankNum() == cards.get(4).getRankNum())
            return;
        if (cards.get(0).getRankNum() == cards.get(1).getRankNum() && cards.get(2).getRankNum() == cards.get(4).getRankNum())
            return;
        throw exception;
    } 

    public FullHouse makeNew(List<Card> cards) throws Exception{
        try{
            FullHouse newFullHouse = new FullHouse(cards);
            return newFullHouse;
        }
        catch(Exception exception){
            throw exception;
        }
    }

    public Card leadCard(){
        if (cards.get(0).getRankNum() == cards.get(2).getRankNum() && cards.get(3).getRankNum() == cards.get(4).getRankNum())
            return this.cards.get(2);
        else 
            return this.cards.get(4);
    }
}
