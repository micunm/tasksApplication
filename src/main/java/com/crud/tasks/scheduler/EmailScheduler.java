package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT="Tasks: Once a day email";
    private String taskString="task";

    @Scheduled(cron="0 0 9 * * *")
 //   @Scheduled(fixedDelay = 100000)
    public void sendInformationEmail() {
        long size=taskRepository.count();

/*        if (size==1) {
            taskString="task";
        } else {
            taskString="tasks";
        }*/

        taskString=(size == 1) ? "task" : "tasks";
        simpleEmailService.sendDaily(new Mail(
                adminConfig.getAdminMail(),
                null,
                SUBJECT,
                "Currently in database you got: " + size + " "+taskString)
        );
    }
}
