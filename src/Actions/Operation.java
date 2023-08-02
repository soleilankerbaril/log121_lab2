package Actions;

import Model.Perspective;

/**
 * Operation is an abstract class that implements the action interface
 * so to save an operation as a state and permit a shared code base for all
 * executable actions demanded by the user.
 */
public abstract class Operation implements Action{
	
    Memento initialedState;
    Perspective perspective;
    
    public void execute(){
        initialedState = perspective.createMemento();
        executeAction();
    }

    /**
     * Undo saves the current state of the perspective and
     * sets the previous state as the new current state.
     */
    public void Undo(){
        Memento CurrentMemento = perspective.createMemento();
        perspective.setPerspectiveFromMemento(initialedState);
        initialedState = CurrentMemento;
    }

    /**
     * Redo saves the current state of the perspective and
     * sets the last cancelled operation state as the new current state.
     */
    public void Redo(){
        Memento CurrentMemento = perspective.createMemento();
        perspective.setPerspectiveFromMemento(initialedState);
        initialedState = CurrentMemento;
    }

    /**
     * executeAction is a private function that the inherited classes
     * will use to execute user inputted actions.
     */
    protected void executeAction(){
    }
}
