import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TodoListApp extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton addButton, removeButton;
    private DefaultListModel<TodoItem> listModel;
    private JList<TodoItem> taskList;
    private TodoManager listManager;

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
        if (e.getSource() == addButton) {
            String taskTitle = inputField.getText();
            if (!taskTitle.isEmpty()) {
                TodoItem newTask = new TodoItem(taskTitle, false);
                listModel.addElement(newTask);
                listManager.saveTodoList(listModel.elements().asIterator().toList());
                inputField.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex >= 0) {
                listModel.remove(selectedIndex);
                listManager.saveTodoList(listModel.elements().asIterator().toList());
            }
        }
    }

    public static void main(String[] args) {
        new TodoListApp();
    }
}