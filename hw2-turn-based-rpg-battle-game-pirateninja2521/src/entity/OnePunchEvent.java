package entity;
import action.MyOnePunch;
import tw.waterball.foop.hw2.provided.Target;

public class OnePunchEvent implements Target{
    Unit targetunit, actionunit;
    int bonusdamage;

    public OnePunchEvent(Unit targetunit2, Unit actionunit2, int bonusdamage){
        this.targetunit = targetunit2;
        this.actionunit = actionunit2;
        this.bonusdamage = bonusdamage;
    }

    public void takeOnePunchDamage(int damage) {
        System.out.printf("%s causes %d damage to %s.\n", actionunit, damage + bonusdamage, targetunit);
        targetunit.takeDamage(damage + bonusdamage);
    }
}
