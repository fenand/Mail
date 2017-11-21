
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
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
            System.out.println( "cliente2 ha reenviado el mensaje "+ gracias + " con el asunto "+ re);
        }
    }
}
