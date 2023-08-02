package Actions;

/**
 * Redo implements the Action interface and can be called upon
 * using the execute function
 * Redo will fetch the last cancelled state and return to it,
 * saving the previous state back into the undo pile.
 */
public class Redo implements Action{
    OperationPile undoPile;
    OperationPile redoPile;
    public Redo(OperationPile AssociateUndo,OperationPile AssociateRedo){
        undoPile = AssociateUndo;
        redoPile = AssociateRedo;
    }
    public void execute() {
        Operation operationToRedo = redoPile.getLastOperation();
        if(operationToRedo == null)
            return;
        operationToRedo.Redo();
        undoPile.addOperation(operationToRedo);
    }
}
