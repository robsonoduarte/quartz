package br.com.mystudies.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class App{

    public static void main( String[] args ) throws SchedulerException{

    	 Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

         scheduler.start();


         JobDetail jobDetail =
        		 newJob(HelloJob.class)
        		 	.withIdentity("job1", "group1")
        		 	.build();

         Trigger trigger =
        		 newTrigger()
        		 	.withIdentity("trigger1", "group1")
        		 	.startNow()
        		 	.withSchedule(
        		 			simpleSchedule()
        		 			.withIntervalInSeconds(10)
        		 			.repeatForever()
        		 		).build();


         scheduler.scheduleJob(jobDetail,trigger);

    }


}
