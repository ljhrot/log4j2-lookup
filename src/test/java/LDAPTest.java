import org.junit.Test;

import javax.naming.InitialContext;

/**
 * date 2021/12/12 18:03
 *
 * @author hjl
 */
public class LDAPTest {

    @Test
    public void test() throws Exception {
        String url = "ldap://127.0.0.1:7777/task";
        InitialContext initialContext = new InitialContext();
        initialContext.lookup(url);
    }
}
