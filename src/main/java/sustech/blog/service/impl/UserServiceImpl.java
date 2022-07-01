package sustech.blog.service.impl;

import sustech.blog.entity.User;
import sustech.blog.mapper.UserMapper;
import sustech.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
