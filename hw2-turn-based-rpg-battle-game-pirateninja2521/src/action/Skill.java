package action;

import entity.Troop;
import entity.Unit;

public abstract class Skill extends Action{

    public Skill(String actionname, int MP,  int damage){
        super(actionname, MP, damage);
    }

    protected void printperform(Unit unit, Troop targets){
        unit.costMP(MP);
        System.out.printf("%s uses %s", unit, this);
        if (targets == null) System.out.printf(".\n");
        else{
            System.out.printf(" on %s", targets.get(0));
            for(int i=1; i<targets.size(); i++)
                System.out.printf(", %s", targets.get(i));
            System.out.println(".");
        } 
        
    }
    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        for(int i=0; i<targets.size(); i++){
            System.out.printf("%s causes %d damage to %s.\n", unit, + damage, targets.get(i));
            targets.get(i).takeDamage(damage);
        }    
    }
}
