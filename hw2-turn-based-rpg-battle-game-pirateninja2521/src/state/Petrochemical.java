package state;

import entity.Unit;

public class Petrochemical extends State{

    public Petrochemical() {
       this.name = "Petrochemical";
    }

    @Override
    public void changeBehavior(Unit unit) {
        unit.canperformaction = false;
    }

    public void removeEffect(Unit unit) {
        unit.canperformaction = true;
    }

}
