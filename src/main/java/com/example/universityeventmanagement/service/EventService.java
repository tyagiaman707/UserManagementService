package com.example.universityeventmanagement.service;
import com.example.universityeventmanagement.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService implements IEventService {

    private List<Event> events = new ArrayList<>();
    private int eventIdCounter = 0;

    @Override
    public void addEvent(Event event) {
        event.setEventId(++eventIdCounter);
        events.add(event);
    }

    @Override
    public void updateEvent(int id, Event newEvent) {
        Optional<Event> eventOptional = events.stream().filter(e -> e.getEventId() == id).findFirst();
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            event.setEventName(newEvent.getEventName());
            event.setLocationOfEvent(newEvent.getLocationOfEvent());
            event.setDate(newEvent.getDate());
            event.setStartTime(newEvent.getStartTime());
            event.setEndTime(newEvent.getEndTime());
            event.setImageurl(newEvent.getImageurl());
        }
    }

    @Override
    public Event getEvent(int id) {
        Optional<Event> eventOptional = events.stream().filter(e -> e.getEventId() == id).findFirst();
        return eventOptional.orElse(null);
    }

    @Override
    public List<Event> getAllEvents() {
        return events;
    }

    @Override
    public List<Event> getEventsByDate(String date) {
        return events.stream().filter(e -> e.getDate().equals(date)).collect(Collectors.toList());
    }

    @Override
    public void deleteEvent(int id) {
        events.removeIf(e -> e.getEventId() == id);
    }
}
