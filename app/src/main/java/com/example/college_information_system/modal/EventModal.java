package com.example.college_information_system.modal;

public class EventModal {
    private String eventTitle;
    private String eventDes;
    private String eventImage;
    private String postedby;
    private String event_date;
    private String event_time;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDes() {
        return eventDes;
    }

    public void setEventDes(String eventDes) {
        this.eventDes = eventDes;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getPostedby() {
        return postedby;
    }

    public void setPostedby(String postedby) {
        this.postedby = postedby;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public EventModal(String eventTitle, String eventDes, String eventImage, String postedby, String event_date, String event_time) {
        this.eventTitle = eventTitle;
        this.eventDes = eventDes;
        this.eventImage = eventImage;
        this.postedby = postedby;
        this.event_date = event_date;
        this.event_time = event_time;
    }


}
