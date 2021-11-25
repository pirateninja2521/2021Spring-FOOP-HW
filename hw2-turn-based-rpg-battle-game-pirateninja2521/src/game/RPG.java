package game;

import java.util.ArrayList;
import java.util.List;

import entity.*;

public class RPG {
    public Troop heroTroop, enemyTroop;
    public static ActionsHandler actionhandler = new ActionsHandler();
    public static List<Unit> typeunits = new ArrayList<>();
    public static StateHandler statehandler = new StateHandler();
    public RPG(Troop heroTroop2, Troop enemyTroop2){
        this.heroTroop = heroTroop2;
        this.enemyTroop = enemyTroop2;
    }

    public void startbattle() {
        label1:
        while (true){
            Unit currentunit;
            for(int i=0; i < heroTroop.size(); i++){
                currentunit = heroTroop.get(i);
                currentunit.takeTurn(heroTroop, enemyTroop, false);
                if (this.checkIfBattleIsOver()) break label1;
            }
            for(int i=0; i < enemyTroop.size(); i++){
                currentunit = enemyTroop.get(i);
                currentunit.takeTurn(enemyTroop, heroTroop, false);
                if (this.checkIfBattleIsOver()) break label1;
            }
            RPG.statehandler.updateState(heroTroop);
            RPG.statehandler.updateState(enemyTroop);
        }
    }

    private boolean checkIfBattleIsOver() {
        if (this.heroTroop.get(0).getHP() <= 0){
            System.out.println("You lose.");
            return true;
        }
        if (this.enemyTroop.aliveNum() == 0 ){
            System.out.println("You win.");
            return true;
        }  
        return false;
    }

}
