package Domain;

import Abstracts.BookEntity;
import Abstracts.IReview;
import Abstracts.IUser;

public class Review implements IReview
{
    private IUser user;
    public IUser getUser() { return user;}
    public void setUser(IUser user) {this.user = user;}


    private BookEntity target;
    public BookEntity getTarget() {return target;}
    public void setTarget(BookEntity targetBook) {target = targetBook;}

    private Integer score;
    public void setScore(Integer score) {this.score = score;  }
    public Integer getScrore() {return score;}


    private String comment;
    public String getComment() {return comment;}
    public void setComment(String comment) {this.comment = comment; }
}
