
public class Test
{

       
        
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
    }

    
    public void funcionalidad3()
    {
        System.out.println("Se va a crear un server con nombre server " + " Y dos usuarios con nombre 1 y 2");
        
        MailServer server = new MailServer();
        
        MailClient mailClie1 = new MailClient(server, "1");
        
        MailClient mailClie2 = new MailClient(server, "2");
        
        
        
        
        
        
    }
}
