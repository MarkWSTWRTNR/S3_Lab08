package se331.rest.service;

import se331.rest.entity.Event;
import se331.rest.entity.Organizer;

import java.util.List;

public interface EventService {
    Integer getEventSize();
    List<Organizer> getEvents(Integer pageSize, Integer page);
    Organizer getEvent(Long id);

}
