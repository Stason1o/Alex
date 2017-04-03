package com.endava.cronJobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

/**
 * Created by sbogdanschi on 3/04/2017.
 */
public class MyJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Cron job MyJob is running every 60 secs: " + LocalDateTime.now());
    }
}
