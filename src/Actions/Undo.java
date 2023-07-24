package Actions;

public class Undo implements Action{

    UndoPile undoPile;
    RedoPile redoPile;
    public Undo(UndoPile AssociateUndo,RedoPile AssociateRedo){
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
