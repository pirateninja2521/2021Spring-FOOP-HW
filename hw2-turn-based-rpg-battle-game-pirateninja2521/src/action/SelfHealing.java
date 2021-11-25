package action;

import entity.Troop;
import entity.Unit;

public class SelfHealing extends Skill{

    public SelfHealing() {
        super("SelfHealing", 50, -1);
    }

    @Override
    public Troop selectTarget(Unit unit, Troop troop) {
        return null;
    }
    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        
        unit.addHealth(150);
    }
    
}
