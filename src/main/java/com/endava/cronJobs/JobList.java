package com.endava.cronJobs;

import com.endava.entities.Employee;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbogdanschi on 3/04/2017.
 */
public class JobList implements Job{
    private static List<Employee> list;
    private static int counter;

    static {
        list = new ArrayList<Employee>();
        counter = 0;
    }
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Cron Job JobList is adding new employee...");
        list.add(new Employee("Name" + counter, "Surname" + counter, "work" + counter));
        System.out.println("New Employee has been added! " + "Date: " + LocalDateTime.now());
        counter++;
        list.forEach(System.out::println);
    }

    public static List<Employee> getList() {
        return list;
    }

    public static void setList(List<Employee> list) {
        JobList.list = list;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        JobList.counter = counter;
    }


}
