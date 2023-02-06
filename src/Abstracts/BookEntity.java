package Abstracts;

import Domain.Author;
import Domain.Book;
import Domain.Review;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashSet;

public abstract class BookEntity
{

    public HashSet<String> Tags;
    public ArrayList<IReview> Reviews;

    private String bookName;
    public String getName() { return this.bookName;}
    public void setName(String name) {bookName = name; }


    private IAuthor author;
    public IAuthor getAuthor() {return author;}
    public void setAuthor(IAuthor auth) {author = auth;}


    private Date releaseDate;
    public Date getReleaseDate() {return releaseDate;}
    public void setReleaseDate(Date rdate) {releaseDate = rdate;}



    public BookEntity()
    {
        Tags = new HashSet<String>();
        Reviews = new ArrayList<IReview>();
    }

    public void addTag(String tag) {Tags.add(tag);}


    public IReview AddReview(IUser user, String comment, Integer score)
    {
        var rev = new Review();
        rev.setTarget(this);
        rev.setUser(user);
        rev.setComment(comment);
        rev.setScore(score);

        this.Reviews.add(rev);
        return rev;
    };

    public String toString()
    {
        Formatter f = new Formatter();
        f.format("Book Name: %s \n Release Date: %tD", this.getName(), this.getReleaseDate());
        return f.toString();
    }
}
