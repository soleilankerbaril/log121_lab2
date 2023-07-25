package Actions;

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
