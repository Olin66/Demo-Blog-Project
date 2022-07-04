package sustech.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sustech.blog.entity.Blog;
import sustech.blog.service.BlogService;

@SpringBootTest
class BlogProjectApplicationTests {

    @Autowired
    BlogService blogService;
    @Test
    void blogTest(){
        Blog blog = blogService.getById(1);
        System.out.println(blog);
    }

}
