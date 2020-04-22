package ua.lviv.ai.oop_labs.second.business;

import ua.lviv.ai.oop_labs.second.model.SortBy;

import java.util.List;

public interface IService<T> {

    T create(T element);

    T delete(Integer id);

    T update(T element);

    boolean existInRepositoryById(Integer id);

    List<T> findAll(SortBy sortBy);

    T findById(Integer id);

    List<T> findAllByName(String name, SortBy sortBy);

    List<T> findAllByProducer(String producer, SortBy sortBy);

    List<T> findAllCheaperThan(Double maxPrice, SortBy sortBy);

    List<T> findAllBy(Double maxPrice, String producer, SortBy sortBy);

    List<T> findAllByProducerCheaperThan(String producer, Double maxPrice, SortBy sortBy);
}
