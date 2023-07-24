package Actions;

import Model.Perspective;

public abstract class Operation implements Action{
	
    Memento initialedState;
    Perspective perspective;
    
    public void execute(){
        initialedState = perspective.createMemento();
        executeAction();
    }

    public void Undo(){
        Memento CurrentMemento = perspective.createMemento();
        perspective.setPerspectiveFromMemento(initialedState);
        initialedState = CurrentMemento;
    }

    public void Redo(){
        Memento CurrentMemento = perspective.createMemento();
        perspective.setPerspectiveFromMemento(initialedState);
        initialedState = CurrentMemento;
    }

    protected void executeAction(){
    }
}
