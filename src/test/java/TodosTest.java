import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckQueryForSimpleTask() {

        Todos todos = new Todos();
        todos.add(simpleTask);


        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckQueryForSimpleTask() {

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("позвонить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckQueryForEpic() {

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckQueryForEpic() {

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("Носки");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckTopicQueryForMeeting() {

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckTopicQueryForMeeting() {

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("третьей");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckProjectQueryForMeeting() {

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotCheckProjectQueryForMeeting() {

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Приложения");

        Assertions.assertArrayEquals(expected, actual);
    }

}
