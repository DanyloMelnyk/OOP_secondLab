package ua.lviv.ai.oop_labs.second.business;

import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.SortElementsBy;

import java.util.List;

public interface IElementLinkHelper extends ILinkHelper<Element> {

    Element addLinks(Element model, SortElementsBy sortElementsBy);

    List<Element> addLinks(List<Element> elements, SortElementsBy sortElementsBy);

}
