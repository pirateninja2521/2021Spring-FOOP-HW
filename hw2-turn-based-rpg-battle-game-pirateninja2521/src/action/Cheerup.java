package action;

import entity.Troop;
import entity.Unit;

public class Cheerup extends Skill{
    public Cheerup() {
        super("Cheerup", 100, -1);
        game.RPG.statehandler.addstate(new state.Cheerup());
    }
    
    @Override
    public Troop selectTarget(Unit unit, Troop troop) {
        Troop targets = new Troop();
        for(int i=0; i<unit.troop.size(); i++)
            if (unit.troop.get(i).isalive() && !unit.troop.get(i).equals(unit))
                targets.addUnit(unit.troop.get(i));
        if (targets.aliveNum() <= 3){
            return targets;
        }
        else{
            return unit.selectTarget(targets, 3);
        }
    }

    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        for (int i=0; i<targets.size(); i++)
            targets.get(i).changeState("Cheerup", 3);
    }
    
}
