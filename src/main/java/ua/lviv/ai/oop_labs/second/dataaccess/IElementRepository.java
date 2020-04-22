package ua.lviv.ai.oop_labs.second.dataaccess;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.ElementType;

import java.util.List;

@Repository
public interface IElementRepository extends JpaRepository<Element, Integer> {

    List<Element> findAllByName(String name, Sort by);

    List<Element> findAllByProducer(String producer, Sort by);

    List<Element> findAllByType(ElementType elementType, Sort by);

    List<Element> findAllByPriceLessThanEqual(Double price, Sort by);

    List<Element> findAllByTypeAndPriceLessThanEqual(ElementType elementType, Double price, Sort by);

    List<Element> findAllByTypeAndValueAndVoltageAndAmountGreaterThanEqual(ElementType type, double value, double voltage, int amount, Sort sort);

    List<Element> findAllByProducerAndPriceLessThanEqual(String producer, Double maxPrice, Sort sort);

    List<Element> findAllByProducerAndType(String producer, ElementType elementType, Sort sort);

    List<Element> findAllByProducerAndTypeAndPriceLessThanEqual(String producer, ElementType elementType, Double maxPrice, Sort sort);
}
