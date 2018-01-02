package com.eco.sklad.service;

import com.eco.sklad.DTO.UserDTO;
import com.eco.sklad.domain.Contragent;
import com.eco.sklad.domain.User;
import com.eco.sklad.repository.ContragentRepository;
import com.eco.sklad.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserDao userDao;
    private ContragentRepository contragentRepo;
    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
     //   System.out.println(userDao.findByUserName(username));
     //   System.out.println(username);
        return userDao.findByUserName(username).orElseThrow(()->
            new UsernameNotFoundException("неправильний пароль або user"));
    }

    public List<User> findAll(){ return userDao.findAll(); }

    public User findOne(int id){ return userDao.findOne(id); }

    public void delete(int id){ userDao.delete(id); }

    public boolean existsByPhone(String phone){
        return userDao.existsByPhone(phone);
    }

    public boolean existsByEmail(String email){
        return userDao.existsByEmail(email);
    }

    public void addUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDao.save(user);
    }
    @Transactional
    public void addContragent(User user){
        Contragent contragent = user.getContragent();
        contragent.setBalansName(user.getUsername());
        user.setContragent(contragent);
        System.out.println(user);
        System.out.println(contragent);
        userDao.save(user);
    }

}
