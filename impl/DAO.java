package impl;



public interface DAO<T> {

    void create(T obj);
    T read(long id);
    T update(long id,T obj);
    void delete(long id);
}
