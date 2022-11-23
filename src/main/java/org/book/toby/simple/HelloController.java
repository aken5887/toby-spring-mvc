package org.book.toby.simple;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.book.toby.temp.HelloSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 핸들러 매핑 : BeanNameUrlHandlerMapping
 * 핸들러 어댑터 : SimpleControllerHandlerAdapter
 * 뷰 리졸버 : IntetnalResourceViewResolver
 */
public class HelloController implements Controller {

  @Autowired private HelloSpring helloSpring;

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    String name = request.getParameter("name");
    String message = this.helloSpring.sayHello(name);

    Map<String, Object> model = new HashMap<>();
    model.put("message", message);

    return new ModelAndView("/WEB-INF/view/hello.jsp", model);
  }
}
