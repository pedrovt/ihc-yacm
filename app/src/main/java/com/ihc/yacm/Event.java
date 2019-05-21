package com.ihc.yacm;

import java.util.ArrayList;
import java.util.List;

public class Event {

    // /------------\
    // | ATTRIBUTES |
    // \------------/
    private String name;
    private String date;
    private String location;
    private String tags;
    private List<Participant> participantList = new ArrayList<>();


    // /--------------\
    // | CONSTRUCTORS |
    // \--------------/
    public Event (String name, String date, String location, String tagList) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tagList;
    }

    public Event (String name, String date, String location, String tagList, List<Participant> participantList) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tagList;
        this.participantList = participantList;
    }


    // /-----------\
    // | FUNCTIONS |
    // \-----------/
    public String getName()                     { return this.name; }
    public String getDate()                     { return this.date; }
    public String getLocation()                 { return this.location; }
    public String getTags()                     { return this.tags; }
    public List<Participant> getParticipants()  { return this.participantList; }

    public void setName(String name)                    { this.name = name; }
    public void setDate(String date)                    { this.date = date; }
    public void setLocation(String location)            { this.location = location; }
    public void setTags(String tags)                    { this.tags = tags; }
    public void setTags(List<Participant> participants) { this.participantList = participants; }

    public boolean equals(Event event) {
        return (this.name.equals(event.getName())&&
                this.date.equals(event.getDate())&&
                this.location.equals(event.getLocation())&&
                this.tags.equals(event.getTags()));
    }
}

