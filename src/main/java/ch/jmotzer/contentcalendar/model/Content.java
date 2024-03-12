package ch.jmotzer.contentcalendar.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Content(@Id
                      Integer id,
                      @NotEmpty
                      String title,
                      @NotEmpty
                      String description,
                      Status status,
                      Type type,
                      LocalDateTime created,
                      LocalDateTime updated,
                      String url) {
}
