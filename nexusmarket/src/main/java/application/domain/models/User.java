package application.domain.models;

import application.domain.valueobjects.UserRole;
import application.domain.valueobjects.UserStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private String id;
    private String fullName;
    private String email;
    private UserRole role;
    private UserStatus status;
}