package action.deadaction;

import entity.Unit;

public class Cursed extends DeadAction{
    private Unit actionunit;
    public Cursed(Unit actionunit){
        this.actionunit = actionunit;
        this.name = "Cursed";
    }
    @Override
    public Cursed getInstance(Unit actionunit) {
        return new Cursed(actionunit);
    }
    
    public void perform(Unit unit){
        actionunit.addHealth(unit.getMP());
    }
}
