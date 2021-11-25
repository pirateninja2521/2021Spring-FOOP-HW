import entity.*;
import game.RPG;
import action.*;

public class Main {
    public static void main(String[] args) {
        RPG.typeunits.add(new HeroUnit());
        RPG.typeunits.add(new AIUnit());

        RPG.actionhandler.addSkill(new Waterball());
        RPG.actionhandler.addSkill(new Fireball());
        RPG.actionhandler.addSkill(new SelfHealing());
        RPG.actionhandler.addSkill(new Petrochemical());
        RPG.actionhandler.addSkill(new Poison());
        RPG.actionhandler.addSkill(new Summon());
        RPG.actionhandler.addSkill(new SelfExplosion());
        RPG.actionhandler.addSkill(new Cheerup());
        RPG.actionhandler.addSkill(new Curse());
        RPG.actionhandler.addSkill(new MyOnePunch());
        Troop heroTroop = new Troop(1);
        Troop enemyTroop = new Troop(2);
        RPG newgame = new RPG(heroTroop, enemyTroop);
        newgame.startbattle();
    }
}
