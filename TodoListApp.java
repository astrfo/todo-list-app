import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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

        listManager = new TodoManager();

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        loadTasksFromFile();

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(200, 30));

        addButton = new JButton("追加");
        addButton.addActionListener(this);

        removeButton = new JButton("削除");
        removeButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadTasksFromFile() {
        List<TodoItem> tasks = listManager.loadTodoList();
        if (tasks != null) {
            tasks.forEach(listModel::addElement);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String taskTitle = inputField.getText();
            if (!taskTitle.isEmpty()) {
                TodoItem newTask = new TodoItem(taskTitle, false);
                listModel.addElement(newTask);
                Iterator<TodoItem> iterator = listModel.elements().asIterator();
                List<TodoItem> todoItems = new ArrayList<>();
                while (iterator.hasNext()) {
                    todoItems.add(iterator.next());
                }
                listManager.saveTodoList(todoItems);
                inputField.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex >= 0) {
                listModel.remove(selectedIndex);
                Iterator<TodoItem> iterator = listModel.elements().asIterator();
                List<TodoItem> todoItems = new ArrayList<>();
                while (iterator.hasNext()) {
                    todoItems.add(iterator.next());
                }
                listManager.saveTodoList(todoItems);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoListApp::new);
    }
}