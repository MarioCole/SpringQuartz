package com.supermap.service.runnableJobManager;

import com.supermap.entity.RunnableJob;
import com.supermap.entity.VariableQueue;
import com.supermap.utils.orderdJobUtils.QueueUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnableJobServiceManager {

    @Autowired
    private QueueUtils queueUtils;

    private VariableQueue variableQueue = new VariableQueue();

    public void addRunnableJob(List<RunnableJob> list){
        for (RunnableJob runnableJob : list ) {
            queueUtils.insertRunable(QueueUtils.getRunnableJob(runnableJob), variableQueue);
        }
    }


    public void startRunnableJob(){
        queueUtils.start(variableQueue);
    }


    public void stopRunnableJob(){
        queueUtils.stop(variableQueue);
    }

}
