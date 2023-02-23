package Domain;

import Abstracts.IAuthor;
import Abstracts.Person;

public class Author extends Person implements IAuthor
{
    private String biography;
    public String getBiography(){return biography;}
    public void setBiography(String bio){biography = bio;}
}
