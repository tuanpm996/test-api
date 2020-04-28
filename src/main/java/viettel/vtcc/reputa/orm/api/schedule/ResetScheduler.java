package viettel.vtcc.reputa.orm.api.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import viettel.vtcc.reputa.orm.api.repository.UserRequestRepository;

@Configuration
@EnableScheduling
@Slf4j
public class ResetScheduler {

    @Autowired
    private UserRequestRepository userRequestRepository;

    @Scheduled(cron = "0 52 * * * *")
    @Scheduled(fixedDelay = 4000)
    public void scheduleFixedDelayTask() {
        log.info("delete all set");
        synchronized (userRequestRepository) {
            userRequestRepository.deleteAll();
        }
    }
}
