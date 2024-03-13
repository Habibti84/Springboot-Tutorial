package ch.jmotzer.contentcalendar.controller;

import ch.jmotzer.contentcalendar.model.Content;
import ch.jmotzer.contentcalendar.model.Status;
import ch.jmotzer.contentcalendar.repository.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
//@CrossOrigin
public class ContentController {

    private final ContentRepository repository;

    public ContentController(final ContentRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("")
    public List<Content> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable final int id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody final Content content) {
        this.repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody final Content content, @PathVariable final Integer id) {
        if (this.repository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Integer id) {
        this.repository.deleteById(id);
    }

    @GetMapping("filter/{keyword}")
    public List<Content> findByTitle(@PathVariable final String keyword) {
        return this.repository.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<Content> findByStatus(@PathVariable final Status status) {
        return this.repository.findByStatus(status);
    }
}
