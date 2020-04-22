package ua.lviv.ai.oop_labs.second.business;

import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.SortBy;

import java.util.List;

public interface IElementLinkHelper extends ILinkHelper<Element> {

    Element addLinks(Element model, SortBy sortElementsBy);

    List<Element> addLinks(List<Element> elements, SortBy sortElementsBy);

}
