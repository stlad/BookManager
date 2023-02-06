package Repository;

public interface IRepository<T>
{
    public T getElement();

    public void addElement(T elem);

    public void deleteElement(T elem);

}
