package UI;

import Abstracts.IUser;
import Domain.User;
import Repository.DBController;
import Repository.TableWrapper;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class UserSelectionDialog extends JDialog{
    private JPanel userListPanel;
    private JList userlist;
    private JButton selectBtn;
    private JButton addBtn;
    private JButton dltBtn;
    private JTextField nickField;
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField patronField;

    public UserSelectionDialog() {
        setContentPane(userListPanel);
        setVisible(true);
        setSize(600,700);
        setLocation(200,200);
        userlist.setSize(100,100);


        refreshUserList();
        selectBtn.addActionListener(e -> {
            var selectedUsr=(IUser) userlist.getSelectedValue();
            if(selectedUsr != null) {
                new MainWindow(selectedUsr);
                dispose();
            }
        });

        addBtn.addActionListener(e -> {
            var usr = getNewUser();
            if(usr.getNickname().equals("")) return;
            TableWrapper.addNewUser((User) usr);
            refreshUserList();
            nickField.setText("");
            nameField.setText("");
            surnameField.setText("");
            patronField.setText("");
        });

        dltBtn.addActionListener(e -> {
            deleteSelectedUser();
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }


    private void deleteSelectedUser(){
        var selectedUsr=(User) userlist.getSelectedValue();
        if(selectedUsr != null) {
            TableWrapper.deleteUser(selectedUsr);
            refreshUserList();
        }

    }

    private IUser getNewUser(){
        User usr = new User();
        usr.setNickname(nickField.getText());
        usr.setName(nameField.getText());
        usr.setSurname(surnameField.getText());
        usr.setPatronymic(patronField.getText());
        usr.setJoinDate(new Date());
        return usr;
    }

    private void refreshUserList(){
        userlist.setModel(getUsersModel());
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
