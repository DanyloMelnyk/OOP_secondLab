package ua.lviv.ai.oop_labs.second.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.ai.oop_labs.second.controller.ElementsController;
import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.Kit;
import ua.lviv.ai.oop_labs.second.model.SortElementsBy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ElementLinkHelper implements IElementLinkHelper {

    @Autowired
    ILinkHelper<Kit> kitLinkHelper;

    @Override
    public Element addLinks(Element model) {
        return addLinks(model, SortElementsBy.ID);
    }

    @Override
    public Element addLinks(Element element, SortElementsBy sortElementsBy) {
        if (element == null)
            return null;

        if (element.hasLink("self") && element.hasLink("replacementForElement"))
            return element;

        if (!element.hasLink("self"))
            element.add(linkTo(methodOn(ElementsController.class, element.getId()).getElement(element.getId()))
                    .withSelfRel());

        if (!element.hasLink("replacementForElement"))
            element.add(linkTo(methodOn(ElementsController.class, element.getId()).replacementForElement(element.getId(), sortElementsBy))
                    .withRel("replacementForElement"));

        for (Kit kit : element.getKits()) {
            kitLinkHelper.addLinks(kit);
        }

        return element;
    }

    @Override
    public List<Element> addLinks(List<Element> elements) {
        return addLinks(elements, SortElementsBy.ID);
    }

    @Override
    public List<Element> addLinks(List<Element> elements, SortElementsBy sortElementsBy) {
        for (Element element : elements)
            addLinks(element, sortElementsBy);

        return elements;
    }

    @Override
    public Set<Element> addLinks(Set<Element> elements) {
        List<Element> list = addLinks(new LinkedList<>(elements));

        return new HashSet<>(list);
    }
}
