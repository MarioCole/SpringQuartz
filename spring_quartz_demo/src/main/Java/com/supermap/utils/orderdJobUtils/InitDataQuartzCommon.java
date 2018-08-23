package com.supermap.utils.orderdJobUtils;

/**
 * 初始化数据清理任务
 */
public class InitDataQuartzCommon {
    private static int count = 0;

    public void startClearData(){

        //初始化任务顺序
        OrderdJobUtils orderdJobUtils = new OrderdJobUtils();
        //启动任务
        orderdJobUtils.start();

        for (int i = 0; i<10; i++){
            orderdJobUtils.insertJob(new Runnable() {
                @Override
                public void run() {
                    System.out.println(count++);
                }
            });
        }

        synchronized (orderdJobUtils){
            try {
                orderdJobUtils.wait(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }

        orderdJobUtils.stop();
    }
}
