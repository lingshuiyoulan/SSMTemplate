import com.cj.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lanling on 2016/12/14.
 */
public class App {
    @Test
    public void test(){
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring/application-*.xml");
        DeptService deptService = (DeptService) act.getBean("deptServiceImpl");
        System.out.println(deptService.findAllDepts());
    }
}
