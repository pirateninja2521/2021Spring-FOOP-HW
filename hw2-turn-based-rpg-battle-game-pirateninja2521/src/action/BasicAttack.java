package action;

import entity.Troop;
import entity.Unit;

public class BasicAttack extends Action{

    public BasicAttack(int damage) {
        super("Basic Attack", 0, damage);
    }

    @Override
    public void perform(Unit unit, Troop targets) {
        System.out.printf("%s attacks %s.\n", unit, targets.get(0));
        unit.costMP(MP);
        System.out.printf("%s causes %d damage to %s.\n", unit, + damage, targets.get(0));
        targets.get(0).takeDamage(damage);
    }
    
}
