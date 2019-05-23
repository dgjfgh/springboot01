package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.User;
import com.demo.common.BaseController;
import com.demo.dao.UserDao;

@RestController
public class UserController extends BaseController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        try {
            System.out.println(request.getParameter("name"));
        }catch (Exception e){
            e.printStackTrace();
        }
        List<User> users = userDao.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = userDao.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userDao.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        int update = userDao.update(user);
        System.out.println(update);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userDao.delete(id);
    }


}