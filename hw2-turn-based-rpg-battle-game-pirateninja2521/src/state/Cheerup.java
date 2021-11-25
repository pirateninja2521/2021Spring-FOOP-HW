package state;

import entity.Unit;

public class Cheerup extends State{

    public Cheerup(){
        this.name = "Cheerup";
    }
    @Override
    public void changeBehavior(Unit unit){
        unit.actionsChangeDamage(50);
    }
    public void removeEffect(Unit unit) {
        unit.actionsChangeDamage(-50);
    }
}
