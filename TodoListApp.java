import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TodoListApp extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton addButton, removeButton;

    public TodoListApp() {
        setTitle("Todo App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();

        addButton = new JButton("追加");
        addButton.addActionListener(this);

        removeButton = new JButton("削除");
        removeButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.SOUTH);

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