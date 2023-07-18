package Actions;

import java.util.LinkedList;

public class RedoPile {
    LinkedList<Operation> RedoActions;

    public void addOperation(Operation operation){
        RedoActions.addLast(operation);
    }
    public Operation getLastOperation(){
        return RedoActions.getLast();
    }
    public void clearActions(){
        RedoActions.clear();
    }
}
