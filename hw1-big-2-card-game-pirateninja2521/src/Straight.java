import java.util.List;

public class Straight extends CardPattern{
    private static final Exception exception = null;

    public Straight(){
        return;
    }
    public Straight(List<Card> cards) throws Exception{
        if (cards.size() != 5)
            throw exception;

        outerloop:
        for (int i=0; i<5; i++){
            for (int j=0; j<4; j++){
                if (((cards.get((i+j)%5).getRankNum()+1)%13) != cards.get((i+j+1)%5).getRankNum() ){
                    continue outerloop;
                }
            }
            this.type = "straight";
            this.cards = cards;
            return;
        }
        throw exception;
    } 

    public Straight makeNew(List<Card> cards) throws Exception{
        try{
            Straight newStraight = new Straight(cards);
            return newStraight;
        }
        catch(Exception exception){
            throw exception;
        }
            
    }

    public Card leadCard(){
        return this.cards.get(4);
    }
}
