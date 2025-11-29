package threads;

import functions.Functions;

public class SimpleIntegrator implements Runnable {
    private final Task task;

    public SimpleIntegrator(Task task) {
        this.task = task;
    }

    public void run() {
        for (int i = 0; i < task.taskCount; i++) {
            synchronized (task) {
                if (task.function == null) {
                    continue;
                }
                double result = Functions.integrate(task.function, task.leftX, task.rightX, task.step);
                System.out.println("Result: " + task.leftX + " " + task.rightX + " " + task.step + " = " + result);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                 break;
            }
        }
    }
}
