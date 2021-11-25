package game;

import java.util.ArrayList;
import java.util.List;

import entity.Troop;
import entity.Unit;
import state.*;

public class StateHandler{
    private List<State> typestates;
    
    public StateHandler() {
        typestates = new ArrayList<>();
        addstate(new Normal());
    }

    public void addstate(State state) {
        typestates.add(state);
    }
    

    public State setState(String string) {
        for( State state : typestates){
            if (string.equals(state.toString())) return state;
        }
        return null;
    }

    public void updateState(Troop troop) {
        for(int i=0; i<troop.size(); i++){
            Unit unit = troop.get(i);
            if (unit.isalive() && !unit.state.toString().equals("Normal") && --unit.stateturns ==0){
                unit.changeState("Normal", 100000);
                unit.canperformaction = true;
            }
        }
    }
    
}