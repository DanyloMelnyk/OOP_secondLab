package ua.lviv.ai.oop_labs.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.ai.oop_labs.second.business.IElementService;
import ua.lviv.ai.oop_labs.second.model.Element;
import ua.lviv.ai.oop_labs.second.model.ElementType;
import ua.lviv.ai.oop_labs.second.model.SortElementsBy;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/elements")
@RestController
public class ElementsController {

    @Autowired
    private IElementService elementService;

    @GetMapping
    public List<Element> getElements(final @Valid @RequestParam(value = "type", required = false) ElementType elementType,
                                     final @Valid @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                     final @Valid @RequestParam(value = "producer", required = false) String producer,
                                     @Valid @RequestParam(value = "sortBy", required = false) SortElementsBy sortBy) {

        return elementService.findAllBy(elementType, maxPrice, producer, sortBy);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Element> getElement(final @PathVariable("id") Integer id) {
        Element element = elementService.findById(id);

        HttpStatus status = element == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(element, status);
    }

    @GetMapping(path = "/{id}/comp")
    public ResponseEntity<List<Element>> replacementForElement(final @PathVariable("id") Integer id,
                                                               @Valid @RequestParam(value = "sortBy", required = false) SortElementsBy sortBy) {
        if (sortBy == null)
            sortBy = SortElementsBy.ID;

        Element element = elementService.findById(id);

        HttpStatus status = element == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        List<Element> replacement = elementService.replacementForElement(element, sortBy);

        return new ResponseEntity<>(replacement, status);
    }


    @PostMapping
    public ResponseEntity<Element> createElement(final @RequestBody Element element) {
        Element responseElement = elementService.create(element);

        HttpStatus status = responseElement == null ? HttpStatus.NOT_FOUND : HttpStatus.CREATED;

        return new ResponseEntity<>(responseElement, status);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Element> deleteElement(final @PathVariable("id") Integer id) {
        HttpStatus status = elementService.delete(id) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Element> updateElement(final @PathVariable("id") Integer id, final @RequestBody Element element) {
        element.setId(id);

        HttpStatus status = elementService.update(element) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return ResponseEntity.status(status).build();
    }
}
