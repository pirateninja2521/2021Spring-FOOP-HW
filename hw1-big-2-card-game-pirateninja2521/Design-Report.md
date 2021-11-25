# Design Report
## Software Design
### Class Main
> - Create a **Big2** object with selected card patterns to run the game.
### Class Big2
> - Simulates the game flow.
> - First, setup the deck and playernames, and deal cards to the players. When the *playgame* method is called, it repeatly new a round object until a winner is determined. It also contains *playedCards2Pattern* method that recognizes the card pattern of a list of cards according to the selected patterns.
### Class Round
> - Controls the flow of a round.
> - At each turn, use method *readPlayedCards* and *playedCards2Pattern* of class **Big2** to identify the played cards, then determine whether played cards are valid or not. Recursively calls *continueRound* until three consecutive Pass have been received.
### Class Player
> - Maintain the hand of a player.
### Class Card
> - Stores the information of a card (rand & suit).
> - Define override methods *equal* and *compareTo*.
### Class CardPattern
> - The parent class of all following classes.
### Class Pass, Single, Pair, Straight, FullHouse
> - Child classes that extends class **CardPattern**, each representing a card pattern.
> - When an object is created with a list of cards as input, it throws exception if the list of cards doesn't satisfy the rule of the pattern.
## Bonus Design: Open-Closed Principle (OCP)
> In my design, the **Big2** class has a list of **CardPattern** objects as input, using it as the selected patterns of the game. When one wants to modify the selected patterns of a game, simply create a **Big2** object with preferable list of selected patterns, and this can be done by only modifying only Main (and writing new classes of prefered card patterns, following the structure of the parent class **CardPattern**)