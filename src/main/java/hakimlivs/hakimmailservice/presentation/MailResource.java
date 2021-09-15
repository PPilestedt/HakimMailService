package hakimlivs.hakimmailservice.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hakimlivs.hakimmailservice.application.MailServicen;
import hakimlivs.hakimmailservice.domain.MailContent;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MailResource {

    private final MailServicen mailServicen = new MailServicen();

    @GetMapping("/")
    public String index(){
        return "Mailservice running";
    }


    @PostMapping("/send")
    public String sendWelcomeMail(@RequestBody String jsonbody) throws JsonProcessingException {

        //TODO: Skriv om denna så att det inte är massa logik här

        ObjectMapper objectMapper = new ObjectMapper();
        MailContent mail = objectMapper.readValue(jsonbody, MailContent.class);

        if(mailServicen.sendMailToSendgrid(mail)){
            return "Mail sent to " + mail.getTo() + " from " + mail.getFrom();
        }else{
            return "Failed to send mail";
        }
    }


}
