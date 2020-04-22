package ua.lviv.ai.oop_labs.second.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.ai.oop_labs.second.dataaccess.IKitRepository;
import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.Kit;

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
                elements[i] = elementService.create(elements[i]);
            }
        }

        kit.setElementsFromArr(elements);

        return kitLinkHelper.addLinks(kitRepository.save(kit));
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
        return kitRepository.existsById(id);
    }

    @Override
    public List<Kit> findAll() {
        return kitLinkHelper.addLinks(kitRepository.findAll());
    }

    @Override
    public Kit findById(Integer kitId) {
        Optional<Kit> kit = kitRepository.findById(kitId);

        return kitLinkHelper.addLinks(kit.orElse(null));
    }

    @Override
    public List<Kit> findAllByName(String name) {
        return kitLinkHelper.addLinks(kitRepository.findAllByName(name));
    }

    @Override
    public List<Kit> findAllByProducer(String producer) {
        return kitLinkHelper.addLinks(kitRepository.findAllByProducer(producer));
    }

    @Override
    public List<Kit> findAllCheaperThan(Double maxPrice) {
        return kitLinkHelper.addLinks(kitRepository.findAllByPriceLessThanEqual(maxPrice));
    }
}