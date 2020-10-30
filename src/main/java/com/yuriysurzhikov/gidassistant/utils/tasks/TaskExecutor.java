package com.yuriysurzhikov.gidassistant.utils.tasks;

public class TaskExecutor {

    private Task task;
    private TaskCallbacks callbacks;

    private TaskExecutor() {
    }
    
    public static TaskExecutor newExecutor(Task task, TaskCallbacks callbacks) {
        TaskExecutor instance = new TaskExecutor();
        instance.task = task;
        instance.callbacks = callbacks;
        return instance;
    }

    public void start() {
        new Thread(() -> {
            try {
                task.startTask();
                callbacks.onTaskSuccess();
            } catch (Exception ex) {
                ex.printStackTrace();
                callbacks.onTaskFailure();
            }
        }).start();
    }
}
