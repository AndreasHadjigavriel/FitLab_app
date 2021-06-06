
package Classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//rr
public class Orders_History {
    private String customerName;
    private String itemListName;
    private String customerEmail;
    private List<Product> itemList;
    private Date buyListDate;
    private File donwloadPDF;
    
   
    
   
    
    public void getOldList(Integer listid){
        
    }
  
      public static  String SendEmail(String Email,String Password ,String ToEmail,String Subject,String Text){
        String Msg;
        final String username = Email;
        final String password = Password;

        
       Properties props = new Properties();
       props.put("mail.smtp.auth",true);
       props.put("mail.smtp.starttls.enable", true);
       props.put("mail.smtp.host","");
       props.put("mail.smtp.port", "");
       props.setProperty("", "");
       
       Session session = Session.getInstance(props,new javax.mail.Authenticator(){
         
           protected PasswordAuthentication getPassword(){
            return new PasswordAuthentication(username,password);
        }
    });
        try{
            
            MimeMessage message =  new MimeMessage(session);
            message.setFrom(new InternetAddress(Email));
            message.setRecipients(MimeMessage.RecipientType.TO,
                    InternetAddress.parse(Email));
            message.setSubject(Subject);
            message.setText(Text);
            Transport.send(message);
            Msg ="true";
            return Msg;
        }
        catch(Exception e){
            return e.toString();
        }
        
       
        
    }
}
