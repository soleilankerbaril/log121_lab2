package Actions;

public class Undo implements Action{

    UndoPile undoPile;
    public Undo(UndoPile AssociatePile){
        undoPile = AssociatePile;
    }
    public void execute() {
        Operation operation = undoPile.getLastOperation();
    }
}
