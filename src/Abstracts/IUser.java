package Abstracts;

import java.util.ArrayList;
import java.util.Date;

public interface IUser
{
    public ArrayList<BookEntity> getBookCollection();
    public ArrayList<IReview> getReviews ();

    public String getNickname();
    public void setNickname(String name);

    public Date getJoinDate();
    public void setJoinDate(Date date);
}
