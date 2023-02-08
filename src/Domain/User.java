package Domain;

import Abstracts.BookEntity;
import Abstracts.IReview;
import Abstracts.IUser;
import Abstracts.Person;

import java.util.ArrayList;
import java.util.Date;

public class User extends Person implements IUser
{
    private Integer id;
    public Integer getID(){return id;}
    public void setID(Integer id){this.id = id;}

    private ArrayList<BookEntity> bookCollection;
    public ArrayList<BookEntity> getBookCollection(){return bookCollection;}


    private ArrayList<IReview> reviews;
    public ArrayList<IReview> getReviews(){return reviews;}

    private String nickname;

    public String getNickname() {return nickname;}

    public void setNickname(String name) {nickname = name; }

    private Date joindate;
    public Date getJoinDate() {return joindate;}

    public void setJoinDate(Date date) {joindate = date;}


    public User()
    {
        bookCollection = new ArrayList<BookEntity>();
        reviews = new ArrayList<IReview>();
    }
}
