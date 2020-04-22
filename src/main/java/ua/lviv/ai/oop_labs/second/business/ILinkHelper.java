package ua.lviv.ai.oop_labs.second.business;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Set;

public interface ILinkHelper<T extends RepresentationModel<T>> {

    T addLinks(T model);

    List<T> addLinks(List<T> elements);

    Set<T> addLinks(Set<T> elements);
}
