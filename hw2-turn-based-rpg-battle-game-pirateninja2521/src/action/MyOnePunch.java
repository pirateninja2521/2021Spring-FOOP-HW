package action;
import tw.waterball.foop.hw2.provided.OnePunch;

import entity.OnePunchEvent;
import entity.Troop;
import entity.Unit;

public class MyOnePunch extends Skill{
    final OnePunch onePunch = new OnePunch();
    public MyOnePunch() {
        super("OnePunch", 180, 0);
    }
    
    public void perform(Unit unit, Troop targets) {
        printperform(unit, targets);
        onePunch.perform(new OnePunchEvent(targets.get(0), unit, this.damage));
    }
}
