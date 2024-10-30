package marcowidesott.BackM2W2D3.controllers;

import marcowidesott.BackM2W2D3.entities.Autore;
import marcowidesott.BackM2W2D3.payloads.AutorePayload;
import marcowidesott.BackM2W2D3.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    @GetMapping
    public List<Autore> getAuthor() {
        return this.autoreService.findallAuthors();

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


    // 4. - PUT http://localhost:3001/authors/{id} (+ req.body)
    @PutMapping("/{authorId}")
    public Autore findAndUpdate(@PathVariable int authorId, @RequestBody Autore body) throws Exception {
        return autoreService.findByIdAndUpdate(authorId, body);
    }

    // 5. - DELETE http://localhost:3001/authors/{id}
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int authorId) {
        autoreService.findByIdAndDelete(authorId);
    }


}
