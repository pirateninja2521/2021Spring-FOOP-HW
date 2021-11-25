package action;

import entity.Troop;
import entity.Unit;

public class Petrochemical extends Skill{

    public Petrochemical() {
        super("Petrochemical", 100, -1);
        game.RPG.statehandler.addstate(new state.Petrochemical());
    }
    
    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        targets.get(0).changeState("Petrochemical", 3);
    }
    
}
