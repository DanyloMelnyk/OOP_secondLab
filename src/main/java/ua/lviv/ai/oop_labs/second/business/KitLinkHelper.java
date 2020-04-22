package ua.lviv.ai.oop_labs.second.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.ai.oop_labs.second.controller.KitsController;
import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.Kit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class KitLinkHelper implements ILinkHelper<Kit> {
    @Autowired
    ILinkHelper<Element> elementLinkHelper;

    @Override
    public Kit addLinks(Kit kit) {
        if (kit == null)
            return null;

        if (kit.hasLink("self"))
            return kit;

        kit.add(linkTo(methodOn(KitsController.class, kit.getId()).getKit(kit.getId())).withSelfRel());

        kit.setElements(elementLinkHelper.addLinks(kit.getElements()));

        return kit;
    }

    @Override
    public List<Kit> addLinks(List<Kit> kits) {
        for (Kit kit : kits)
            addLinks(kit);

        return kits;
    }

    @Override
    public Set<Kit> addLinks(Set<Kit> elements) {
        List<Kit> list = addLinks(new LinkedList<>(elements));

        return new HashSet<>(list);
    }
}
