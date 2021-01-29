package com.segementfault.base;

import sun.management.BaseOperatingSystemImpl;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.concurrent.ForkJoinPool;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/01/22
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(ManagementFactory.getOperatingSystemMXBean().getName());
        StopableAction action = new StopableAction();
        Thread thread = new Thread(action);
        thread.start();
        thread.interrupt();
        thread.join();
    }

    private static class  StopableAction implements Runnable{
        /**
         * 确保原子操作
         */
        private volatile boolean stopped;
        @Override
        public void run() {
            if(stopped){
                System.out.println("Action 中止......");
                return;
            }
            System.out.println("Action 执行......");
        }
        public void stop(){
            this.stopped = true;
        }

    }
}
