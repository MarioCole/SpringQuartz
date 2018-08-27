package com.supermap.utils.orderdJobUtils;

import com.supermap.entity.RunnableJob;
import com.supermap.entity.VariableQueue;
import com.supermap.job.myjob1.TestRunnableJob1;
import com.supermap.job.myjob1.TestRunnableJob2;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class QueueUtils {

    public void start(VariableQueue variableQueue){
        variableQueue.setRunning(true);
    }

    public void stop(VariableQueue variableQueue){
        variableQueue.setRunning(false);
    }

    public void insertRunable(Runnable job,VariableQueue variableQueue){
        try {
            System.out.println("插入任务中");
            if (variableQueue.getQueue().offer(job,5000L,TimeUnit.MILLISECONDS) == false){
                System.out.println("任务插入失败");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public void getJob(VariableQueue variableQueue){
        while (variableQueue.isRunning()){
            try {
                for (int i = 0; i<variableQueue.getQueue().size(); i++){
                    Runnable job = variableQueue.getQueue().poll(5000L,TimeUnit.MILLISECONDS);
                    System.out.println("取出任务中...");
                    //Thread.sleep(5000);
                    if (job != null){
                        job.run();
                    }

                }
                if (variableQueue.getQueue().size() == 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
    }


    public static Runnable getRunnableJob(RunnableJob runnableJob){
        switch (runnableJob.getRunnable_type()){
            case "test1" :{
                return new TestRunnableJob1();
            }
            case "test2" :{
                return new TestRunnableJob2();
            }
        }
        return null;
    }
}
