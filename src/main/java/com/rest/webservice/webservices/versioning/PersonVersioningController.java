package com.rest.webservice.webservices.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1()
    {
        return new PersonV1("Rajesh Kalyankar");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Rajesh","Kalyankar"));
    }


    @GetMapping(value = "/person/param", params = "Version=1")
    public PersonV1 personparamV1()
    {
        return new PersonV1("Rajesh Kalyankar");
    }

    @GetMapping(value = "/person/param", params = "Version=2")
    public PersonV2 personparamV2(){
        return new PersonV2(new Name("Rajesh","Kalyankar"));
    }
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personHeaderV1()
    {
        return new PersonV1("Rajesh Kalyankar");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personHeaderV2(){
        return new PersonV2(new Name("Rajesh","Kalyankar"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 personProducesV1()
    {
        return new PersonV1("Rajesh Kalyankar");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 personProducesV2(){
        return new PersonV2(new Name("Rajesh","Kalyankar"));
    }
}
