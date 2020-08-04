package com.sdm.controller;

import com.sdm.exception.AuthenticationException;
import com.sdm.model.AuthRequest;
import com.sdm.model.AuthResponse;
import com.sdm.model.BaseDto;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.sdm.constants.IConstants.StandardResponse.SUCCESS;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @GetMapping("/sendemail")
    @CrossOrigin
    public ResponseEntity<BaseDto<String>> authenticateUser()  {
//         Email fromEmail = new Email((String) emailObject.get("fromEmail"));
//        Email toEmail = new Email((String) emailObject.get("toEmail"));
//        String subject = (String) emailObject.get("subject");
//        Content content = new Content("text/plain","Password change");
//        Mail mail = new Mail(fromEmail,subject,toEmail,content);
//        mail.setTemplateId("d-0db7b85043744055b49a90f59f614a41");*//*

        Mail mail = new Mail();
        mail.setTemplateId("d-0db7b85043744055b49a90f59f614a41");

        Email fromEmail = new Email();
        fromEmail.setName("Rtt technologies");
        fromEmail.setEmail("rtt.technologies.poc@gmail.com");

        Email mailId = new Email();
        mailId.setName("Ravikanth Thota");
        mailId.setEmail("ravikanth@elogicsquare.com");

        Personalization personalization = new Personalization();
        // personalization.addCc(mailId);
        personalization.addTo(mailId);
        //personalization.setSubject("Login Process");
        //personalization.addSubstitution("-link-", zuulUrl + "/" + contextRoot + "/#/" + "resetPassword" + "?token=" + getJWToken(userObj.getEmail(), userObj.getFirstName() + " " + userObj.getLastName(), sharedSecret));
        //personalization.addSubstitution("-userName-", userObj.getFirstName());
        //personalization.addSubstitution("-expdays-", String.valueOf(activationLinkExpiryDays));

//          personalization.addSubstitution("-requesterMail-", "");
//          personalization.addSubstitution("-dateRequested-", "");
//          personalization.addSubstitution("-timeRequested-", "");
//

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
        //sendMail();
        return new BaseDto<>("Email sent successfully", SUCCESS.toString(), OK).respond();
    }


    public boolean sendMail() {
        SendGrid sg = new SendGrid("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");
        com.sendgrid.Request request = new com.sendgrid.Request();

        Mail userCreatedMail = buildMail();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");

        try {
            request.setBody(userCreatedMail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());

        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private Mail buildMail() {
        Mail mail = new Mail();
        mail.setTemplateId("d-b52c438f68ff46088b872be0b0f9738d");

        Email fromEmail = new Email();
        fromEmail.setName("Constant Companion");
        fromEmail.setEmail("rtt.technologies.poc@gmail.com");

        Email mailId = new Email();
        mailId.setName("Ravikanth");
        mailId.setEmail("Ravikanththota9@gmail.com");

        Personalization personalization = new Personalization();
        // personalization.addCc(mailId);
        personalization.addTo(mailId);
        personalization.setSubject("Activation Process");
        //personalization.addSubstitution("-url-", "http://google.com");
        //personalization.addSubstitution("-username-", "test");
        //personalization.addSubstitution("-password-", "test@123");

        mail.setSubject("Activation process");
        mail.setFrom(fromEmail);
        mail.addPersonalization(personalization);
        return mail;
    }

}
