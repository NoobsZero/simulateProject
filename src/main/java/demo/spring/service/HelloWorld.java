package demo.spring.service;

import javax.jws.WebService;

/**
 *
 * @author justincai
 */
@WebService
public interface HelloWorld {

    String sayHi(String text);
}
