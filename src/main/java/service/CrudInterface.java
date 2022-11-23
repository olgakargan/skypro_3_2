package service;

public interface CrudInterface<T> {
    T create(T t);

    T find(Long id);

    T edit(T object);

    T delete(Long id);
}
