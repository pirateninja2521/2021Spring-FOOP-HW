package entity;

import java.util.ArrayList;
import java.util.List;

import game.RPG;
import utils.Inputs;

public class Troop {
    public int index;

    private List<Unit> units;

    public Troop(){
        this.units = new ArrayList<>();
    }
    public Troop(int index) {
        this.index = index;
        this.units = new ArrayList<>();
        String line = Inputs.in.nextLine(); // #START-TROOP
        line = Inputs.in.nextLine();
        while (!line.startsWith("#END-TROOP")){
            this.addUnit(line);
            line = Inputs.in.nextLine();
        }
        index++;
    }

    public int size() {
        return units.size();
    }
    public Unit get(int i) {
        return units.get(i);
    }
    public int aliveNum(){
        int cnt=0;
        for (int i=0; i<size(); i++)
            if (get(i).isalive()) cnt++;
        return cnt;
    }

    public void addUnit(String line){
        String[] split = line.split(" ");
        for(Unit typeunit: RPG.typeunits){
            if (typeunit.checkrule(split[0])){
                Unit newunit = typeunit.getInstance(this, split);
                this.units.add(newunit);
            }
        }
    }
    public void addUnit(Unit unit) {
        this.units.add(unit);
    }
    public List<Unit> getUnits() {
        return this.units;
    }

}
