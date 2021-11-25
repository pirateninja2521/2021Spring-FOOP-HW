package entity;

import java.util.ArrayList;
import java.util.List;

import action.Action;
import utils.Inputs;

public class HeroUnit extends Unit{
    public HeroUnit(){
        return ;
    }
    public HeroUnit(Troop troop, String[] split) {
        super(troop, split);
    }

    @Override
    public boolean checkrule(String string) {
        return string.equals("Hero");
    }

    @Override
    public Unit getInstance(Troop troop, String[] split) {
        return new HeroUnit(troop, split);
    }

    @Override
    public Action selectAction() {
        while (true){
            System.out.printf("Select an action:", actions.size());
            
            for (int j=0; j<actions.size(); j++){
                System.out.printf(" (%d) %s", j, actions.get(j));
            }   
            System.out.print("\n");

            int idx = Integer.valueOf( Inputs.in.nextLine() );
            if (actions.get(idx).getMP() > this.getMP())
                System.out.println("You can't perform the action: insufficient MP.");
            else
                return actions.get(idx);
        }
    }
    @Override
    public Troop selectTarget(Troop troop, int num) {
        List<Integer> idxs = new ArrayList<>();
        Troop targets = new Troop();
        String line = Inputs.in.nextLine();
        String[] split = line.split(", ");
        for (int i=0; i<num; i++) idxs.add(Integer.valueOf(split[i]));

        System.out.printf("Select %d targets:", num);
        int cnt = 0;
        for(int i=0; i<troop.size(); i++){
            if (troop.get(i).isalive()){
                System.out.printf(" (%d) %s", cnt, troop.get(i));
                if (idxs.contains(cnt))
                    targets.addUnit(troop.get(i));
                cnt++;
            }
        }
        System.out.printf("\n");
        return targets;
    }
}
