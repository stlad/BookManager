package Abstracts;
import java.util.Date;

public abstract class Person
{
    private Integer id;
    public Integer getID(){return id;}
    public void setID(Integer id){this.id = id;}

    private String Name;
    public String getName() {return  Name;}
    public void setName(String name) {Name = name;}


    private String surname;
    public String getSurname(){return surname;}
    public void setSurname(String sname) {surname = sname;}


    private String patronymic;
    public String getPatronymic() {return patronymic;};
    public void setPatronymic(String patron) {patronymic = patron;}

}
