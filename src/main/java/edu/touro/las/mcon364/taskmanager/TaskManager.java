package edu.touro.las.mcon364.taskmanager;

public class TaskManager {

    private final TaskRegistry registry;

    public TaskManager(TaskRegistry registry) {
        this.registry = registry;
    }

    // TODO: Students must refactor this using pattern-matching switch
    // Current implementation uses old-style instanceof checks
    public void run(Command command) {
        switch (command) {
            case AddTaskCommand addCmd -> addCmd.execute();
            case RemoveTaskCommand removeCmd -> removeCmd.execute();
            case UpdateTaskCommand updateCmd -> updateCmd.execute();
            default -> throw new IllegalArgumentException("Unknown command type");
        }
    }
}
