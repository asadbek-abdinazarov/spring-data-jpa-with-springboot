package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
public class ScheduleTasks {

   /* @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedDelay() {
        System.out.println("Delay Time : " + new Date());
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

   /* @Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void fixedRate() {
        System.out.println("Rate Time : " + new Date());
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

    /*@Scheduled(initialDelay = 3, fixedRate = 1 , timeUnit = TimeUnit.SECONDS)
    public void initialDelay() {
        System.out.println("initialDelay Time : " + new Date());
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Scheduled(cron = "0 0 20 LW * *", zone = "Asia/Tashkent")// * 0 8 * * MON,
    public void cronSchedule1() {
        System.out.println("cronSchedule1 Time : " + new Date());
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
