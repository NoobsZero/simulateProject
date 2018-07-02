package demo.spring.service;

import com.magicube.framework.common.SpringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author justincai
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:applicationContext-cxf.xml"
})
public class HelloWorldTest {

    public HelloWorldTest() {
    }

    /**
     * Test of sayHi method, of class HelloWorld.
     */
    @Test
    public void testSayHi() {
        System.out.println("sayHi");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-cxf.xml");
        HelloWorld client = (HelloWorld) SpringUtil.getBean("helloClient", ctx);
        String result = client.sayHi("justin cai");
        System.out.println(result);
    }
    
    /**
     * Test of sayHi method, of class HelloWorld.
     */
    @Test
    public void testSayHi1() {
        System.out.println("sayHi1");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-cxf_1.xml");
        HelloWorld client = (HelloWorld) SpringUtil.getBean("client", ctx);
        String result = client.sayHi("justin cai");
        System.out.println(result);
    }

    public class HelloWorldImpl implements HelloWorld {

        @Override
        public String sayHi(String text) {
            return "";
        }
    }

}
