package sustech.blog.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import sustech.blog.entity.Blog;
import sustech.blog.service.BlogService;
import sustech.blog.utils.JsonResult;
import sustech.blog.utils.ShiroUtils;

import java.time.LocalDate;
import java.util.Objects;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public JsonResult<IPage> list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created_time"));
        return new JsonResult<>(200, pageData);
    }

    @GetMapping("/blogs/{id}")
        public JsonResult<Blog> detail(@PathVariable(name = "id") Long id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "The blog doesn't exist!");
        return new JsonResult<>(200, blog);
    }

    @RequiresAuthentication
    @PostMapping("/blogs/edit")
    public JsonResult<Blog> edit(@Validated @RequestBody Blog blog) {
        Blog temp;
        if (blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            Assert.notNull(temp, "The blog doesn't exist!");
            Assert.notNull(ShiroUtils.getProfile(), "No permission to edit!");
            Assert.isTrue(Objects.equals(temp.getUserId(), ShiroUtils.getProfile().getId()), "No permission to edit!");
        } else {
            Assert.notNull(ShiroUtils.getProfile(), "Login in please!");
            temp = new Blog();
            temp.setUserId(ShiroUtils.getProfile().getId());
            temp.setCreatedTime(LocalDate.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog, temp, "id", "userId", "createdTime", "status");
        blogService.saveOrUpdate(temp);
        return new JsonResult<>(200, temp);
    }
}

