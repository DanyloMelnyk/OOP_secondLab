package ua.lviv.ai.oop_labs.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.ai.oop_labs.second.business.IService;
import ua.lviv.ai.oop_labs.second.model.Kit;

import java.util.List;

@RequestMapping("/kits")
@RestController
public class KitsController {
    @Autowired
    private IService<Kit> kitService;

    @GetMapping
    public List<Kit> getKits() {
        return kitService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Kit> getKit(final @PathVariable("id") Integer id) {
        Kit kit = kitService.findById(id);

        HttpStatus status = kit == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(kit, status);
    }

    @PostMapping
    public ResponseEntity<Kit> createKit(final @RequestBody Kit kit) {
        Kit responseKit = kitService.create(kit);

        HttpStatus status = responseKit == null ? HttpStatus.NOT_FOUND : HttpStatus.CREATED;

        return new ResponseEntity<>(responseKit, status);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Kit> deleteKit(final @PathVariable("id") Integer id) {
        HttpStatus status = kitService.delete(id) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Kit> updateKit(final @PathVariable("id") Integer id, final @RequestBody Kit kit) {
        kit.setId(id);

        HttpStatus status = kitService.update(kit) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return ResponseEntity.status(status).build();
    }
}
