package com.example.universityeventmanagement.service;

import com.example.universityeventmanagement.model.Event;

import java.util.List;

public interface IEventService {

    public void addEvent(Event event);

    public void updateEvent(int id, Event event);

    public Event getEvent(int id);

    public List<Event> getAllEvents();

    public List<Event> getEventsByDate(String date);

    public void deleteEvent(int id);
}
