package todos;

public class Main {
    static void main() {
        try {
        SleepTodos.printTodosWithDelayedInterval();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
