
import org.junit.Ignore;
import org.junit.Test;
import util.HibernateUtil;

public class HibernateUtilTest {

    @Ignore
    @Test
    public void conectar() {
        HibernateUtil.getFabricaDeSessoes().openSession();
        HibernateUtil.getFabricaDeSessoes().close();
    }
}
