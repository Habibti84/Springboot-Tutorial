package ch.jmotzer.contentcalendar.repository;

import ch.jmotzer.contentcalendar.model.Content;
import ch.jmotzer.contentcalendar.model.Status;
import ch.jmotzer.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return this.contents;
    }

    public Optional<Content> findById(final int id) {
        return this.contents.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        final Content c = new Content(1,
                "Content 1",
                "My first piece of content",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now().plusHours(1L),
                null,
                "");
        this.contents.add(c);
    }

    public void save(final Content content) {
        this.contents.removeIf(c -> c.id().equals(content.id()));
        this.contents.add(content);
    }

    public void delete(final Integer id) {
        this.contents.removeIf(content -> content.id().equals(id));
    }
}
