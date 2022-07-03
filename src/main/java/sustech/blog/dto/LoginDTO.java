package sustech.blog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {
    @NotBlank(message = "The username can not be left empty!")
    private String username;
    @NotBlank(message = "The password can not be left empty!")
    private String pwd;
}
