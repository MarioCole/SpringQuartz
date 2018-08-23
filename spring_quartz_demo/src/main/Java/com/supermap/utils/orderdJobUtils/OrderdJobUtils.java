package com.supermap.utils.orderdJobUtils;

import com.supermap.entity.RunnableJob;
import com.supermap.entity.Variable;
import com.supermap.job.myjob1.TestRunnableJob1;
import com.supermap.job.myjob1.TestRunnableJob2;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class OrderdJobUtils {
    Variable var = new Variable();

    /**
     * 启动任务
     */
    public void start(){
        var.setRunning(true);
    }

    /**
     * 停止任务
     */
    public void stop(){
        var.setRunning(false);
    }

    /**
     * 添加任务
     * @param job
     */
    public void insertJob(Runnable job){
        try {
            System.out.println("插入任务中...");
            if (var.getQueue().offer(job, 5000L, TimeUnit.MILLISECONDS) == false){
                System.out.println("任务插入失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public void getJob(){
        while (var.isRunning()){
            try {
                for (int i = 0; i<var.getQueue().size(); i++){
                    Runnable job = var.getQueue().poll(5000L,TimeUnit.MILLISECONDS);
                    System.out.println("取出任务中...");
                    //Thread.sleep(5000);
                    if (job != null){
                        job.run();
                    }

                }
                if (var.getQueue().size() == 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
    }

    public static Runnable getRunnableJob(RunnableJob runnableJob){
        switch (runnableJob.getType()){
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
