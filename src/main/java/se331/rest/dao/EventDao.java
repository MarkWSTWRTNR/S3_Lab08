package se331.rest.dao;

import se331.rest.entity.Event;
import se331.rest.entity.Organizer;

import java.util.List;

public interface EventDao {
    Integer getEventSize();

    List<Organizer> getEvents(Integer pageSize, Integer page);

    Organizer getEvent(Long id);

}

