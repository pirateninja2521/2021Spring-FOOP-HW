package action;

import entity.Troop;
import entity.Unit;

public class Poison extends Skill{
    public Poison() {
        super("Poison", 80, -1);
        game.RPG.statehandler.addstate(new state.Poisoned());
    }
    
    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        targets.get(0).changeState("Poisoned", 3);
    }
    
}
