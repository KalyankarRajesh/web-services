package com.rest.webservice.webservices.dao;


import com.rest.webservice.webservices.beans.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;
    static{
        users.add(new User(1,"A",new Date()));
        users.add(new User(2,"B",new Date()));
        users.add(new User(3,"C",new Date()));
    }


    public User delete(int id){
        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            User user = (User) iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }

        }
        return null;
    }
    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()==null)
            user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findUser(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
}
