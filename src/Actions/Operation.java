package Actions;

import Model.Perspective;

public abstract class Operation implements Action{
	
    Memento initialedState;
    Perspective perspective;
    
    public void execute(){

    }

    public void Undo(){
        perspective.setPerspectiveFromMemento(initialedState);
    }

    public void Redo(){

    }
}
