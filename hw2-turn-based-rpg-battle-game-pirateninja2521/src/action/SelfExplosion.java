package action;

import entity.Troop;
import entity.Unit;

public class SelfExplosion extends Skill{

    public SelfExplosion() {
        super("SelfExplosion", 200, 150);
    }
    
    @Override
    public Troop selectTarget(Unit unit, Troop enemytroop) {
        Troop targets = new Troop();
        if (unit.troop.index < enemytroop.index){
            for(int i=0; i<unit.troop.size(); i++)
                if (unit.troop.get(i).isalive() && !unit.troop.get(i).equals(unit))
                    targets.addUnit(unit.troop.get(i));
            for(int i=0; i<enemytroop.size(); i++)
                if (enemytroop.get(i).isalive())
                    targets.addUnit(enemytroop.get(i));
        }
        else{
            for(int i=0; i<enemytroop.size(); i++)
                if (enemytroop.get(i).isalive())
                    targets.addUnit(enemytroop.get(i));
            for(int i=0; i<unit.troop.size(); i++)
                if (unit.troop.get(i).isalive() && !unit.troop.get(i).equals(unit))
                    targets.addUnit(unit.troop.get(i));
        }
        
        return targets;
    }

    public void perform(Unit unit, Troop targets) {
        super.perform(unit, targets);
        unit.takeDamage(unit.getHP());
    }
    
}
