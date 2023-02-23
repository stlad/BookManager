package Repository;

import Abstracts.BookEntity;
import Abstracts.IUser;
import Domain.Book;
import Domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс обеспечивает работу с контроллером БД через объекты бизнес-логики.
 * Переводит сущности бизнес логики в сущности БД
 */
public class TableWrapper
{
    public static IUser getCurrentUser(ResultSet table)
    {
        try {
            User user = new User();
            user.setID(table.getInt("id"));
            user.setNickname(table.getString("nickname"));
            user.setName(table.getString("name"));
            user.setSurname(table.getString("surname"));
            user.setPatronymic(table.getString("patronymic"));
            user.setJoinDate(table.getDate("registration"));

            return user;
        }
        catch(SQLException e) {e.printStackTrace();}
        return null;
    }


    /**Добавит нового Юзера в БД через DBController
     * Внимание: класс зависит от конкретной реализации User
     */
    public static boolean addNewUser(User usr){
        var regdate = usr.getJoinDate();
        String date = regdate.getYear()+"-"+regdate.getMonth() + "-" + regdate.getDay();
        String sql = String.format("insert into users(name,surname,patronymic,nickname,registration)" +
                "values" +
                "(%s, %s, %s,%s,%s)",usr.getName(), usr.getSurname(), usr.getPatronymic(), usr.getNickname(), date);

        return DBController.executeSQL(sql);
    }

    public static BookEntity getCurrentBook(ResultSet table){
        try{
            Book book = new Book();
            book.setID(table.getInt("book_id"));
            book.setName(table.getString("name"));
            book.setReleaseDate(table.getDate("release_date"));
            return book;
        }
        catch(SQLException e) {e.printStackTrace();}
        return null;

    }
}
