package pl.hospital.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    Long id;

    String firstName;
    String lastName;
    String login;
    String password;

}
