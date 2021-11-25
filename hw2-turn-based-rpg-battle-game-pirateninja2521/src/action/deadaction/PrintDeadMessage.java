package action.deadaction;

import entity.Unit;

public class PrintDeadMessage extends DeadAction{

    public PrintDeadMessage(){
        this.name = "Message";
    }
    @Override
    public DeadAction getInstance(Unit actionunit) {
        return new PrintDeadMessage();
    }

    @Override
    public void perform(Unit unit) {
        System.out.printf("%s dies.\n", unit);
    }
    
}
