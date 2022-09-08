package se331.rest.dao;

import org.springframework.stereotype.Repository;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    List<Organizer> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Organizer.builder().id(123L).location("Meow Town").organizer("Kat Laydee").build());
        eventList.add(Organizer.builder().id(456L).location("Flora City").organizer("Fern Pollin").build());
        eventList.add(Organizer.builder().id(789L).location("Playa Del Carmen").organizer("Carey Wales").build());
        eventList.add(Organizer.builder().id(1001L).location("Woof Town").organizer("Dawg Dahd").build());
        eventList.add(Organizer.builder().id(1002L).location("Tin City").organizer("Kahn Opiner").build());
        eventList.add(Organizer.builder().id(789L).location("Highway 50").organizer("Brody Kill").build());
    }

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }

    @Override
    public List<Organizer> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return eventList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getEvent(Long id) {
        return eventList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }
}

