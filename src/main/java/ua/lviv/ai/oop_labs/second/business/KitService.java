package ua.lviv.ai.oop_labs.second.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.ai.oop_labs.second.dataaccess.IKitRepository;
import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.Kit;
import ua.lviv.ai.oop_labs.second.model.SortBy;

import java.util.List;
import java.util.Optional;

@Service
public class KitService implements IService<Kit> {
    @Autowired
    IKitRepository kitRepository;

    @Autowired
    IElementService elementService;

    @Autowired
    ILinkHelper<Kit> kitLinkHelper;

    @Override
    public Kit create(Kit kit) {
        Element[] elements = new Element[kit.getElements().size()];
        kit.getElements().toArray(elements);

        for (int i = 0; i < elements.length; i++) {
            if (!elementService.existInRepositoryById(elements[i].getId())) {
                elements[i] = elementService.save(elements[i]);
            }
        }

        kit.setElementsFromArr(elements);

        return kitLinkHelper.addLinks(kitRepository.save(kit));
    }

    @Override
    public Kit save(Kit kit) {
        return kitRepository.save(kit);
    }

    @Override
    public Kit delete(Integer kitId) {
        Kit kit = kitRepository.findById(kitId).orElse(null);

        if (kit != null) {
            kitRepository.deleteById(kitId);
        }

        return kitLinkHelper.addLinks(kit);
    }

    @Override
    public Kit update(Kit kit) {
        if (!existInRepositoryById(kit.getId())) {
            return null;
        }

        return create(kit);
    }

    @Override
    public boolean existInRepositoryById(Integer id) {
        if (id == null)
            return false;

        return kitRepository.existsById(id);
    }

    @Override
    public List<Kit> findAll(SortBy sortBy) {
        if (!sortBy.isGoodForKits())
            sortBy = SortBy.ID;

        return kitLinkHelper.addLinks(kitRepository.findAll(sortBy.getSort()));
    }

    @Override
    public List<Kit> findAllBy(Double maxPrice, String producer, SortBy sortBy) {
        if (sortBy == null)
            sortBy = SortBy.ID;

        if (!sortBy.isGoodForKits())
            sortBy = SortBy.ID;

        if (maxPrice == null && producer == null)
            return findAll(sortBy);

        if (producer == null) {
            return findAllCheaperThan(maxPrice, sortBy);
        } else {
            if (maxPrice == null) {
                return findAllByProducer(producer, sortBy);
            } else {
                return findAllByProducerCheaperThan(producer, maxPrice, sortBy);
            }
        }
    }

    @Override
    public List<Kit> findAllByProducerCheaperThan(String producer, Double maxPrice, SortBy sortBy) {
        if (!sortBy.isGoodForKits())
            sortBy = SortBy.ID;

        return kitLinkHelper.addLinks(kitRepository.findAllByProducerAndPriceLessThanEqual(producer, maxPrice, sortBy.getSort()));
    }


    @Override
    public Kit findById(Integer kitId) {
        Optional<Kit> kit = kitRepository.findById(kitId);

        return kitLinkHelper.addLinks(kit.orElse(null));
    }

    @Override
    public List<Kit> findAllByName(String name, SortBy sortBy) {
        if (!sortBy.isGoodForKits())
            sortBy = SortBy.ID;

        return kitLinkHelper.addLinks(kitRepository.findAllByName(name, sortBy.getSort()));
    }

    @Override
    public List<Kit> findAllByProducer(String producer, SortBy sortBy) {
        if (!sortBy.isGoodForKits())
            sortBy = SortBy.ID;

        return kitLinkHelper.addLinks(kitRepository.findAllByProducer(producer, sortBy.getSort()));
    }

    @Override
    public List<Kit> findAllCheaperThan(Double maxPrice, SortBy sortBy) {
        if (!sortBy.isGoodForKits())
            sortBy = SortBy.ID;

        return kitLinkHelper.addLinks(kitRepository.findAllByPriceLessThanEqual(maxPrice, sortBy.getSort()));
    }
}