package Actions;

import java.util.LinkedList;
import java.util.Stack;

public class RedoPile {
    Stack<Operation> RedoActions;

    public RedoPile(){
        RedoActions = new Stack<Operation>();
    }

    public void addOperation(Operation operation){
        RedoActions.add(operation);
    }
    public Operation getLastOperation(){
        if(!RedoActions.isEmpty()){
            return RedoActions.pop();
        }
        return null;
    }
    public void clearActions(){
        RedoActions.clear();
    }
}
