import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The big-2 game will be started from the Main class.
 */

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        List<CardPattern> selected_patterns = new ArrayList<>();
        selected_patterns.add(new Pass());
        selected_patterns.add(new Single());
        selected_patterns.add(new Pair());
        selected_patterns.add(new Straight());
        selected_patterns.add(new FullHouse());

        Big2 game = new Big2(scanner, selected_patterns);
        game.playgame(scanner);
    }
}
