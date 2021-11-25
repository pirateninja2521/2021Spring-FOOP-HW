package action;

import entity.Troop;
import entity.Unit;

public class Summon extends Skill{

    public Summon() {
        super("Summon", 150, 0);
    }
    
    @Override
    public Troop selectTarget(Unit unit, Troop troop) {
        return null;
    }
    
    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        String line = "Slime 100 0 50";
        unit.troop.addUnit(line);
    }
}
