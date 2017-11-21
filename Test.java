public class Test
{

    public Test()
    {
    }

    public String testFuncionalidad01(){
        int numeroDeTests = 0;
        int numeroDeTestsOk = 0;
        int numeroDeTestsFail = 0;
        String proceso = "";

        MailServer server = new MailServer();
        MailClient client1 = new MailClient(server,"client1");
        MailClient client2 = new MailClient(server, "client2");

        client1.sendMailItem("client2", "Prueba", "Prueba");
        System.out.println("Enviando un E-mail");
        numeroDeTests = numeroDeTests + 1;
        System.out.println("Examinando los E-mails recibidos en el servidor");
        if (server.howManyMailItems("client2") == numeroDeTests){
            numeroDeTestsOk =numeroDeTestsOk + 1;
            System.out.println("Funciona corretamente");
        }
        else {
            numeroDeTestsFail = numeroDeTestsFail + 1;
            System.out.println("Error. Se esperaba " + numeroDeTests +" mensaje(s)");
        }

        client1.sendMailItem("client2", "Prueba", "Prueba");
        System.out.println("Enviando un E-mail");
        numeroDeTests = numeroDeTests + 1;
        System.out.println("Examinando los E-mails recibidos en el servidor");
        if (server.howManyMailItems("client2") == numeroDeTests){
            numeroDeTestsOk = numeroDeTestsOk + 1;
            System.out.println("Funciona corretamente");
        }
        else {
            numeroDeTestsFail = numeroDeTestsFail + 1;
            System.out.println("Error. Se esperaba " + numeroDeTests +" mensaje(s)");
        }

        client1.sendMailItem("client2", "Prueba", "Prueba");
        System.out.println("Enviando un E-mail");
        numeroDeTests = numeroDeTests + 1;
        System.out.println("Examinando los E-mails recibidos en el servidor");
        if (server.howManyMailItems("client2") == numeroDeTests){
            numeroDeTestsOk = numeroDeTestsOk + 1;
            System.out.println("Funciona corretamente");
        }
        else {
            numeroDeTestsFail = numeroDeTestsFail + 1;
            System.out.println("Error. Se esperaba " + numeroDeTests +" mensaje(s)");
        }

        client1.sendMailItem("client2", "Prueba", "Prueba");
        System.out.println("Enviando un E-mail");
        numeroDeTests = numeroDeTests + 1;
        System.out.println("Examinando los E-mails recibidos en el servidor");
        if (server.howManyMailItems("client2") == numeroDeTests){
            numeroDeTestsOk = numeroDeTestsOk + 1;
            System.out.println("Funciona corretamente");
        }
        else {
            numeroDeTestsFail = numeroDeTestsFail + 1;
            System.out.println("Error. Se esperaba " + numeroDeTests +" mensaje(s)");
        }

        client1.sendMailItem("client2", "Prueba", "Prueba");
        System.out.println("Enviando un E-mail");
        numeroDeTests = numeroDeTests + 1;
        System.out.println("Examinando los E-mails recibidos en el servidor");
        if (server.howManyMailItems("client2") == numeroDeTests){
            numeroDeTestsOk = numeroDeTestsOk + 1;
            System.out.println("Funciona corretamente");
        }
        else {
            numeroDeTestsFail = numeroDeTestsFail + 1;
            System.out.println("Error. Se esperaba " + numeroDeTests +" mensaje(s)");
        }

        client1.sendMailItem("client2", "Prueba", "Prueba");
        System.out.println("Enviando un E-mail");
        numeroDeTests = numeroDeTests + 1;
        System.out.println("Examinando los E-mails recibidos en el servidor");
        if (server.howManyMailItems("client2") == numeroDeTests){
            numeroDeTestsOk = numeroDeTestsOk + 1;
            System.out.println("Funciona corretamente");
        }
        else {
            numeroDeTestsFail = numeroDeTestsFail + 1;
            System.out.println("Error. Se esperaba " + numeroDeTests +" mensaje(s)");
        }

        client1.sendMailItem("client2", "Prueba", "Prueba");
        System.out.println("Enviando un E-mail");
        numeroDeTests = numeroDeTests + 1;
        System.out.println("Examinando los E-mails recibidos en el servidor");
        if (server.howManyMailItems("client2") == numeroDeTests){
            numeroDeTestsOk = numeroDeTestsOk + 1;
            System.out.println("Funciona corretamente");
        }
        else {
            numeroDeTestsFail = numeroDeTestsFail + 1;
            System.out.println("Error. Se esperaba " + numeroDeTests +" mensaje(s)");
        }

        System.out.println("Tests realizados: " + numeroDeTests);
        System.out.println("Test correctos: " + numeroDeTestsOk);
        System.out.println("Test fallados: " + numeroDeTestsFail);

        return "Tests realizado";
    }

         
    public void funcionalidad03()
    {

        MailServer servidor = new MailServer(); 
        String usuario1 = "fernando1";
        MailClient cliente1 = new MailClient(servidor, usuario1);

        String usuario2 = "fernando2";
        MailClient cliente2 = new MailClient(servidor, usuario2);

        String asunto = "Saludo";
        String mensaje = "Hola";

        System.out.println("Creación de un servidor: " + servidor);
        System.out.println("Creación de un cliente: " + cliente1);
        System.out.println(cliente1 + " debería tener 0 mensajes enviados y recibidos al crearlo");

        
        if(servidor.getNextMailItem(usuario1) == null){
            System.out.println("¡Funciona perfectamente!");
        }
        else{
            System.out.println("¡ERROR!");
        }

        System.out.println("Creación de un cliente: " + cliente2);
        System.out.println(cliente2 + " debería tener 0 mensajes enviados y recibidos al crearlo");

        if(servidor.getNextMailItem(usuario2) == null){
            System.out.println("¡Funciona perfectamente!");
        }
        else{
            System.out.println("¡ERROR!");
        }

        System.out.println(cliente1 + " envía un mensaje a " + cliente2);
        System.out.println(cliente2 + " debería tener 1 mensaje recibido");

        cliente1.sendMailItem(usuario2, asunto, mensaje);

        if(servidor.getNextMailItem(usuario2) == null){
            System.out.println("¡ERROR!");
        }
        else {
            System.out.println("¡Funciona perfectamente, 1 mensaje recibido!");
        }

        String re = "Re: "+ asunto;
        String gracias = "Gracias por tu mensaje ya me ha llegado.\n " + "Tu Mensaje es: " +mensaje;
        System.out.println(cliente2 + " reenvía el mensaje a " + cliente1);
        System.out.println(cliente1 + " debería tener 1 mensaje recibido");

        cliente2.sendMailItem(usuario1, re, gracias);

        if(servidor.getNextMailItem(usuario1) == null){

            System.out.println("¡ERROR!");
        }
        else {
            System.out.println("¡Funciona perfectamente, 1 mensaje recibido!");
            System.out.println( "cliente2 ha reenviado el mensaje: "+ gracias + " -- con el asunto "+ re);
            System.out.println("¡Funciona perfectamente ----  Todo OK!");
        }
    }

    public void funcionalidad04()
    {
        MailServer servidor = new MailServer(); 
        String usuario1 = "nacho1";
        MailClient cliente1 = new MailClient(servidor, usuario1);

        String usuario2 = "nacho2";
        MailClient cliente2 = new MailClient(servidor, usuario2);

        String asunto = "Hola";
        String mensaje = "regalo viagra";

        String asunto2 = "";
        String mensaje2 ="";

        System.out.println("Creación de un servidor: " + servidor);
        System.out.println("Creación de un cliente: " + cliente1);
        System.out.println("Creación de un cliente: " + cliente2);
        System.out.println("Detector de SPAM: "+ "" + mensaje);

        cliente1.sendMailItem(usuario2, asunto, mensaje);

        MailItem item = servidor.getNextMailItem(usuario2);
        if(item.getMessage().contains("regalo") || item.getMessage().contains("viagra")){
            System.out.println("Funciona correctamente");
        }

        else{
            System.out.println("Error");;
        }

        System.out.println("Detector de SPAM:" + "" + mensaje);
        cliente2.sendMailItem(usuario1, asunto, mensaje);
        MailItem item1 = servidor.getNextMailItem(usuario1);
        if((item1.getMessage().contains("regalo") || item1.getMessage().contains("viagra"))){
            System.out.println("Funciona correctamente");
        }
        else{
            System.out.println("Error");
        }

        System.out.println("Envio de mensaje vacio:");
        System.out.println("Descarga de mensaje vacio:");

        cliente1.sendMailItem(usuario2, asunto2, mensaje2);
        MailItem item2 = servidor.getNextMailItem(usuario2);
        if(( mensaje2 == "")){
            System.out.println("Funciona correctamente");
        }
        else{
            System.out.println("Error");
        }

        System.out.println("Envio de mensaje vacio:");
        System.out.println("Descarga de mensaje vacio:");
        cliente1.sendMailItem(usuario1, asunto2, mensaje2);
        MailItem item3 = servidor.getNextMailItem(usuario1);
        if((mensaje2 == "")){
            System.out.println("Funciona correctamente");
        }
        else{
            System.out.println("Error");
        }

        System.out.println("Descarga de mensaje con SPAM:");

        cliente2.sendMailItem(usuario1, asunto, mensaje);
        MailItem item4 = servidor.getNextMailItem(usuario1);
        if((item4.getMessage().contains("regalo") || item4.getMessage().contains("viagra"))){
            item4 = null; 
            System.out.println("Funciona correctamente");
        }
        else{
            System.out.println("Error");
        }

        System.out.println("Descarga de mensaje con SPAM:");

        cliente1.sendMailItem(usuario2, asunto, mensaje);
        MailItem item5 = servidor.getNextMailItem(usuario2);
        if((item5.getMessage().contains("regalo") || item5.getMessage().contains("viagra"))){
            item5 = null; 
            System.out.println("Funciona correctamente");
        }
        else{
            System.out.println("Error");
        }

    }

    /**
     * Comprobación de mensajes enviados y recibidos y 
     * del correo más largo y su número de caracteres.
     */
    public void testFuncionalidad05()
    {
        int numeroDeTests = 0;
        int numeroDeTestsOk = 0;
        int numeroDeTestsFail = 0;

        MailServer servidor1 = new MailServer();

        String usuario1 = "javier@outlook.com";        
        MailClient cliente1 = new MailClient(servidor1, usuario1);

        String usuario2 = "fernando@outlook.com";
        MailClient cliente2 = new MailClient(servidor1, usuario2);

        String usuario3 = "maria@outlook.com";
        MailClient cliente3 = new MailClient(servidor1, usuario3);

        String asunto = "";

        String mensaje1 = "";
        String mensaje2 = "Hola";
        String mensaje3 = "regalo";

        System.out.println("Creación de un servidor: Outlook");
        System.out.println("Creación del primer cliente: " + usuario1);
        System.out.println("Creación del segundo cliente: " + usuario2);
        System.out.println("Creación del tercer cliente: " + usuario3);

        numeroDeTests += 1;
        System.out.println(usuario1 + " envía un mensaje vacío a " + usuario2);
        System.out.println(usuario2 + " debería recibir 1 mensaje y el usuario con el mensaje más largo debería ser " + usuario1);
        cliente1.sendMailItem(usuario2, asunto, mensaje1);
        if(cliente2.getNextMailItem() != null) {
            cliente2.numeroMensajeYCorreoMasLargo();
            System.out.println("¡Funciona perfectamente!");
            numeroDeTestsOk += 1;
        }
        else {
            System.out.println("¡ERROR!");
            numeroDeTestsFail += 1;
        }

        numeroDeTests += 1;
        System.out.println(usuario3 + " envía un mensaje a " + usuario2 + " (contiene: " + mensaje2 + ")");
        cliente3.sendMailItem(usuario2, asunto, mensaje2);
        System.out.println(usuario2 + " debería haber recibido 2 mensajes, el usuario con el nombre más largo tendría que ser " + usuario3);
        if(cliente2.getNextMailItem() != null) {
            cliente2.numeroMensajeYCorreoMasLargo();
            System.out.println("¡Funciona perfectamente!");
            numeroDeTestsOk += 1;
        }
        else {
            System.out.println("¡ERROR!");
            numeroDeTestsFail += 1;
        }

        numeroDeTests += 1;
        System.out.println(usuario2 + " envía un mensaje a " + usuario1 + " (contiene: " + mensaje3 + ")");
        cliente2.sendMailItem(usuario1, asunto, mensaje3);
        System.out.println(usuario1 + " no debería haber recibido ningún mensaje porque es SPAM");
        if(cliente1.getNextMailItem() == null) {
            cliente1.numeroMensajeYCorreoMasLargo();
            System.out.println("¡Funciona perfectamente!");
            numeroDeTestsOk += 1;
        }
        else {
            System.out.println("¡ERROR!");
            numeroDeTestsFail += 1;
        }

        System.out.println("Número de tests: " + numeroDeTests);
        System.out.println("Número de tests acertados: " + numeroDeTestsOk);
        System.out.println("Número de tests fallados: " + numeroDeTestsFail);
    }

    /**
     * printNextMailItem() encrypted test
     */
    public void testFuncionalidad06()
    {
        int numeroDeTests = 0;
        int numeroDeTestsOk = 0;
        int numeroDeTestsFail = 0;

        MailServer server = new MailServer();
        MailClient client1 = new MailClient(server, "Client1");
        MailClient client2 = new MailClient(server, "Client2");
        client1.sendMailItem("Client2","Asunto","aeiou");
        client2.sendEncryptedMailItem("Client1","Asunto","aeiou");
        MailItem item = server.getNextMailItem("Client2");

        numeroDeTests++;
        System.out.println("Enviando un mensaje sin encriptar desde Client1 a Client2...");

        try {
            if (item.getBoolean() == true) {
                System.out.println("El texto esta encriptado correctamente: " + item.getMessage() + " ....Test OK");
                numeroDeTestsOk++;
            }
            else if (item.getBoolean() == false) {
                System.out.println("El texto no encriptado se envia correctamente: " + item.getMessage() + " ....Test OK"); 
                numeroDeTestsOk++;
            }
            else {
                System.out.println("ERROR!");     
                numeroDeTestsFail++;
            }
        }
        catch (Exception e) {         
            System.out.printf("FAIL! (error en tiempo de ejecucion)"); 
        }

        MailItem item2 = server.getNextMailItem("Client1");

        numeroDeTests++;
        System.out.println("Enviando un mensaje encriptado desde Client2 a Client1...");

        try {
            if (item2.getBoolean() == true) {
                System.out.println("El texto esta encriptado correctamente: " + item2.getMessage() + " ....Test OK");
                numeroDeTestsOk++;
            }
            else if (item2.getBoolean() == false) {
                System.out.println("El texto no encriptado se envia correctamente: " + item2.getMessage() + " ....Test OK");  
                numeroDeTestsOk++;
            }
            else {
                System.out.println("ERROR!");
                numeroDeTestsFail++;
            }
        }
        catch (Exception e) {         
            System.out.printf("FAIL! (error en tiempo de ejecucion)"); 
            numeroDeTestsFail++;
        }
        System.out.println("");
        System.out.println("Test realizados: " + numeroDeTests);
        System.out.println("Test correctos: " + numeroDeTestsOk);
        System.out.println("Test fallados: " + numeroDeTestsFail);
    }

}