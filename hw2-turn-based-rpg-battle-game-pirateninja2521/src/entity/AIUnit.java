package entity;

import java.util.ArrayList;
import java.util.List;

import action.Action;
import game.ActionsHandler;
import utils.Inputs;

public class AIUnit extends Unit{

    public AIUnit(){
        return ;
    }
    public AIUnit(Troop troop, String[] split) {
        super(troop, split);
    }
    public boolean checkrule(String string) {
        return !string.equals("Hero");
    }

    @Override
    public Unit getInstance(Troop troop, String[] split) {
        return new AIUnit(troop, split);
    }

    public Action selectAction() {
        System.out.print("Select an action:");
        List<Integer> numbers = new ArrayList<>();
        for (int j=0; j<actions.size(); j++){
            System.out.print(" ("+j+") "+ actions.get(j));
            if (actions.get(j).getMP() <= this.getMP()) 
                numbers.add(j);
        }   
        System.out.print("\n");
        int idx = Inputs.ai.selectAction(numbers);
        
        return actions.get(idx);
    }
    @Override
    public Troop selectTarget(Troop troop, int num) {
        Troop targets = new Troop();
        List<Integer> idxs = Inputs.ai.selectTarget(troop.aliveNum(), num);
        
        List<Unit> tempunits = new ArrayList<>();
        for(int i=0; i<troop.size(); i++){
            if (troop.get(i).isalive()){
                tempunits.add(troop.get(i));   
            }
        }
        for(int i=0; i<num; i++) targets.addUnit(tempunits.get(idxs.get(i)));
        return targets;
    }
}
