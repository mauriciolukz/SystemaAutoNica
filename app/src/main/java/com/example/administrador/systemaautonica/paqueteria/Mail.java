package com.example.administrador.systemaautonica.paqueteria;

/**
 * Created by Administrador on 3/3/2018.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail extends AsyncTask<Void, Integer, Void> {

    private String host = "mail.autonica.com";
    private String mail_head_name = "this is head of this mail";
    private String mail_head_value = "this is head of this mail";
    private String mail_to = "ramon.rodriguez@autonica.com";
    private String mail_from = "christian.gurdian@autonica.com";//using gmail server
    private String mail_subject = "this is the subject of this test mail";
    private String mail_body = "this is mail_body of this test mail";
    private String personalName = "Prueba";

    public void sendMail(Context df) throws SendFailedException{
        try {
            Properties props = new Properties();
            Authenticator auth = new Email_Autherticator();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            System.out.println(props);
            Session session = Session.getDefaultInstance(props,auth);

            MimeMessage message = new MimeMessage(session);
            message.setContent("Hello","text/plain");
            message.setSubject(mail_subject);
            message.setText(mail_body);
            message.setHeader(mail_head_name, mail_head_value);
            message.setSentDate(new Date());
            Address address = new InternetAddress(mail_from,personalName);
            message.setFrom(address);
            Address toaddress = new InternetAddress(mail_to);
            message.addRecipient(Message.RecipientType.TO,toaddress);
            Toast.makeText(df.getApplicationContext(),""+message, Toast.LENGTH_SHORT).show();
            Transport.send(message);
            Toast.makeText(df.getApplicationContext(),"Mensaje Enviado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(df.getApplicationContext(),"Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }
}
