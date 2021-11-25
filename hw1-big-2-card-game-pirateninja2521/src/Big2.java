import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Big2 {
    private static final Exception exception = null;
    public Card deck[] = new Card[52];
    public Player players[] = new Player[4];
    public static Card club3 = new Card("C[3]");
    private Round round;
    public List<CardPattern> selected_patterns;
    public boolean endgame = false;

    public Big2(Scanner scanner, List<CardPattern> selected_patterns){
        
        this.readDeck(scanner);
        this.setPlayer(scanner);
        this.selected_patterns = selected_patterns;
    }

    public void playgame(Scanner scanner) {
        this.round = new Round(this, scanner, this.findClub3PlayerIndex(), true);
        while(!this.endgame){
            this.round = new Round(this, scanner, this.round.topplayer_id, false);
        }
        this.printWinner();
    }

    private void readDeck(Scanner scanner){
        for(int i=0; i<52; i++){
            String input_card = scanner.next();
            this.deck[i] = new Card(input_card);
        }
        scanner.nextLine();
    }

    private void setPlayer(Scanner scanner){
        for(int i=0; i<4; i++){
            String name = scanner.nextLine();
            this.players[i] = new Player(name);
        }
        // Dealing cards to the players
        for(int i=0; i<4; i++)
            players[i].setHand(deck,i);
    }

    private int findClub3PlayerIndex(){
        for (int i=0; i<4; i++)
            if (players[i].hand.contains(club3))
                return i;
        return -1;
    }

    public static List<Card> readPlayedCards(Scanner scanner, Player players){
        String action = scanner.nextLine();
        String[] split = action.split(" ");
        int card_idx = Integer.valueOf(split[0]);
        if (card_idx == -1)
            return null;
        List<Card> cards  = new ArrayList<>();
        for(int i=0; i<split.length; i++){
            card_idx = Integer.valueOf(split[i]);
            cards.add(new Card(players.hand.get(card_idx).str));
        }
        return cards;
    }

    public CardPattern playedCards2Pattern(List<Card> playcards, CardPattern topcard_pattern) throws Exception{
        CardPattern current_pattern = new CardPattern();

        if (playcards==null) // pass 
            return selected_patterns.get(0).makeNew(playcards);
        
        Collections.sort(playcards);
        for (int i=1; i<selected_patterns.size(); i++){
            try{
                current_pattern = selected_patterns.get(i).makeNew(playcards);
                break;
            }
            catch(Exception exception){
                if (i == selected_patterns.size()-1)
                    throw exception;
            }
        }
        if (topcard_pattern != null && !topcard_pattern.type.equals(current_pattern.type))
            throw exception;
        if (topcard_pattern != null && current_pattern.leadCard().compareTo(topcard_pattern.leadCard())<0)
            throw exception;
        return current_pattern;
    }

    private void printWinner(){
        System.out.println("Game over, the winner is " + this.round.topplayer+ ".");
    }
}
