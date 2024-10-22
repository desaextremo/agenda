package com.desaextremo.agenda.agenda.repository;

import com.desaextremo.agenda.agenda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
    public List<User> findAllByGender(String gender);

    public List<User> findByNameStartingWith(String letter);
}
