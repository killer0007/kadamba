package email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
public static void main(String[] args) throws EmailException {
	Email email = new SimpleEmail();
	System.out.println("send email started");
	email.setHostName("smtp.mail.yahoo.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("gopinathvijay007@yahoo.com", "killer@007"));
	//email.setSSL(true);
	//boolean ssl=true;
	email.setSSLOnConnect(true);
	email.setFrom("gopinathvjay007@yahoo.com", "gopi");
	//email.setFrom("gopinathvijay007@yahoo.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test1 mail ... :-)");
	email.addTo("gopinath.n@kadambatechnologies.com");
	System.out.println("sending email");
	
	try {
		email.send();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("mail send successfull");

}
}
