package com.sdm.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    public void sendEmail() {
        Mail mail = new Mail();
        mail.setTemplateId("d-0db7b85043744055b49a90f59f614a41");

        Email fromEmail = new Email();
        fromEmail.setName("Rtt technologies");
        fromEmail.setEmail("rtt.technologies.poc@gmail.com");

        Email mailId = new Email();
        mailId.setName("Ravikanth Thota");
        mailId.setEmail("ravikanththota9@gmail.com");

        Personalization personalization = new Personalization();
        personalization.addTo(mailId);

        mail.setFrom(fromEmail);
        mail.addPersonalization(personalization);
        mail.setSubject("Reset password");

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
