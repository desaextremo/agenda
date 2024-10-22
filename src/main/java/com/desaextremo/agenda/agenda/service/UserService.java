package com.desaextremo.agenda.agenda.service;

import com.desaextremo.agenda.agenda.model.User;
import com.desaextremo.agenda.agenda.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositoryImpl repositorio;

    public List<User> getAll(){
        return repositorio.getAll();
    }

    public Optional<User> getUser(int carId) {
        return repositorio.getUser(carId);
    }

    public User save(User user){
        if(user.getId()==null){
            return repositorio.save(user);
        }else{
            Optional<User> e=repositorio.getUser(user.getId());
            if(e.isEmpty()){
                return repositorio.save(user);
            }else{
                return user;
            }
        }
    }

    public User update(User user){
        if(user.getId()!=null){
            Optional<User> e=repositorio.getUser(user.getId());
            if(!e.isEmpty()){
                if(user.getName()!=null){
                    e.get().setName(user.getName());
                }
                if(user.getIdentification()!=null){
                    e.get().setIdentification(user.getIdentification());
                }
                if(user.getAddress()!=null){
                    e.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    e.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    e.get().setEmail(user.getEmail());
                }
                if(user.getGender()!=null){
                    e.get().setGender(user.getGender());
                }
                repositorio.save(e.get());
                return e.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }


    public boolean deleteUser(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<User> findAllByGender(String gender){
        return repositorio.findAllByGender(gender);
    }

    public List<User> findByNameStartsWith(String letter){
        return repositorio.findByNameStartsWith(letter);
    }
}
