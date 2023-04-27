import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TodoListApp extends JFrame implements ActionListener {

    public TodoListApp() {
        setTitle("Todo App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ;
    }

    public static void main(String[] args) {
        new TodoListApp();
    }
}