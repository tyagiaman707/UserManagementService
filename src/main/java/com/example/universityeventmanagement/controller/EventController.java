package com.example.universityeventmanagement.controller;

import com.example.universityeventmanagement.model.Event;
import com.example.universityeventmanagement.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/university")
public class EventController {

    @Autowired
    private IEventService eventService;

    @PostMapping("/add-event")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

    @PutMapping("/update-event/{id}")
    public void updateEvent(@PathVariable int id, @RequestBody Event event) {
        eventService.updateEvent(id, event);
    }

    @GetMapping("/get-event/{id}")
    public Event getEvent(@PathVariable int id) {
        return eventService.getEvent(id);
    }

    @GetMapping("/get-all-events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/get-events-by-date/{date}")
    public List<Event> getEventsByDate(@PathVariable String date) {
        return eventService.getEventsByDate(date);
    }

    @DeleteMapping("/delete-event/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }
}
