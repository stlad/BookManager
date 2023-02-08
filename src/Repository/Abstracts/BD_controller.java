package Repository.Abstracts;

import java.sql.*;
import java.util.Properties;

public class BD_controller {


    /** Просто пример подключения к postgresql */
    public void SMTH()
    {
        try{
            Class.forName("org.postgresql.Driver");
            var url = "jdbc:postgresql://localhost:5432/BookManagerDB";


            Properties auth = new Properties();
            auth.put("user", "postgres"); // Зададим имя пользователя БД
            auth.put("password", "admin"); // Зададим пароль доступа в БД

            // Создание соединения с базой данных
            Connection connection = DriverManager.getConnection(url, auth);

            // Создание оператора доступа к базе данных
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
