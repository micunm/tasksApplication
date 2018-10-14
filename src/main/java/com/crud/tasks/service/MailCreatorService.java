package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

/*    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyConfig companyConfig;*/

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://micunm.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("godbye_msg","Best Regards,");

       context.setVariable("admin_name", adminConfig.getAdminName());
       context.setVariable("company_name", companyConfig.getCompanyName() );
        context.setVariable("company_email", companyConfig.getCompanyEmail());
        context.setVariable("company_phone", companyConfig.getCompanyPhone());
        context.setVariable("company_goal", companyConfig.getCompanyGoal());

        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
