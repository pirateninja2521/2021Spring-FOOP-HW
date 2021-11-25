package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import action.*;
import action.deadaction.DeadAction;
import action.deadaction.PrintDeadMessage;
import game.RPG;
import state.*;

public abstract class Unit {
    public boolean canperformaction;
    private String name;
    private int HP, MP, STR;
    protected List<Action> actions;
    public State state;
    private Set<DeadAction> deadactions;
    
    public Troop troop;
    public int stateturns;

    public Unit(){
        return;
    }
    public Unit(Troop troop, String[] split) {
        this.troop = troop;
        this.name = "["+troop.index+"]"+split[0];
        this.HP = Integer.valueOf(split[1]);
        this.MP = Integer.valueOf(split[2]);
        this.STR = Integer.valueOf(split[3]);
        changeState("Normal", 100000);
        this.canperformaction = true;
        this.actions = new ArrayList<>();
        this.actions.add(new BasicAttack(this.STR));
        this.deadactions = new HashSet<>();
        this.deadactions.add(new PrintDeadMessage());
        for (int i = 4; i<split.length; i++){
            this.actions.add(RPG.actionhandler.stringToSkill(split[i]));
        }
    }

    public abstract Unit getInstance(Troop troop, String[] split);

    public abstract boolean checkrule(String string);

    public abstract Action selectAction();

    public void takeTurn(Troop myTroop, Troop enemyTroop, boolean b) {
        if (!this.isalive()) return;
        System.out.printf("%s's turn (HP: %d, MP: %d, STR: %d, State: %s).\n", this, HP, MP, STR, state);
        state.changeBehavior(this);
        if (this.canperformaction){
            Action action = this.selectAction();
            Troop targets = action.selectTarget(this, enemyTroop);
            action.perform(this, targets);
        }
        state.removeEffect(this);
    }
    public boolean isalive() {
		return this.HP > 0;
	}
    public abstract Troop selectTarget(Troop troop, int i);

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Unit))
            return false;
        Unit unit = (Unit) o;
            return unit.name.equals(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
    public int getHP() {
        return this.HP;
    }
    public int getMP() {
        return this.MP;
    }
    public void costMP(int cost) {
        this.MP -= cost;
    }
    public void takeDamage(int damage) {
        this.HP -= damage;
        if (this.HP <=0){
            this.canperformaction = false;
            for (DeadAction action: deadactions){
                action.perform(this);
            }
        } 
    }
    public void addHealth(int i) {
        this.HP += i;
    }
    public void changeState(String statename, int turns) {
        this.state = RPG.statehandler.setState(statename);
        this.stateturns = turns;
	}
    public void actionsChangeDamage(int i) {
        for (Action action : actions){
            action.changeDamage(i);
        }
    }
    public void addDeadAction(String string, Unit actionunit) {
        this.deadactions.add(RPG.actionhandler.setDeadAction(string, actionunit));
    }
}
