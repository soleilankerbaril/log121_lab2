package Actions;

/**
 * Undo implements the Action interface and can be called upon
 * using the execute function
 * Undo will fetch the last Operation state, set the current state to the previous state
 * then save the previously current state into the Redo pile.
 */
public class Undo implements Action{

    OperationPile undoPile;
    OperationPile redoPile;
    public Undo(OperationPile AssociateUndo,OperationPile AssociateRedo){
        undoPile = AssociateUndo;
        redoPile = AssociateRedo;
    }
    public void execute() {
        Operation operationToUndo = undoPile.getLastOperation();
        if(operationToUndo == null)
            return;
        operationToUndo.Undo();
        redoPile.addOperation(operationToUndo);
    }
}
