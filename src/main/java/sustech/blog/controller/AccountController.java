package sustech.blog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sustech.blog.dto.LoginDTO;
import sustech.blog.entity.User;
import sustech.blog.ex.IncorrectPasswordException;
import sustech.blog.service.UserService;
import sustech.blog.utils.JsonResult;
import sustech.blog.utils.JwtUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class AccountController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public JsonResult<Object> login(@Validated @RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDTO.getUsername()));
        Assert.notNull(user, "The user doesn't exist!");
        if (!Objects.equals(user.getPwd(), SecureUtil.md5(loginDTO.getPwd()))) {
            throw new IncorrectPasswordException("The password is incorrect!");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        return new JsonResult<>(200, MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map());
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }
}
