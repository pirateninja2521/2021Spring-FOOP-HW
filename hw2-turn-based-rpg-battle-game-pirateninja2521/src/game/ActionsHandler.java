package game;

import java.util.ArrayList;
import java.util.List;

import action.Skill;
import action.deadaction.DeadAction;
import entity.Unit;

public class ActionsHandler {
    private List<Skill> typeskills;
    private List<DeadAction> typedeadactions;
    public ActionsHandler(){
        this.typeskills = new ArrayList<>();
        typedeadactions = new ArrayList<>();
    }

    public void addDeadAction(DeadAction action) {
        typedeadactions.add(action);
    }

    public Skill stringToSkill(String str){
        for(int j=0; j<typeskills.size(); j++){
            if(typeskills.get(j).toString().equals(str))
                return typeskills.get(j);
        }
            
        return null;
    }
    
    public void addSkill(Skill action){
        this.typeskills.add(action);
    }


    public DeadAction setDeadAction(String string, Unit actionunit) {
        for( DeadAction action: typedeadactions){
            if (string.equals(action.toString())) {
                return action.getInstance(actionunit);
            }
        }
        return null;
    }
}
