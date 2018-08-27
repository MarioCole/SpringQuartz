package com.supermap.controller;

import com.supermap.entity.RunnableJob;
import com.supermap.service.RunnableJobService;
import com.supermap.utils.orderdJobUtils.OrderdJobUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class RunnableJobController {

    @Autowired
    private RunnableJobService runnableJobService;

    @Autowired
    private OrderdJobUtils orderdJobUtils;

    @RequestMapping(value = "addRunnable",method = RequestMethod.GET)
    public void addRunnable(@RequestParam(value = "type") String type,
                              HttpServletRequest request,
                              HttpServletResponse response,
                              Map<String,String> map) throws ServletException, IOException {
        RunnableJob runnableJob = new RunnableJob();
        runnableJob.setRunnable_type(type);
        runnableJob.setRunnable_state("0");
        runnableJob.setRunnable_starttime(new Date());
        runnableJobService.saveRunnableJob(runnableJob);

        request.setAttribute("message","添加任务成功");
        request.getRequestDispatcher("/views/message.jsp").include(request,response);
        orderdJobUtils.insertJob(orderdJobUtils.getRunnableJob(runnableJob));
        orderdJobUtils.start();
        orderdJobUtils.getJob();
        orderdJobUtils.stop();

        runnableJob.setRunnable_endtime(new Date());
        runnableJob.setRunnable_state("1");
        runnableJobService.updateRunnableJob(runnableJob);
    }

    @RequestMapping(value = "excuteRunnable",method = RequestMethod.GET)
    public String excute(){
        return null;
    }
}
