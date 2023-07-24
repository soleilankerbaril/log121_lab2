package Actions;

public class Redo implements Action{
    UndoPile undoPile;
    RedoPile redoPile;
    public Redo(UndoPile AssociateUndo,RedoPile AssociateRedo){
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
