package com.rest.webservice.webservices.controllers;

import com.rest.webservice.webservices.beans.User;
import com.rest.webservice.webservices.dao.UserDaoService;
import com.rest.webservice.webservices.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;

import java.net.URI;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;



    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
    return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = userDaoService.findUser(id);
        if(user==null)
            throw new UserNotFoundException("id-" + id);
//HATEOAS
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(linkTo.withRel("all-users"));
        return entityModel;
    }


    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User newUser =  userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.delete(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
       // return ResponseEntity.delete(location).build();
    }
}
