package com.yy.example.event.java;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午7:21
 */
public class DoorTest {

    public static void main(String[] args) {
        DoorManager doorManager = new DoorManager();
        doorManager.addListener(new FrontDoorListener());
        doorManager.openDoor();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doorManager.closeDoor();
    }
}
