package Actions;

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
