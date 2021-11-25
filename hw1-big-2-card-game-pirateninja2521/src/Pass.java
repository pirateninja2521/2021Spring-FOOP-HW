import java.util.List;

public class Pass extends CardPattern{
    private static final Exception exception = null;

    public Pass(){
        return;
    }
    public Pass(List<Card> cards) throws Exception{
        if (cards == null){
            this.type = "pass";
            this.cards = cards;
        }
        else{
            throw exception;
        }
    } 

    public Pass makeNew(List<Card> cards) throws Exception{
        try{
            Pass newpass = new Pass(cards);
            return newpass;
        }
        catch(Exception exception){
            throw exception;
        }
            
    }

    public Card leadCard(){
        return this.cards.get(1);
    }
}
