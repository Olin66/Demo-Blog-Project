package sustech.blog.service.impl;

import sustech.blog.entity.Blog;
import sustech.blog.mapper.BlogMapper;
import sustech.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
