package com.ecommerce.Service;

import com.ecommerce.DTO.UserDTO;
import com.ecommerce.Entity.User;

public interface UserService {
    User findUser(UserDTO userDTO);
    UserDTO usermapToUserDTO(User user);
    UserDTO save(UserDTO userDTO);
}
