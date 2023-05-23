package com.ecommerce.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String secretQuestion;
    private String secretAnswer;

}
