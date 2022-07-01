package sustech.blog.service.impl;

import sustech.blog.entity.Blog;
import sustech.blog.mapper.BlogMapper;
import sustech.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Olin66
 * @since 2022-07-01
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
