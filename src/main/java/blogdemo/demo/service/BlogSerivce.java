package blogdemo.demo.service;

import blogdemo.demo.entity.Blog;
import blogdemo.demo.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogSerivce {

    Blog getBlog(Long id);

    Blog saveBlog(Blog blog);

    Page<Blog> blogList(Pageable pageable, BlogQuery blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
