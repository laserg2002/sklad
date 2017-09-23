package com.eco.sklad.service;

import com.eco.sklad.domain.User;
import com.eco.sklad.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        System.out.println(userDao.findByUserName(username));
        System.out.println(username);
        return userDao.findByUserName(username).orElseThrow(()->
            new UsernameNotFoundException("неправильний пароль або user"));
    }

    public boolean existsByPhone(String phone){
        return userDao.existsByPhone(phone);
    }

    public boolean existsByEmail(String email){
        return userDao.existsByEmail(email);
    }

    public void addUser(User user){
        userDao.save(user);
    }



}
