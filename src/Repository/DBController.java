package Repository;

import Abstracts.IUser;
import Abstracts.Person;
import Domain.User;

import java.sql.*;
import java.util.Properties;

public class DBController {

    public static  Connection Connection;

    public static enum Tables{
        Users,
        Authors,
        Books,
        Reviews
    }

    public static Connection CreateConnection()
    {
        return CreateConnection("localhost", "5432", "BookManagerDB", "postgres", "admin");
    }
    public static Connection CreateConnection(String address, String port, String DBname, String user, String password )
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            var url = "jdbc:postgresql://" +address + ":" + port + "/" + DBname; //localhost:5432/BookManagerDB";


            Properties auth = new Properties();
            auth.put("user", user); // Зададим имя пользователя БД
            auth.put("password", password); // Зададим пароль доступа в БД


            Connection connection = DriverManager.getConnection(url, auth);
            System.out.println("Подключение создано");

            Connection = connection;
            return  connection;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Не удалось подключитсья к драйверу");
            return null;
        }
        catch (SQLException e)
        {
            System.out.println("Не удалось создать соединение");
            return null;
        }
    }

    public static void CloseConnection(Connection con)
    {
        try{con.close();}
        catch (SQLException e){System.out.println("Не удалось закрыть соединение");}
    }

    public static Statement CreateStatement()
    {
        try{
            return Connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        catch (SQLException e)
        {
            e.printStackTrace();;
            System.out.println("Не получилось создать Statement");
            return null;
        }
    }

    public static ResultSet getTable(Tables tableName){
        if(Connection == null){
            CreateConnection();
        }
        var stat = CreateStatement();
        ResultSet res = null;

        try {
            String sql = String.format("select * from %s ", tableName);
            res =  stat.executeQuery(sql);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }


    public static ResultSet getUsersCollection(Person user){ return getUsersCollection(user.getID());}
    public static ResultSet getUsersCollection(int userID){
        if(Connection == null){
            CreateConnection();
        }
        var stat = CreateStatement();
        ResultSet res = null;
        try {
            String sql = String.format("select * from book_collections \n" +
                    "inner join books on book_id = books.id\n" +
                    "where user_id= %d", userID);

            res = stat.executeQuery(sql);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    public static  boolean executeSQL(String sql){
        try{
            if(Connection == null){CreateConnection();}
            var stat = CreateStatement();
            stat.executeQuery(sql);
        }
        catch (SQLException e ){return false;}
        finally {CloseConnection(Connection);}
        return true;
    }


    /** Просто пример подключения к postgresql */
    private void SMTH()
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


        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
