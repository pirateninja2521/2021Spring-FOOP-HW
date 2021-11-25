import java.util.List;
import java.util.Scanner;

public class Round {
    public Big2 big2;
    Player topplayer;
    int topplayer_id;
    
    public Round(Big2 big2, Scanner scanner, int player_id, boolean gamestart){
        this.big2 = big2;
        this.topplayer = big2.players[player_id];
        System.out.println("New round begins.");
        System.out.println("Next turn: "+ topplayer.name);
        List<Card> played_cards;
        while(true){
            topplayer.printHand();
            CardPattern played_card_pattern;
            try{
                played_cards = Big2.readPlayedCards(scanner, topplayer);
                played_card_pattern = big2.playedCards2Pattern(played_cards, null);
            }
            catch(Exception exception){
                System.out.println("Invalid play, please try again.");
                continue;
            }
            if (played_card_pattern.hasType("pass")){
                System.out.println("You can't pass in the new round.");
                continue;
            }
            if (gamestart && !played_cards.contains(Big2.club3)){
                System.out.println("Invalid play, please try again.");
                continue;
            }
            topplayer.playCard(played_card_pattern);
            if (topplayer.hand.size() == 0){
                this.big2.endgame = true;
                break;
            }
            topplayer_id = continueRound((player_id+1)%4, scanner, played_card_pattern, 0);
            this.topplayer = big2.players[topplayer_id];

            break;
        }
    }

    private int continueRound(int player_id, Scanner scanner, CardPattern topcard_pattern, int passed_cnt) {
        if (passed_cnt == 3){ // all other players passed
            return player_id;
        }
        Player topplayer = big2.players[player_id];
        System.out.println("Next turn: "+ topplayer.name);
        
        List<Card> played_cards;
        while(true){
            topplayer.printHand();
            CardPattern played_card_pattern;
            try{
                played_cards = Big2.readPlayedCards(scanner, topplayer);
                if (played_cards == null){
                }
                // System.out.println("Size :"+ played_cards.size());
                played_card_pattern = big2.playedCards2Pattern(played_cards, topcard_pattern);
            }
            catch(Exception exception){
                System.out.println("Invalid play, please try again.");
                continue;
            }
            if (played_card_pattern.hasType("pass")){
                System.out.println("Player " + topplayer.name + " passes.");
                return continueRound((player_id+1)%4, scanner, topcard_pattern, passed_cnt+1);
            }
            else if (!topcard_pattern.sameType(played_card_pattern)){
                System.out.println("Invalid play, please try again.");
                continue;
            }
            // object1.getClass().equals( object2.getClass())
            topplayer = big2.players[player_id];
            topplayer.playCard(played_card_pattern);
            if (topplayer.hand.size() == 0){
                this.big2.endgame = true;
                return player_id;
            }
            return continueRound((player_id+1)%4, scanner, played_card_pattern, 0);
        }
    }

}
