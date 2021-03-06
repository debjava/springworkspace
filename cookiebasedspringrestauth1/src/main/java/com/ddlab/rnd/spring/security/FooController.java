package com.ddlab.rnd.spring.security;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/foos")
public class FooController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public FooController() {
        super();
    }

    // API

    // read - single

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Foo findById(@PathVariable("id") final Long id, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        return new Foo(randomAlphabetic(6));
    }

    // read - multiple

//    @RequestMapping(method = RequestMethod.GET,produces={"application/json"})
//    @ResponseBody()
//    public List<Foo> findAll() {
//    	System.out.println("-----------------------foo-get-----------------");
//    	System.out.println("---->"+Lists.newArrayList(new Foo(randomAlphabetic(6))));
//        return Lists.newArrayList(new Foo(randomAlphabetic(6)));
//    }
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody()
    public Foo findAll() {
    	System.out.println("-----------------------foo-get-----------------");
    	System.out.println("---->"+Lists.newArrayList(new Foo(randomAlphabetic(6))));
        return new Foo(randomAlphabetic(6));
    }

}
