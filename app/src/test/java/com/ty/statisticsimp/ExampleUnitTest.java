package com.ty.statisticsimp;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest
{
    @Test
    public void addition_isCorrect() throws Exception
    {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void threadPool() throws Exception
    {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        MyRunnable runnable = new MyRunnable();
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable.clone());
        threadPoolExecutor.execute(runnable.clone());
        threadPoolExecutor.execute(runnable.clone());
        Thread.sleep(1000000);
    }

    private static class MyRunnable implements Runnable, Cloneable
    {
        public int count=0;

        public MyRunnable clone()
        {
            MyRunnable myRunnable=null;
            try
            {
                myRunnable = (MyRunnable) super.clone();
            }
            catch (CloneNotSupportedException e)
            {
                e.printStackTrace();
            }

            return myRunnable;
        }

        public MyRunnable build()
        {
            return this;
        }

        @Override
        public void run()
        {
            while (true)
            {
                System.out.println(Thread.currentThread().getName() + ": 第"+count+"次run\r\n");
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }
}