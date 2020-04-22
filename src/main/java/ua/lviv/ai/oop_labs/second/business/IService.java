package ua.lviv.ai.oop_labs.second.business;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    T create(T element);

    T delete(Integer id);

    T update(T element);

    T findById(Integer id);

    List<T> findAllByName(String name);

    List<T> findAllByProducer(String producer);

    boolean existInRepositoryById(Integer id);

    List<T> findAllCheaperThan(Double maxPrice);
}
