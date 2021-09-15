package hakimlivs.hakimmailservice.domain;

import com.sendgrid.helpers.mail.objects.Email;

public class MailContent {

    private Email to;
    private Email from;
    private String subject;
    private String body;

    public MailContent() {
    }

    public Email getTo() {
        return to;
    }

    public void setTo(Email to) {
        this.to = to;
    }

    public Email getFrom() {
        return from;
    }

    public void setFrom(Email from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isValid() {
        if(to == null){
            return false;
        }else if(from == null){
            return false;
        }else if(subject == null || subject.equals("")){
            return false;
        }else if(body == null || body.equals("")){
            return false;
        }
        return true;
    }
}
