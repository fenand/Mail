
public class MailClient
{
    // The server used for sending and receiving.

    private MailServer server;

    // The user running this client.

    private String user;

    private boolean encrypted;

    private MailItem LastMail;

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;

        this.user = user;
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);

        if((item.getMessage().contains("regalo") || item.getMessage().contains("viagra"))){

            item = null;
        }

        return item;
    }

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */

    public void printNextMailItem()
    {

        MailItem item = server.getNextMailItem(user);

        if((item.getMessage().contains("regalo") || item.getMessage().contains("viagra"))){

            System.out.println("SPAM");

            if(item == null){
                System.out.println("No new mail.");
            }

            else if (item.getBoolean() == true){

                String message = "" + item.getMessage().replace("?\\", "a").replace("(\\", "e").replace(")\\", "i").replace("{\\", "o").replace("}\\", "u");

                boolean encryptedMessage = true;

                item = new MailItem(user, item.getTo(), item.getSubject(), message, encryptedMessage);

                server.post(item);

                item.print();
            }
            else if (item.getBoolean() == false){

                item.print();
            }
        }
        else {

            item.print();
        }
    }

    /**
     * Print the last mail item
     */
    public void printLastMail()
    {
        MailItem item = server.getNextMailItem(user);

        if(item == null) {

            System.out.println("Error.");
        }
        else {

            LastMail.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String subject, String message)
    {
        boolean encryptedMessage2 = false;

        MailItem item = new MailItem(user, to, subject, message, encryptedMessage2);

        server.post(item);
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendEncryptedMailItem(String to, String subject, String message)
    {
        boolean encryptedMessage2 = true;

        String message2 = "?=?" + message.replace("a", "?\\").replace("e", "(\\").replace("i", ")\\").replace("o", "{\\").replace("u", "}\\");

        MailItem item = new MailItem(user, to, subject, message2, encryptedMessage2);

        server.post(item);

        encrypted = item.getBoolean();
    }

    public void descargaYReenvia()
    {    
        // recibimos un email y lo guardamos

        MailItem correo =  getNextMailItem();

        // Creamos un nuevo email en funcion del recibido

        if(correo ==null){

        }
        else{

            String re = "Re: " + correo.getSubject();

            String gracias = "Gracias por tu mensaje ya me ha llegado. " + correo.getMessage();

            MailItem correoQueQueremosEnviar = new MailItem(user,correo.getTo(),gracias,re,correo.getBoolean());

            server.post(correoQueQueremosEnviar);
        }
    }   

    /**
     * Metodo que permita saber desde un cliente de correo electrónico
     * cuántos correos electrónicos tenemos en el servidor para nosotros
     */

    public void numeroDeCorreos()
    {
        System.out.println("Tiene "+ server.howManyMailItems(user) +

            " nuevo(s) emails en su buzon de entrada");
    }
}