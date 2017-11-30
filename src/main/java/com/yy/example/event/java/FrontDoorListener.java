package com.yy.example.event.java;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午7:02
 */
public class FrontDoorListener implements DoorListener{


    @Override
    public void dealDoorEvent(DoorEvent doorEvent) {
        if (doorEvent.getState() != null && doorEvent.getState().equals(1)){
            System.out.println("门即将打开");
        }else {
            System.out.println("门即将关闭");
        }
    }
}
