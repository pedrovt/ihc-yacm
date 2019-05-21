package com.ihc.yacm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assistant {

    // /------------\
    // | ATTRIBUTES |
    // \------------/
    private static Assistant instance = new Assistant();
    private static List<Event> eventList = new ArrayList<>();


    // /--------------\
    // | CONSTRUCTORS |
    // \--------------/
    private Assistant () {}


    // /-----------\
    // | FUNCTIONS |
    // \-----------/
    public static Assistant getInstance () {
        return instance;
    }

    public static Assistant getInstance (List<Event> eventList) {
        instance.eventList = eventList;
        return instance;
    }

    public static Assistant getInstance (Event[] eventList) {
        Collections.addAll(instance.eventList,eventList);
        return instance;
    }

    public static List<Event> getEventList() { return eventList; }

    public static List<String> getEventNames() {
        List<String> nameList = new ArrayList<>();
        for (Event event : eventList) {
            nameList.add(event.getName());
        }
        return nameList;
    }

    public static void removeEvent (Event event) {
        for (Event e : eventList) {
            if (e.equals(event)) {
                eventList.remove(e);
                break;
            }
        }
    }

    public static void addEvent (Event event) { eventList.add(event); }
}