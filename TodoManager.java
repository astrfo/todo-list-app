import java.io.*;
import java.util.*;

public class TodoManager {
    private static final String FILE_PATH = "todolist.ser";

    public void saveTodoList(List<TodoItem> todoList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(todoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<TodoItem> loadTodoList() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (List<TodoItem>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}
