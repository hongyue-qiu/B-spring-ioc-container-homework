package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

@RestController
@Scope(SCOPE_SINGLETON)
public class GreetingController {

    @Autowired
    private ObjectFactory<GreetingService> greetingServiceObjectFactory;

    @GetMapping("/greet")
    public String greet() {
        return greetingServiceObjectFactory.getObject().sayHi();
    }

}
