
public class Test
{

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void funcionalidad3()
    {
        System.out.println("Se va a crear un server con nombre pollas");
        MailServer server = new MailServer();
        MailClient mailClie1 = new MailClient(server, "1");
        MailClient mailClie2 = new MailClient(server, "2");
    }
}
