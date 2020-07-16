package com.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserServiceInterface userService;
    
    @GetMapping
    public Iterable<User> findAll() {
        return this.userService.findAll();
    }
    
    @PostMapping
    public User save(@RequestBody User user) {
        return this.userService.save(user);
    }
    
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return this.userService.findById(id).get();
    }
    
    @GetMapping("/findByAccelerationName/{nome}")
    public List<User> findByAccelerationName(@PathVariable("nome") String nomeDaAceleracao) {
        return this.userService.findByAccelerationName(nomeDaAceleracao);
    }

}
