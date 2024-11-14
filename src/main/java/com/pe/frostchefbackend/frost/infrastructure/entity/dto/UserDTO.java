package com.pe.frostchefbackend.frost.infrastructure.entity.dto;

import com.pe.frostchefbackend.frost.infrastructure.entity.sign_in.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private byte[] photo;


    public static UserDTO fromUser(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setPhoto(user.getPhoto());

        return dto;
    }
}