package UI;

import Abstracts.IUser;
import Repository.DBController;
import Repository.TableWrapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserSelectionDialog extends JDialog{
    private JPanel userListPanel;
    private JList userlist;
    private JButton selectBtn;

    public UserSelectionDialog() {
        setContentPane(userListPanel);
        setVisible(true);
        setSize(200,300);

        userlist.setSize(100,100);
        userlist.setModel(getUsersModel());

        selectBtn.addActionListener(e -> {
            var selectedUsr=(IUser) userlist.getSelectedValue();
            if(selectedUsr != null) {
                new MainWindow(selectedUsr);
                dispose();
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }


    private DefaultListModel<IUser> getUsersModel(){
        var model = new DefaultListModel<IUser>();
        var userList = getAllUsers();

        for(IUser user: userList){
            model.addElement(user);
        }
        return model;
    }

    private ArrayList<IUser> getAllUsers(){
        var res = new ArrayList<IUser>();
        try {
            var users = DBController.getTable(DBController.Tables.Users);
            while (users.next()) {
                res.add(TableWrapper.getCurrentUser(users));
            }
            return res;
        }
        catch (SQLException e ){e.printStackTrace();}
        return  null;
    }
}
