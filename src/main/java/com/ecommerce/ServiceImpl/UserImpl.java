package com.ecommerce.ServiceImpl;

import com.ecommerce.DTO.UserDTO;
import com.ecommerce.Entity.User;
import com.ecommerce.Repository.UserRepository;
import com.ecommerce.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDTO usermapToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        //collect from db
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = new User(userDTO);
        User newUser = userRepository.save(user);
        return usermapToUserDTO(newUser);
    }

    public UserDTO registeredUser(UserDTO userDTO) {
        Optional<User> register = userRepository.findUserByEmail(userDTO.getEmail());
        if (userDTO.getUsername() == null || userDTO.getPassword() == null) {
            throw new RuntimeException("you musty fill username and password");
        }
        if (register.isPresent()) {
            throw new RuntimeException("user already exist");
        }
        User user = new User();
        userRepository.save(user);

        return usermapToUserDTO(user);
    }

    @Override
    public User findUser(UserDTO userDTO) {
        try{
            return userRepository.findUserByEmail(userDTO.getEmail()).get();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
