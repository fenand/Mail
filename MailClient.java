
public class MailClient
{
    // The server used for sending and receiving.

    private MailServer server;

    // The user runnring this client.

    private String user;

    private boolean encrypted;

    private MailItem LastMail;
    // Recoge el número de mensajes enviados.
    private int mensajeEnviado;
    // Recoge el número de mensajes recibidos.
    private int mensajeRecibido;
    // Recoge el mensaje.
    private String mensaje;
    // Recoge el número de caracteres del mensaje más largo.
    private int numeroDeCaracteresDelMensajeMasLargo;
    // Recoge el nombre del usuario con el mensaje más largo.
    private String usuarioConMensajeMasLargo;

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user )

    {
        this.server = server;

        this.user = user;

        mensajeEnviado = 0;

        mensajeRecibido = 0;

        numeroDeCaracteresDelMensajeMasLargo = 0;

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
        if(item != null) {
            // Contabilizamos el número de mensajes recibidos.
            mensajeRecibido += 1;
            // Introducimos el mensaje que recibe un usuario.
            mensaje = item.getMessage();
            // Obtención del mensaje que tiene el mayor número de caracteres.
            // Obtención del nombre de usuario con el mensaje más largo.
            if(numeroDeCaracteresDelMensajeMasLargo <= mensaje.length()) {
                numeroDeCaracteresDelMensajeMasLargo = mensaje.length();
                usuarioConMensajeMasLargo = item.getFrom();
            }
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
        if(item == null) {

            System.out.println("No new mail.");   
        }
        else if(item.getMessage().contains("regalo") || item.getMessage().contains("viagra")){
            System.out.println("SPAM");
        }

        else{
            item.print();
            // Contabilizamos el número de mensajes recibidos.
            mensajeRecibido += 1;
            // Introducimos el mensaje que recibe un usuario.
            mensaje = item.getMessage();
            // Obtención del mensaje que tiene el mayor número de caracteres.
            // Obtención del nombre de usuario con el mensaje más largo.
            if(numeroDeCaracteresDelMensajeMasLargo <= mensaje.length()) {
                numeroDeCaracteresDelMensajeMasLargo = mensaje.length();
                usuarioConMensajeMasLargo = item.getFrom();
            }
        }
        if(item.getBoolean() == true) {
            String message = "" + item.getMessage().replace("?\\", "a").replace("(\\", "e").replace(")\\", "i").replace("{\\", "o").replace("}\\", "u");
            boolean encryptedMessage = true;
            item = new MailItem(user, item.getTo(), item.getSubject(), message, encryptedMessage);
            server.post(item);
            item.print();
            if (item.getBoolean() == false){
                item.print();
            }
        }

    }

    /**
     * Print the last mail item
     */
    public void printLastMail()
    {
        MailItem item = server.getNextMailItem(user);

        if(LastMail == null) {

            System.out.println("Error, no se ha recibido  ningún mensaje");
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
        // Contabilizamos el número de mensajes enviados.
        mensajeEnviado += 1;
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

        String message2 = "?=? " + message.replace("a", "?\\").replace("e", "(\\").replace("i", ")\\").replace("o", "{\\").replace("u", "}\\");

        MailItem item = new MailItem(user, to, subject, message2, encryptedMessage2);

        server.post(item);

        encrypted = item.getBoolean();
    }

    public void descargaYReenvia()
    {    
        // parte 03
        // recibimos un email y lo guardamos
        MailItem correo = server.getNextMailItem(user);
        // Creamos un nuevo email en funcion del recibido y comprobamos que este encriptado o no
        if(correo ==null){
            // da un mensaje por pantalla si no hay correos
            System.out.println("No new mail.");
        }
        else{
            //crea una variable tipo string llamada re para devolver el asunto del correo que se recibe para reenviarlo
            String re = "Re: " + correo.getSubject();
            // mira si el mensaje esta encriptado

            if (correo.getBoolean() == false){
                // en el string gracias  guarda las gracias y el mensaje que has recibido para luego reenviarlo
                String gracias = "Gracias por tu mensaje ya me ha llegado.\n " + "Tu Mensaje es: " +correo.getMessage();
                //crea un nuevo mensaje o item y lo envia
                MailItem correoQueQueremosEnviar = new MailItem(user,correo.getFrom(), re, gracias, correo.getBoolean());
                server.post(correoQueQueremosEnviar);
            }
            else {
                // aqui el menaje esta encriptado y se desencripta 
                String gracias = "" + correo.getMessage().replace("?\\", "a").replace("(\\", "e").replace(")\\", "i").replace("{\\", "o").replace("}\\", "u");
                // despues de guardar en gracias las instrucciones de desencritado guardamos las gracias y el mensaje para reenviarlo
                gracias = "Gracias por tu mensaje ya me ha llegado.\n " + "Tu Mensaje es: " + gracias;
                // creamos el item nuevo y lo enviamos
                MailItem correoQueQueremosEnviar = new MailItem(user,correo.getFrom(), re, gracias, correo.getBoolean());
                server.post(correoQueQueremosEnviar); 
            }
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

    /**
     * Muestra por pantalla el número total de mensajes recibidos,
     * el número total de mensajes enviados y la dirección de correo
     * de la persona que envió el email más largo con el número de
     * caracteres.
     */
    public void numeroMensajeYCorreoMasLargo() {
        System.out.println("El número de mensajes enviados es " + mensajeEnviado);
        System.out.println("El número de mensajes recibidos es " + mensajeRecibido);
        if(mensajeRecibido > 0) {
            System.out.println("El correo recibido con el mensaje más largo es de " + usuarioConMensajeMasLargo + " y tiene " + numeroDeCaracteresDelMensajeMasLargo + " caracteres");
        }
    }
}