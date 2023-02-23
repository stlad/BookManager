import Abstracts.BookEntity;
import Abstracts.Person;
import Domain.Book;
import Domain.Review;
import Domain.User;


import java.io.IOException;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import Repository.DBController;
import Repository.TableWrapper;
import UI.MainWindow;
import UI.UserSelectionDialog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        /*var con = DBController.CreateConnection();
        var stat = DBController.CreateStatement();
        var res =stat.executeQuery("select * from users");
        res.beforeFirst();
        while (res.next())
        {
           var index =  res.getRow();
           var s = "";
           System.out.println(s);
        }*/

       /* var users = DBController.getTable(DBController.Tables.Users);
        users.beforeFirst();
        while(users.next()){
            User usr = (User) TableWrapper.getCurrentUser(users);
            var id = usr.getID();


            System.out.println(usr);
        }*/


        new UserSelectionDialog();
    }
}