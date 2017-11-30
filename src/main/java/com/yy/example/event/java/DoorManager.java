package com.yy.example.event.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午7:14
 */
public class DoorManager {

    List<DoorListener> doorListeners = new ArrayList<>();

    public void addListener(DoorListener doorListener){
        doorListeners.add(doorListener);
    }

    public void delListener(DoorListener doorListener){
        doorListeners.remove(doorListener);
    }

    public void notifyDoors(DoorEvent doorEvent){
        doorListeners.forEach(listener -> {
            listener.dealDoorEvent(doorEvent);
        });
    }

    public void openDoor(){
        DoorEvent doorEvent = new DoorEvent(this);
        doorEvent.setState(1);
        notifyDoors(doorEvent);
    }

    public void closeDoor(){
        DoorEvent doorEvent = new DoorEvent(this);
        doorEvent.setState(0);
        notifyDoors(doorEvent);
    }

}
