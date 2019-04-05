package me.hellozin.demospringmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("MVC Study")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019, 1, 1, 10, 0))
                .endDataTime(LocalDateTime.of(2019, 2, 1, 10, 0))
                .build();

        Event event2 = Event.builder()
                .name("MVC Study2")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019, 3, 1, 10, 0))
                .endDataTime(LocalDateTime.of(2019, 4, 1, 10, 0))
                .build();

        return List.of(event1, event2);
    }
}
