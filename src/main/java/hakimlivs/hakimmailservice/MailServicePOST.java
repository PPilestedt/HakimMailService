package hakimlivs.hakimmailservice;



import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import org.springframework.stereotype.Service;
import java.io.IOException;



@Service
public class MailServicePOST
{
	/*Start: internal variables*/
	private String
	toString ,
	fromString ,
	subjectString ,
	contentString ,
	subjectStringFinal ,
	contentStringFinal;
	
	private Email
	toEmail ,
	fromEmail;
	
	private Content
	contentContent;
	
	private Mail
	mail;
	
	private Request
	request;
	
	private Response
	response;
	
	private SendGrid
	sendGrid;
	/*End: internal variables*/
	
	
	
	/*Start: constructors*/
	MailServicePOST()
	{
		clearAll();
	}
	
	MailServicePOST(String toEmail)
	{
		clearAll();
		setTo(toEmail);
		
	}
	
	MailServicePOST(String toEmail, String fromEmail)
	{
		clearAll();
		setTo(toEmail);
		setFrom(fromEmail);
		
	}
	
	MailServicePOST(String toEmail, String fromEmail, String subject)
	{
		clearAll();
		setTo(toEmail);
		setFrom(fromEmail);
		setSubject(subject);
		
	}
	
	MailServicePOST(String toEmail, String fromEmail, String subject, String content)
	{
		clearAll();
		setTo(toEmail);
		setFrom(fromEmail);
		setSubject(subject);
		setContent(content);
		
	}
	/*End: constructors*/
	
	
	
	/*Start: send Email*/
	public void send() throws IOException
	{
		setAllUserFeedVariables();
		post();
		
	}
	/*End: send Email*/
	
	
	
	/*Start: public set-methods*/
	public void setTo(String toString)
	{
		this.toString = toString;
		
	}
	
	public void setFrom(String fromString)
	{
		this.fromString = fromString;
		
	}
	
	public void setSubject(String subjectString)
	{
		this.subjectString = subjectString;
		
	}
	
	public void setContent(String content)
	{
		this.contentString = content;
		
	}
	/*End: public set-methods*/
	
	
	
	/*Start: public get-methods*/
	public String getTo()
	{
		return toString;
		
	}
	
	public String getFrom()
	{
		return fromString;
		
	}
	
	public String getSubject()
	{
		return subjectString;
		
	}
	
	public String getContent()
	{
		return contentString;
		
	}
	/*End: public get-methods*/
	
	
	
	/*Start: public clear-methods*/
	public void clearTo()
	{
		this.toString = null;
		toEmail = null;
		
	}
	
	public void clearFrom()
	{
		this.fromString = null;
		this.fromEmail = null;
		
	}
	
	public void clearSubject()
	{
		this.subjectString = null;
		this.subjectStringFinal = null;
		this.contentContent = null;
		
	}
	
	public void clearContent()
	{
		this.contentString = null;
		this.contentStringFinal = null;
		this.contentContent = null;
		
	}
	
	public void clearAll()
	{
		clearTo();
		clearFrom();
		clearSubject();
		clearContent();
		
	}
	/*End: public clear-methods*/
	
	
	
	/*Start: standard private variable-setting methods*/
	private void setAllUserFeedVariables()
	{
		setToEmail();
		setContentStringFinal();
		setSubjectStringFinal();
		setFromEmail();
		
	}
	private void post() throws IOException
	{
		setContentContent();
		setMail();
		setSendGrid();
		setRequest();
		setResponse();
		
	}
	
	private void setToEmail()
	{
		String
		tempString;
		
		
		
		tempString = toString;
	
		
		
		toEmail = new Email(tempString);
		
	}
	
	private void setContentStringFinal()
	{
		String
		tempString;
		
		
		
		tempString = correctIfStringIsNull(contentString);
		
		
		
		contentStringFinal = tempString;
		
	}
	
	private void setSubjectStringFinal()
	{
		String
		tempString;
		
		
		
		tempString = correctIfStringIsNull(subjectString);
		
		
		
		subjectStringFinal = tempString;
		
	}
	
	private void setFromEmail()
	{
		String
		tempString;
		
		int
		emailLength;
		
		
		
		tempString = correctIfStringIsNull(fromString);
		emailLength = tempString.length();
		
		if(emailLength == 0)
		{
			tempString = setDefaultSenderEmail();
			
		}
		
		
		fromEmail = new Email(tempString);
		
	}
	
	private void setContentContent()
	{
		contentContent = new Content("text/html", contentStringFinal);
		
	}
	
	private void setMail()
	{
		mail = new Mail(fromEmail, subjectStringFinal, toEmail, contentContent);
		
	}
	
	private void setSendGrid()
	{
		sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		
	}
	
	private void setRequest() throws IOException
	{
		request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		
	}
	
	private void setResponse() throws IOException
	{
		response = sendGrid.api(request);
		
	}
	/*End: standard private variable-setting methods*/
	
	
	
	/*Start: error-correcting private methods*/
	private String setDefaultSenderEmail()
	{
		String
		defaultSenderEmail;
		
		
		
		defaultSenderEmail = "noreply.hakimlivs@gmail.com";
		
		
		
		return defaultSenderEmail;
		
	}
	
	private String correctIfStringIsNull(String string)
	{
		String
		returnString;
		
		
		try
		{
			returnString = string;
			
		}
		catch(NullPointerException e)
		{
			returnString = "";
			
		}
		
		
		return returnString;
		
	}
	/*End: error-correcting private methods*/
	
}