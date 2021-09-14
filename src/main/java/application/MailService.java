package application;

import domain.MailContent;

import java.io.IOException;

public class MailService {

    SendGridIntegration sendGrid;

    public boolean sendMailToSendgrid(MailContent mailContent){
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
