package ua.lviv.ai.oop_labs.second.business;

import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.ElementType;
import ua.lviv.ai.oop_labs.second.model.SortElementsBy;

import java.util.List;

public interface IElementService extends IService<Element> {

    List<Element> findAllBy(ElementType elementType, Double maxPrice, String producer, SortElementsBy sortBy);

    List<Element> findAllByType(ElementType elementType, SortElementsBy sortElementsBy);

    List<Element> replacementForElement(Element element, SortElementsBy sortElementsBy);

    List<Element> findAllByTypeCheaperThan(ElementType type, Double maxPrice, SortElementsBy sortElementsBy);

    List<Element> findAll(SortElementsBy sortElementsBy);

    List<Element> findAllByName(String name, SortElementsBy sortElementsBy);

    List<Element> findAllByProducer(String producer, SortElementsBy sortElementsBy);

    List<Element> findAllCheaperThan(Double maxPrice, SortElementsBy sortElementsBy);

    List<Element> findAllByProducerCheaperThan(String producer, Double maxPrice, SortElementsBy sortBy);

    List<Element> findAllByProducerAndType(String producer, ElementType elementType, SortElementsBy sortBy);

    List<Element> findAllByProducerAndTypeCheaperThan(String producer, ElementType elementType, Double maxPrice, SortElementsBy sortBy);
}
