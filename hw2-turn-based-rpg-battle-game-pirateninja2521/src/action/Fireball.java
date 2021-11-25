package action;

import entity.Troop;
import entity.Unit;

public class Fireball extends Skill{
    public Fireball(){
        super("Fireball", 50, 50);
    }
    
    @Override
    public Troop selectTarget(Unit unit, Troop troop) {
        Troop targets = new Troop();
        for(int i=0; i<troop.size(); i++)
            if (troop.get(i).isalive())
                targets.addUnit(troop.get(i));
        return targets;
    }

}
