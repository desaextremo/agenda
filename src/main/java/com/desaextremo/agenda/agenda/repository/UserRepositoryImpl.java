package com.desaextremo.agenda.agenda.repository;

import com.desaextremo.agenda.agenda.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl {
    @Autowired
    private IUserRepository repositorio;

    public List<User> getAll(){
        return (List<User>) repositorio.findAll();
    }

    public Optional<User> getUser(int id){
        return repositorio.findById(id);
    }

    public User save(User user){
        return repositorio.save(user);
    }
    public void delete(User user){
        repositorio.delete(user);
    }

    public List<User> findAllByGender(String gender){
        return repositorio.findAllByGender(gender);
    }

    public List<User> findByNameStartsWith(String letter){
        return repositorio.findByNameStartingWith(letter);
    }
}
