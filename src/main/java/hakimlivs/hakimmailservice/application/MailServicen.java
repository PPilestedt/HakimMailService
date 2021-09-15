package hakimlivs.hakimmailservice.application;

import hakimlivs.hakimmailservice.domain.MailContent;
import hakimlivs.hakimmailservice.presentation.SendGridIntegration;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class MailServicen {

    SendGridIntegration sendGrid = new SendGridIntegration();

    public boolean sendMailToSendgrid(MailContent mailContent){

        //TODO:Här skulle logigen från hakimlivs.hakimmailservice.presentation vara

        if(mailContent.isValid()){
            try {
                sendGrid.sendMail(mailContent);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }


}
