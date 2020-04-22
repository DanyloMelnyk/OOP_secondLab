package ua.lviv.ai.oop_labs.second.business;

import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.ElementType;
import ua.lviv.ai.oop_labs.second.model.SortBy;

import java.util.List;

public interface IElementService extends IService<Element> {

    List<Element> findAllBy(ElementType elementType, Double maxPrice, String producer, SortBy sortBy);

    List<Element> findAllByType(ElementType elementType, SortBy sortElementsBy);

    List<Element> replacementForElement(Element element, SortBy sortElementsBy);

    List<Element> findAllByTypeCheaperThan(ElementType type, Double maxPrice, SortBy sortElementsBy);

    List<Element> findAll(SortBy sortElementsBy);

    List<Element> findAllByName(String name, SortBy sortElementsBy);

    List<Element> findAllByProducer(String producer, SortBy sortElementsBy);

    List<Element> findAllCheaperThan(Double maxPrice, SortBy sortElementsBy);

    List<Element> findAllByProducerCheaperThan(String producer, Double maxPrice, SortBy sortBy);

    List<Element> findAllByProducerAndType(String producer, ElementType elementType, SortBy sortBy);

    List<Element> findAllByProducerAndTypeCheaperThan(String producer, ElementType elementType, Double maxPrice, SortBy sortBy);
}
