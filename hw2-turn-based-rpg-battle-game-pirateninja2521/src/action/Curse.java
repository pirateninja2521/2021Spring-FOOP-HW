package action;

import entity.Troop;
import entity.Unit;

public class Curse extends Skill{

    public Curse() {
        super("Curse", 100, -1);
        game.RPG.actionhandler.addDeadAction(new action.deadaction.Cursed(null));
    }
    
    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        targets.get(0).addDeadAction("Cursed", unit);
    }
}
