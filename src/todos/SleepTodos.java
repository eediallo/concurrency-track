package todos;

public class SleepTodos {
    public static void printTodosWithDelayedInterval() throws InterruptedException {

        String todos[] = new String[]{
                "Go the Gym",
                "Go shopping",
                "Do laundry",
                "Walk the dog",
                "Apply for jobs"
        };

        for (int i = 0; i < todos.length; i++) {
            // pause 4 seconds
            Thread.sleep(4000);
            System.out.println(todos[i]);
        }
    }
}
