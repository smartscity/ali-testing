package com.smartscity;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 题目一、使用java多线程编写一个程序，模拟赛车，每个线程表示一辆赛车，要求所有赛车同时出发。
 * 每辆赛车启动时会打印出启动信息，车辆行驶3000ms后到达终点，打印出到达信息。
 *
 * 思路：
 *      1、创建固定数量线程池
 *      2、赛车线程
 *          3000ms后，stop，print
 *      3、设置集合点
 *      4、开始所有线程
 */
public class App 
{
    public static void main( String[] args )
    {
        ExecutorService service = Executors.newFixedThreadPool(5);
        final CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            service.execute(new Car("赛车" + i, barrier));
        }
        service.shutdown();
    }
}
