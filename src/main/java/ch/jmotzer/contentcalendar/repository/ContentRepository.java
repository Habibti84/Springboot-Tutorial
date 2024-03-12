package ch.jmotzer.contentcalendar.repository;

import ch.jmotzer.contentcalendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
}
