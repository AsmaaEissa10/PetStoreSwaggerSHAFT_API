package pojoBody.users;

import lombok.Builder;

@Builder
public class UserRegisterBody {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int status;

}
