package action.deadaction;

import entity.Unit;

public abstract class DeadAction {
    protected String name;
    @Override
    public String toString(){
        return this.name;
    }

    public abstract DeadAction getInstance(Unit actionunit);
    public abstract void perform(Unit unit);
}
