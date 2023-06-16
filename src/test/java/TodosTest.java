import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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

    @Test // поиск по 1 задаче
    public void shouldFindQueryForSimpleTask() {

        Todos todos = new Todos();
        todos.add(simpleTask);


        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Купить Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryForSimpleTask() {

        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("купить");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryForEpic() {

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryForEpic() {

        Todos todos = new Todos();
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("Носки");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryForMeeting() {

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryForMeeting() {

        Todos todos = new Todos();
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("третьей");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // поиск по нескольким задачам
    public void shouldFindQueryFor2Tasks() {

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryFor2Tasks() {

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);

        Task[] expected = {};
        Task[] actual = todos.search("хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //ни одна из 3 задач не подходит
    public void shouldNotFindQueryForTasks() {

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("погулять с собакой");

        Assertions.assertArrayEquals(expected, actual);
    }

}
