package com.yy.example.event.java;

import java.util.EventListener;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午7:00
 */
public interface DoorListener extends EventListener{

    void dealDoorEvent(DoorEvent doorEvent);
}
