package Actions;

import java.util.Stack;

/**
 * OperationPile serves to add actions states, save actions states
 * and get previous action states
 */
public class OperationPile {
    Stack<Operation> ActionsStacks;

    public OperationPile(){
        ActionsStacks = new Stack<Operation>();
    }

    /**
     * Adds an operation to the stack enabling the possibility
     * to undo or redo changes in the future.
     * @param operation
     */
    public void addOperation(Operation operation){
        ActionsStacks.add(operation);
    }

    /**
     * Returns the last state that was saved to the stack
     * @return Operation
     */
    public Operation getLastOperation(){
        if(!ActionsStacks.isEmpty()){
            return ActionsStacks.pop();
        }
        return null;
    }

    /**
     * Resets the stack so it may start as empty.
     */
    public void clearActions(){
        ActionsStacks.clear();
    }
}
