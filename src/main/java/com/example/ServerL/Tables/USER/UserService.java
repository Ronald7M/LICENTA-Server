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

  public  int  createUser(User user){
        List<User> users =getUsers();
      for (int i = 0; i < users.size(); i++) {
          if(users.get(i).getEmail().equals(user.getEmail())){
              return 1;
          }
          if(users.get(i).getUsername().equals(user.getUsername())){
              return 2;
          }

      }
      userRepository.save(user);
      return 0;
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
