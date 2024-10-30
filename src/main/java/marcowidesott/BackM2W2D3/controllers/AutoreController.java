package marcowidesott.BackM2W2D3.controllers;

import marcowidesott.BackM2W2D3.entities.Autore;
import marcowidesott.BackM2W2D3.payloads.AutorePayload;
import marcowidesott.BackM2W2D3.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    @GetMapping
    public ResponseEntity<Page<Autore>> getAuthors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        // Creazione dell'oggetto Sort dinamico
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Sort sortOrder = Sort.by(direction, sort[0]);

        // Creazione dell'oggetto Pageable
        Pageable pageable = PageRequest.of(page, size, sortOrder);

        // Recupera gli autori paginati dal servizio
        Page<Autore> autori = autoreService.findAll(pageable);
        return ResponseEntity.ok(autori);
    }

    @GetMapping("/{userId}")
    public Autore getSingleAuthor(@PathVariable Long userId) {
        return this.autoreService.findById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore createAuthor(@RequestBody AutorePayload body) {
        return this.autoreService.saveAuthor(body);
    }

    // @PutMapping
    //public Autore modifyingAuthor() {

    //}

    //@DeleteMapping
    // public Autore deleteAuthor() {

    // }


}
