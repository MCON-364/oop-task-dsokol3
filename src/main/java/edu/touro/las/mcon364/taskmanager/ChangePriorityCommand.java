package edu.touro.las.mcon364.taskmanager;

public final class ChangePriorityCommand implements Command {
    private final TaskRegistry registry;
    private final String name;
    private final Priority priority;

    public ChangePriorityCommand(TaskRegistry registry, String name, Priority priority) {
        this.registry = registry;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public void execute() {
        Task existing = registry.get(name)
            .orElseThrow(() -> new TaskNotFoundException("Task '" + name + "' not found"));

        Task updated = new Task(existing.name(), priority);
        registry.add(updated);
    }
}
