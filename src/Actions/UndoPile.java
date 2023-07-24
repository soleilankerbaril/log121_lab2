package Actions;

import java.util.LinkedList;
import java.util.Stack;

public class UndoPile {
    Stack<Operation> previousActions;

    public UndoPile(){
        previousActions = new Stack<Operation>();
    }

    public void addOperation(Operation operation){
        previousActions.add(operation);
    }
    public Operation getLastOperation(){
        if(!previousActions.isEmpty()){
            return previousActions.pop();
        }
        return null;
    }
}
