package Abstracts;

import Domain.Author;
import Domain.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashSet;

public abstract class BookEntity
{
    public static HashSet<String> Tags;
    static
    {
        Tags = new HashSet<String>();
        Tags.add("Научная фантастика");
        Tags.add("Фентези");
        Tags.add("Киберпанк");
        Tags.add("Историческое");
        Tags.add("Фантастика");
        Tags.add("Для дед-инсайдов");
        Tags.add("Манга");
    }

    private String bookName;
    public String getName() { return this.bookName;}
    public void setName(String name) {bookName = name; }


    private Author author;
    public Author getAuthor() {return author;}
    public void setAuthor(Author auth) {author = auth;}


    private Date releaseDate;
    public Date getReleaseDate() {return releaseDate;}
    public void setReleaseDate(Date rdate) {releaseDate = rdate;}

    public String toString()
    {
        Formatter f = new Formatter();
        f.format("Book Name: %s \n Release Date: %tD", this.getName(), this.getReleaseDate());
        return f.toString();
    }
}
