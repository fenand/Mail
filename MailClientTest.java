

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailClientTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailClientTest
{
    /**
     * Default constructor for test class MailClientTest
     */
    public MailClientTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void funcionalidad3()
    {
        MailServer server = new MailServer();
        MailClient mailClie1 = new MailClient(server, "1");
        MailClient mailClie2 = new MailClient(server, "2");
    }
}

