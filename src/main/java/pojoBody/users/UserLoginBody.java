package pojoBody.users;

import lombok.Builder;
@Builder
public class UserLoginBody {
    private String username;
    private String password;
}
