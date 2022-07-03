package sustech.blog.controller;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import sustech.blog.entity.User;
import sustech.blog.service.UserService;
import sustech.blog.utils.JsonResult;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/save")
    public JsonResult<User> save(@Validated @RequestBody User user) {
        return new JsonResult<>(200, user);
    }
}

