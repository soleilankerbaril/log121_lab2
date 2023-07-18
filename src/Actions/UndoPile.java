package Actions;

import java.util.LinkedList;

public class UndoPile {
    LinkedList<Operation> previousActions;

    public void addOperation(Operation operation){
        previousActions.addLast(operation);
    }
    public Operation getLastOperation(){
        return previousActions.getLast();
    }
}
