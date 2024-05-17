package com.example.ServerL.Tables.USER;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

  public  void  createUser(User user){
        userRepository.save(user);
    }
    public void updateUser(int id , User user){
        User find=userRepository.findById(id).orElseThrow(()->new IllegalStateException(String.format("User with id= %s doesn't exist", id)));

        find.setUsername(user.getUsername());
        find.setName(user.getName());
        find.setEmail(user.getEmail());
        find.setPassword(user.getPassword());
        userRepository.save(find);

    }
    public void deleteUser(int id){
        boolean userExist=userRepository.existsById(id);
        if(!userExist){
            throw new IllegalStateException(String.format("User wit id= %s doesn't exist",id));
        }
        userRepository.deleteById(id);
    }
    public User findByUsernameAndPassword(String username, String password) {
        List<User> users=userRepository.findAll();
        for (User user : users) {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

}
