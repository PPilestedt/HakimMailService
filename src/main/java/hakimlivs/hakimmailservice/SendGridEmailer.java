package hakimlivs.hakimmailservice;



import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import java.io.IOException;



public class SendGridEmailer
{
	public static void main(String[] args) throws IOException
	{
		MailServicePOST
		MSPOST;
		
		String
		toPost ,
		fromPost ,
		subjectPost ,
		contentPost ,
		
		toGet ,
		fromGet ,
		subjectGet,
		contentGet;
		
		
		toPost = "<EPOST_ADDRESS>";
		subjectPost = "ämne";
		contentPost = "innehåll";
		
		
		MSPOST = new MailServicePOST(toPost);
		MSPOST.setSubject(subjectPost);
		MSPOST.setContent(contentPost);
		
		
		toGet = MSPOST.getTo();
	//	fromGet = MSPOST.getFrom();
		subjectGet = MSPOST.getSubject();
		contentGet = MSPOST.getContent();
		
		
		
		
		
		
		
		MSPOST.send();
		
		
		
		
		
		
	/*	Email from = new Email("noreply.hakimlivs@gmail.com");
		Email to = new Email("noreply.hakimlivs@gmail.com"); // use your own email address here
		
		String subject = "Sending with Twilio SendGrid is Fun";
		Content content = new Content("text/html", "and <em>easy</em> to do anywhere with <strong>Java</strong>");
		
		Mail mail = new Mail(from, subject, to, content);
		
		SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		Request request = new Request();
		
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		
		Response response = sg.api(request);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());*/
	}
	
}