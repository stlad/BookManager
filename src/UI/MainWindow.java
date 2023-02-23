package UI;

import Abstracts.BookEntity;
import Abstracts.IUser;
import Abstracts.Person;
import Domain.Book;
import Repository.DBController;
import Repository.TableWrapper;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private JTextField textField1;
    private JList bookList;

    private IUser selectedUser;

    public MainWindow(IUser currentUser) {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(900,500);
        setLocation(500,500);
        selectedUser = currentUser;
        setTitle(currentUser.toString());
        refreshBooks();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void refreshBooks(){bookList.setModel(getBooksModel());}
    private DefaultListModel<BookEntity> getBooksModel(){
        var model = new DefaultListModel<BookEntity>();
        var bookList = getAllBooks();

        for(BookEntity book: bookList){
            model.addElement(book);
        }
        return model;
    }

    private ArrayList<BookEntity> getAllBooks(){
        var res = new ArrayList<BookEntity>();
        try {
            var books = DBController.getUsersCollection((Person)selectedUser);
            while (books.next()) {
                res.add(TableWrapper.getCurrentBook(books));
            }
            return res;
        }
        catch (SQLException e ){e.printStackTrace();}
        return  null;
    }
}

