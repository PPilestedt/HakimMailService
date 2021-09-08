package presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailResource {


    @PostMapping
    public String sendWelcomMail(@RequestBody String jsonbody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Mail mail = objectMapper.readValue(jsonbody, Mail.class);



        return "sending welcome mail";
    }


}
