package com.alithgeel.Entity;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.mail.SimpleMailMessage;
        import org.springframework.mail.javamail.JavaMailSender;
        import org.springframework.mail.javamail.MimeMessageHelper;
        import org.springframework.stereotype.Component;
        import javax.mail.internet.MimeMessage;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender  javaMailSender;

    public void send (String to ,String subject,String body){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
    }

    public void sendSimpleMessage(  String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);

    }

}
