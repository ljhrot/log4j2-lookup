import org.junit.Test;

import javax.naming.InitialContext;

/**
 * date 2021/12/12 15:27
 *
 * @author hjl
 */
public class RMITest {

    @Test
    public void test() throws Exception {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        String url = "rmi://127.0.0.1:1099/task";
        InitialContext initialContext = new InitialContext();
        initialContext.lookup(url);
    }
}
