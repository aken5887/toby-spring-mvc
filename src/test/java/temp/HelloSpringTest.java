package temp;

import org.book.toby.temp.HelloSpring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class HelloSpringTest {

  @Autowired
  ApplicationContext ac;

  @Test
  public void root_컨텍스트_테스트(){
    HelloSpring hs = ac.getBean("helloSpring", HelloSpring.class);
    Assertions.assertEquals(hs.sayHello("root context"), "hello, root context");
  }
}