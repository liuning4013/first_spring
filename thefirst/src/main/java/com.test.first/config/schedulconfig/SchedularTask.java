package com.test.first.config.schedulconfig;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuning on 2017/9/22.
 */
@Component
public class SchedularTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000*5)
/*    @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
    @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
    @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执*/
/*    @Scheduled(cron="*//*6 * * * * ?")*/
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}
