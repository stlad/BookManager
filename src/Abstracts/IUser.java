package Abstracts;

import java.util.ArrayList;
import java.util.Date;

public interface IUser
{
    public ArrayList<BookEntity> BookCollection = null;
    public ArrayList<IReview> Reviews = null;

    public String getNickname();
    public void setNickname(String name);

    public Date getJoinDate();
    public void setJoinDate(Date date);
}
