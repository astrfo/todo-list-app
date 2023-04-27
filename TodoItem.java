import java.io.Serializable;

public class TodoItem {
    private String title;
    private boolean completed;

    public TodoItem(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
