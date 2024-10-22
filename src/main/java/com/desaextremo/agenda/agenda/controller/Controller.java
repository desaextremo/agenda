package com.desaextremo.agenda.agenda.controller;

import com.desaextremo.agenda.agenda.model.User;
import com.desaextremo.agenda.agenda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private UserService negocio;

    @GetMapping("/getContacts")
    public List<User> getAll(){ return negocio.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return negocio.save(user);
    }


    @GetMapping("/getContactsByGender/{gender}")
    public List<User> findAllByGender(@PathVariable("gender") String gender){
        return negocio.findAllByGender(gender);
    }

    @GetMapping("/getContactsByInitLetter/{letter}")
    public List<User> findByNameStartsWith(@PathVariable("letter") String letter){
        return negocio.findByNameStartsWith(letter);
    }

}
