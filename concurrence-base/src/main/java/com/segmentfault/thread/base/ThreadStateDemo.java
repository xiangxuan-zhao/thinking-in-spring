package com.segmentfault.thread.base;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO
 *
 * @author xiangxuan
 * @date 2021/1/21
 */
public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(ThreadStateDemo::execAdd);
        t.start();
        t.join();
        Thread.dumpStack();
        System.out.println(t.getState().name() + "【线程Id】" + t.getId());

    }

    public static void execAdd(){
        System.out.println("核心数" + ForkJoinPool.getCommonPoolParallelism());
    }
}
