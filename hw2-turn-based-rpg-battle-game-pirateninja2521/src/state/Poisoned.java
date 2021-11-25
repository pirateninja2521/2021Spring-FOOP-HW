package state;

import entity.Unit;

public class Poisoned extends State{

    public Poisoned(){
        this.name = "Poisoned";
    }
    @Override
    public void changeBehavior(Unit unit) {
        unit.takeDamage(30);
    }

}
