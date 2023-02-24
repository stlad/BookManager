package UI;

import Abstracts.BookEntity;
import Abstracts.IUser;
import Abstracts.Person;
import Repository.DBController;
import Repository.TableWrapper;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private JList bookList;
    private JLabel bookNameLabel;
    private JTextArea bookInfoArea;
    private JButton addBookBtn;

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

        bookList.addListSelectionListener(e -> {
            if(bookList.getSelectedValue() == null) return;
            BookEntity currentBook = (BookEntity) bookList.getSelectedValue();
            bookNameLabel.setText (currentBook.getName());
            bookInfoArea.setText(currentBook.getFullInfo());
        });
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

