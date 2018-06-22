package com.smartscity;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;

    public Car(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    public void run() {
        try {
            System.out.println(name + " 已进入赛道...");
            barrier.await();
            TimeUnit.MILLISECONDS.sleep(3000);
            System.out.println(name + " 已到达终点 到达时间：" + System.nanoTime());
        } catch (InterruptedException e) {
            System.out.println(name + " 离开游戏");
        } catch (BrokenBarrierException e) {
            System.out.println(name + " 离开游戏");
        }

    }
}