package com.endava.main;

import com.endava.cronJobs.JobList;
import com.endava.cronJobs.MyJob;
import com.endava.entities.Employee;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

/**
 * Created by sbogdanschi on 3/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        List<Employee> list = JobList.getList();
        try{
            //CRON JOB 1---------------------------------
            JobDetail myJob = JobBuilder.newJob(MyJob.class)
                    .withIdentity("myJob", "group").build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
                    .build();
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(myJob, trigger);

            //CRON JOB 2-------------------------------------
            JobDetail addEmplJob = JobBuilder.newJob(JobList.class)
                    .withIdentity("addEmpl", "group2").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger2", "group2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(addEmplJob, trigger1);

            Thread.sleep(100000);
            scheduler.shutdown();
            scheduler1.shutdown();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
