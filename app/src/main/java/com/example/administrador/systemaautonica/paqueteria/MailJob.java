package com.example.administrador.systemaautonica.paqueteria;

import android.content.SharedPreferences;
import android.os.AsyncTask;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by Administrador on 3/3/2018.
 */

public class MailJob extends AsyncTask<MailJob.Mail,Void,Void> {
    private final String user;
    private final String pass;
    private final Context df;

    public MailJob(String user, String pass, Context df) {
        super();
        this.user=user;
        this.pass=pass;
        this.df = df;
    }

    @Override
    protected Void doInBackground(Mail... mails) {

        String mensaje = "";
        String asunto = "";
        String de = "";
        String para = "";

        for (Mail mail:mails) {
            mensaje = mail.content;
            asunto = mail.subject;
            de = mail.de;
            para = mail.para;
        }

        SharedPreferences sharedPref = df.getSharedPreferences("Systema_data_archivo_complejo", Context.MODE_PRIVATE);
        String defaultValue1 = sharedPref.getString("Nombre","");
        String defaultValue2 = sharedPref.getString("permiso","");
        String defaultValue3 = sharedPref.getString("lugar","");
        String correo = sharedPref.getString("correo","");
        String NombreCompleto = sharedPref.getString("NombreCompleto","");
        String mensajeContenido = "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "\t\t<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.10/css/all.css\" integrity=\"sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg\" crossorigin=\"anonymous\">\n" +
                "\t\t<link href=\"https://fonts.googleapis.com/css?family=Lato|Open+Sans|Oswald|Playfair+Display\" rel=\"stylesheet\">\n" +
                "\t\t<style>\n" +
                "\t\t\t.image_data_index{width: 20px;}"+
                "\t\t\ttable {\n" +
                "\t\t\t\tborder: 1px solid #ccc;\n" +
                "\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\tmargin: 0;\n" +
                "\t\t\t\tpadding: 0;\n" +
                "\t\t\t\twidth: 300px;\n" +
                "\t\t\t\ttable-layout: fixed;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\ttable caption {\n" +
                "\t\t\t\tfont-size: 1.5em;\n" +
                "\t\t\t\tmargin: .5em 0 .75em;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\ttable tr {\n" +
                "\t\t\t\tbackground-color: #f8f8f8;\n" +
                "\t\t\t\tborder: 1px solid #ddd;\n" +
                "\t\t\t\tpadding: .35em;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\ttable th,\n" +
                "\t\t\ttable td {\n" +
                "\t\t\t\tpadding: .625em;\n" +
                "\t\t\t\ttext-align: center;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\ttable th {\n" +
                "\t\t\t\tfont-size: .85em;\n" +
                "\t\t\t\tletter-spacing: .1em;\n" +
                "\t\t\t\ttext-transform: uppercase;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\tth, td {\n" +
                "\t\t\t   font-family: 'Open Sans', sans-serif;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\t.contenido{\n" +
                "\t\t\t\tmargin:0 25px;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\th1, h2, h3, h4, h5{\n" +
                "\t\t\t\tfont-family: 'Lato', sans-serif;\n" +
                "\t\t\t\tfont-style: normal;\n" +
                "\t\t\t\t/*font-family: \"Raleway script=all rev=2\";\n" +
                "\t\t\t\tfont-style: normal;*/\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\tp{\n" +
                "\t\t\t\tfont-family: 'Open Sans', sans-serif;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\t.positivo{color:#4caf50}\n" +
                "\t\t\t.negativo{color:#f40303}\n" +
                "\t\t\t\n" +
                "\t\t\t.image_fondo{\n" +
                "\t\t\t\twidth: 100%;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\timg {\n" +
                "\t\t\t\twidth: 100%;\n" +
                "\t\t\t\theight: auto;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\t.contenedor_img{\n" +
                "\t\t\t\twidth: 45%;\n" +
                "\t\t\t\tfloat:left;\n" +
                "\t\t\t\tmargin: 2.5%;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\t.footer_data{\n" +
                "\t\t\t\ttext-align:right;\n" +
                "\t\t\t}\n" +
                "\t\t\t\n" +
                "\t\t\t.footer_data p{\n" +
                "\t\t\t\tmargin:0;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t</style>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<img src=\"http://www.autonica.com/image/coverapicambios-03.jpg\" class=\"image_fondo\"></img>\n" +
                "\t\t<div class=\"contenido\">\n" +
                mensaje +
                "\t\t\t<br/><br/>\n" +
                "\t\t\t<p>Las imagenes que se tomaron de las imagenes estan en archivo adjunto</p>\n" +
                "\t\t\t<br/><br/>\n" +
                "\t\t\t<div class=\"footer_data\">\n" +
                "\t\t\t\t<p><b>Recepcionista</b></p>\n" +
                "\t\t\t\t<p style='color:#ec4949'>"+NombreCompleto+"</p>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>";

        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "192.168.0.134");
            props.setProperty("mail.smtp.starttls.enable", "false");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail.smtp.user", "ivan.morales@autonica.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            Multipart multiPart = new MimeMultipart("alternative");

            message.setFrom(new InternetAddress(de));
            message.setRecipients(Message.RecipientType.TO, para);
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress("anabell.sequeira@autonica.com"));//
            message.addRecipients(Message.RecipientType.CC,correo);
            message.setSubject(asunto);
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(mensajeContenido, "text/html; charset=ISO-8859-1");
            htmlPart.setHeader("MIME-Version", "1.0");
            htmlPart.setHeader("Content-Transfer-Encoding", "base64");

            multiPart.addBodyPart(htmlPart);

            String ruta = new OtrasClases().ruta_fotos;

            File dir = new File(ruta);

            if (dir.exists()){
                File[] ficheros = dir.listFiles();
                for (int x=0;x<ficheros.length;x++){
                    String g = ficheros[x].getName();
                    BodyPart adjunto = new MimeBodyPart();
                    adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta+g)));
                    adjunto.setFileName(g);
                    multiPart.addBodyPart(adjunto);
                }
            }

            message.setContent(multiPart, "text/html; charset=ISO-8859-1");

            Transport t = session.getTransport("smtp");
            t.connect(user, pass);
            t.sendMessage(message, message.getAllRecipients());
            t.close();

        }catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {

        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(df, "Ha sido enviado", Toast.LENGTH_LONG).show();
    }

    public static class Mail{
        private final String subject;
        private final String content;
        private final String de;
        private final String para;

        public Mail(String subject, String content, String de, String para){
            this.subject=subject;
            this.content=content;
            this.de = de;
            this.para = para;
        }
    }
}
