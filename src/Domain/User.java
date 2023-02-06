package Domain;

import Abstracts.IUser;
import Abstracts.Person;

import java.util.Date;

public class User extends Person implements IUser
{
    private String nickname;

    public String getNickname() {return nickname;}

    public void setNickname(String name) {nickname = name; }

    private Date joindate;
    public Date getJoinDate() {return joindate;}

    public void setJoinDate(Date date) {joindate = date;}
}
