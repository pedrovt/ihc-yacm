package com.ihc.yacm;

import java.util.ArrayList;
import java.util.Collections;

public class Assistant {

    // /------------\
    // | ATTRIBUTES |
    // \------------/
    private static Assistant auxiliarInstance = new Assistant();
    private ArrayList<Event> eventList = new ArrayList<>();


    // /--------------\
    // | CONSTRUCTORS |
    // \--------------/
    private Assistant () {}


    // /-----------\
    // | FUNCTIONS |
    // \-----------/
    public static Assistant getInstance () {
        return auxiliarInstance;
    }

    public static Assistant getInstance (ArrayList<Event> eventList) {
        auxiliarInstance.eventList = eventList;
        return auxiliarInstance;
    }

    public Assistant getInstance (Event[] eventList) {
        Collections.addAll(auxiliarInstance.eventList,eventList);
        return auxiliarInstance;
    }

    public ArrayList<Event> getEventList() { return eventList; }

    public ArrayList<String> getEventNames() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Event event : eventList) {
            nameList.add(event.getName());
        }
        return nameList;
    }

    public void removeEvent (Event event) {
        for (Event e : eventList) {
            if (e.equals(event)) {
                eventList.remove(e);
                break;
            }
        }
    }

    public void addEvent (Event event) { eventList.add(event); }
}