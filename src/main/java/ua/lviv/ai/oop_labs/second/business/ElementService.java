package ua.lviv.ai.oop_labs.second.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.ai.oop_labs.second.dataaccess.IElementRepository;
import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.ElementType;
import ua.lviv.ai.oop_labs.second.model.Kit;
import ua.lviv.ai.oop_labs.second.model.SortBy;

import java.util.List;
import java.util.Optional;

import static ua.lviv.ai.oop_labs.second.model.SortBy.ID;

@Service
public class ElementService implements IElementService {

    @Autowired
    IElementRepository elementRepository;

    @Autowired
    IService<Kit> kitService;

    @Autowired
    ElementLinkHelper linkHelper;

    @Override
    public Element create(Element element) {
        return linkHelper.addLinks(elementRepository.save(element));
    }

    @Override
    public Element delete(Integer elementId) {
        Element element = elementRepository.findById(elementId).orElse(null);

        if (element != null) {
            Kit[] kits = new Kit[element.getKits().size()];
            element.getKits().toArray(kits);

            for (Kit kit : kits)
                kitService.delete(kit.getId());

            elementRepository.deleteById(elementId);
        }

        return element;
    }

    @Override
    public Element update(Element element) {
        if (!existInRepositoryById(element.getId())) {
            return null;
        }

        return create(element);
    }

    @Override
    public boolean existInRepositoryById(Integer id) {
        return elementRepository.existsById(id);
    }

    @Override
    public List<Element> findAllBy(Double maxPrice, String producer, SortBy sortBy) {

        if (sortBy == null)
            sortBy = ID;

        if (maxPrice == null && producer == null)
            return findAll(sortBy);

        if (producer == null) {
            return findAllCheaperThan(maxPrice, sortBy);
        } else {
            if (maxPrice != null) {
                return findAllByProducerCheaperThan(producer, maxPrice, sortBy);
            } else {
                return findAllByProducer(producer, sortBy);
            }
        }
    }

    @Override
    public List<Element> findAllBy(ElementType elementType, Double maxPrice, String producer, SortBy sortBy) {
        if (sortBy == null)
            sortBy = ID;

        if (elementType == null && maxPrice == null && producer == null)
            return findAll(sortBy);

        if (elementType == null)
            return findAllBy(maxPrice, producer, sortBy);


        if (producer == null) {
            if (maxPrice == null) {
                return findAllByType(elementType, sortBy);
            }

            return findAllByTypeCheaperThan(elementType, maxPrice, sortBy);
        } else {
            if (maxPrice == null) {
                return findAllByProducerAndType(producer, elementType, sortBy);
            } else {
                return findAllByProducerAndTypeCheaperThan(producer, elementType, maxPrice, sortBy);
            }
        }
    }

    @Override
    public List<Element> findAll(SortBy sortElementsBy) {
        return linkHelper.addLinks(elementRepository.findAll(sortElementsBy.getSort()));
    }


    public Element findById(Integer elementId) {
        Optional<Element> element = elementRepository.findById(elementId);

        return linkHelper.addLinks(element.orElse(null));
    }

    @Override
    public List<Element> findAllByName(String name, SortBy sortElementsBy) {
        return linkHelper.addLinks(elementRepository.findAllByName(name, sortElementsBy.getSort()), sortElementsBy);
    }

    @Override
    public List<Element> findAllByProducer(String producer, SortBy sortElementsBy) {
        return linkHelper.addLinks(elementRepository.findAllByProducer(producer, sortElementsBy.getSort()), sortElementsBy);
    }

    @Override
    public List<Element> findAllCheaperThan(Double maxPrice, SortBy sortElementsBy) {
        return linkHelper.addLinks(elementRepository.findAllByPriceLessThanEqual(maxPrice, sortElementsBy.getSort()), sortElementsBy);
    }

    @Override
    public List<Element> findAllByProducerCheaperThan(String producer, Double maxPrice, SortBy sortBy) {
        return linkHelper.addLinks(elementRepository.findAllByProducerAndPriceLessThanEqual(producer, maxPrice, sortBy.getSort()), sortBy);
    }

    @Override
    public List<Element> findAllByProducerAndType(String producer, ElementType elementType, SortBy sortBy) {
        return linkHelper.addLinks(elementRepository.findAllByProducerAndType(producer, elementType, sortBy.getSort()), sortBy);
    }

    @Override
    public List<Element> findAllByProducerAndTypeCheaperThan(String producer, ElementType elementType, Double maxPrice, SortBy sortBy) {
        return linkHelper.addLinks(elementRepository.findAllByProducerAndTypeAndPriceLessThanEqual(producer, elementType, maxPrice, sortBy.getSort()), sortBy);
    }

    @Override
    public List<Element> findAllByTypeCheaperThan(ElementType type, Double maxPrice, SortBy sortElementsBy) {
        return linkHelper.addLinks(elementRepository.findAllByTypeAndPriceLessThanEqual(type, maxPrice, sortElementsBy.getSort()), sortElementsBy);
    }

    @Override
    public List<Element> findAllByType(ElementType elementType, SortBy sortElementsBy) {
        return linkHelper.addLinks(elementRepository.findAllByType(elementType, sortElementsBy.getSort()), sortElementsBy);
    }

    @Override
    public List<Element> replacementForElement(Element element, SortBy sortElementsBy) {
        if (!existInRepositoryById(element.getId()))
            return null;

        List<Element> elementsWithSameType = elementRepository.findAllByTypeAndValueAndVoltageAndAmountGreaterThanEqual(
                element.getType(), element.getValue(), element.getVoltage(), 1, sortElementsBy.getSort());

        elementsWithSameType.remove(element);

        return linkHelper.addLinks(elementsWithSameType, sortElementsBy);
    }
}
