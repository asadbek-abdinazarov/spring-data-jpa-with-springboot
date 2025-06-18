package uz.javachi.spring_data_jpa_with_spring_boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ReportSenderService {

    /*ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );*/

    @Async
    public void sendReport(String report) {
       /* Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception ignored) {
            }
            log.info("Report sent!!!");
        };*/
//        new Thread(runnable).start();
//        executorService.submit(runnable);

//        CompletableFuture.runAsync(runnable);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ignored) {
        }
        log.info("Report sent!!!");

        throw new RuntimeException("Exception in ReportSenderService: " + LocalDate.now());

    }


}
