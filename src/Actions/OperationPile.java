package Actions;

import java.util.Stack;

public class OperationPile {
    Stack<Operation> ActionsStacks;

    public OperationPile(){
        ActionsStacks = new Stack<Operation>();
    }

    public void addOperation(Operation operation){
        ActionsStacks.add(operation);
    }
    public Operation getLastOperation(){
        if(!ActionsStacks.isEmpty()){
            return ActionsStacks.pop();
        }
        return null;
    }

    public void clearActions(){
        ActionsStacks.clear();
    }
}
