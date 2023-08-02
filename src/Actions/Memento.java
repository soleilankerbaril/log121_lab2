package Actions;

import Model.Perspective;

/**
 * Memento is of the memento design pattern by taking a set of object
 * and saving their current states to be used later on.
 */
public class Memento {
    public Perspective perspective;

    public Memento(Perspective perspective){
        this.perspective = perspective;
    }
}