package Abstracts;

public interface IReview
{
    public IUser getUser();
    public void setUser(IUser user);

    public BookEntity getTarget();
    public void setTarget(BookEntity targetBook);

    public void setScore(Integer score);
    public Integer getScrore();

    public String getComment();
    public void setComment(String comment);
}
