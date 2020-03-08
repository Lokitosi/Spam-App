package meme.gmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemeGmail {
    

    public static void main(String[] args) throws AddressException, MessagingException {
        String texto ="La Liga Comunista, una organización obrera internacional, que en las circunstancias de la época -huelga decirlo- sólo podía ser secreta, encargó a los abajo firmantes, en el congreso celebrado en Londres en noviembre de 1847, la redacción de un detallado programa teórico y práctico, destinado a la publicidad, que sirviese de programa del partido.  Así nació el Manifiesto, que se reproduce a continuación y cuyo original se remitió a Londres para ser impreso pocas semanas antes de estallar la revolución de febrero.  Publicado primeramente en alemán, ha sido reeditado doce veces por los menos en ese idioma en Alemania, Inglaterra y Norteamérica.";
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "fred.starks.97@gmail.com";
        String contrasena = "fredstark123";
        String receptor = "recibidor2019@gmail.com";
        String asunto = "Manifesto comunista";
        
        System.out.println("baby");
        for (int a = 0 ; a <= texto.length() ; a++) {
            
            MimeMessage mail = new MimeMessage(sesion);
            String mensaje = Character.toString(texto.charAt(a));
            try {
                mail.setFrom(new InternetAddress(correoEnvia));
                mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
                mail.setSubject(mensaje);
                mail.setText(asunto);
                

                Transport transportar = sesion.getTransport("smtp");
                transportar.connect(correoEnvia, contrasena);
                transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                transportar.close();
                System.out.println("mensaje enviado"+a);
                
            } catch (AddressException ex) {
                System.out.println("error 1");
            } catch (MessagingException ex) {
                System.out.println("error 2");
            }
        }
    }

}
