package Actions;

/**
 * Action interface that is part of the Command design pattern.
 * Used to call the execute command for all the kind of actions a user may use.
 */
public interface Action { // équivalent de command
    /**
     * execute is a function to be inherited so that any class implementing
     * the Action interface may be called upon in the same way
     */
    public void execute();
}
