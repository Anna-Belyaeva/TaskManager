import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldCheckQueryForSimpleTask() {
        Task task = new SimpleTask(1, "Написать курсовую");

        boolean expected = true;
        boolean actual = task.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckQueryForSimpleTask() {
        Task task = new SimpleTask(7, "Сдать дз до дедлайна");

        boolean expected = false;
        boolean actual = task.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckQueryForEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task task = new Epic(7, subtasks);

        boolean expected = true;
        boolean actual = task.matches("Яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckQueryForEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task task = new Epic(7, subtasks);

        boolean expected = false;
        boolean actual = task.matches("Творог");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckQueryTopicForMeeting() {
        Task task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = task.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckQueryTopicForMeeting() {
        Task task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = task.matches("версия");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckQueryProjectForMeeting() {
        Task task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = task.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckQueryProjectForMeeting() {
        Task task = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = task.matches("нетоБанк");

        Assertions.assertEquals(expected, actual);
    }
}
