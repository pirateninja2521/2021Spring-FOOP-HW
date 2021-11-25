package state;

import entity.Unit;

public abstract class State {
    protected String name;
    @Override
    public String toString(){
        return this.name;
    }
    public abstract void changeBehavior(Unit unit);
    public void removeEffect(Unit unit) {
    }
    
}
