package Abstracts;
import java.util.Date;

public abstract class Person
{
    private String Name;
    public String getName() {return  Name;}
    public void setName(String name) {Name = name;}


    private String surname;
    public String getSurname(){return surname;}
    public void setSurname(String sname) {surname = sname;}


    private String patronymic;
    public String getPatronymic() {return patronymic;};
    public void setPatronymic(String patron) {patronymic = patron;}

    private Date birthdate;
    public Date getBirthDate() {return birthdate;}
    public void setBirthDate(Date date) {birthdate = date;}




}
