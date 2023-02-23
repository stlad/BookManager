package UI;

import Abstracts.IUser;

import javax.swing.*;

public class MainWindow extends JFrame{
    private JButton button1;
    private JPanel mainPanel;

    private IUser selectedUser;

    public MainWindow(IUser currentUser) {
        setContentPane(mainPanel);
        setVisible(true);
        selectedUser = currentUser;


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
