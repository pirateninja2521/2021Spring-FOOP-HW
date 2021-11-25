package action;

import entity.Troop;
import entity.Unit;

public abstract class Action {
    protected String name;
    protected Unit unit;
    protected int MP;
    protected String state;
    public int damage;

    public Action(String actionname, int MP,  int damage){
        this.name = actionname;
        this.MP = MP;
        this.state = null;
        this.damage = damage;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public int getMP(){
        return this.MP;
    }

    public Troop selectTarget(Unit unit, Troop troop) {
        Troop targets = new Troop();
        if (troop.aliveNum() == 1){
            for(int i=0; i<troop.size(); i++)
                if (troop.get(i).isalive())
                    targets.addUnit(troop.get(i));
        }
        else{
            targets = unit.selectTarget(troop, 1);
        }
        return targets;
    }

    public abstract void perform(Unit unit2, Troop targets);

    public void changeDamage(int i) {
        this.damage += i;
    }

}
