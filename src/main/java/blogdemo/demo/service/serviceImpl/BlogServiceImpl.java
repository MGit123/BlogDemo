package blogdemo.demo.service.serviceImpl;

import blogdemo.demo.NotFoundException;
import blogdemo.demo.dao.BlogDao;
import blogdemo.demo.entity.Blog;
import blogdemo.demo.entity.Type;
import blogdemo.demo.service.BlogSerivce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2019/9/26 19:44
 */

@Service
public class BlogServiceImpl implements BlogSerivce {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlog(Long id) {
        return blogDao.findBlogById(id);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogDao.save(blog);
    }

    @Override
    public Page<Blog> blogList(Pageable pageable, Blog blog) {
        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates=new ArrayList<>();
                if(!"".equals(blog.getTitle())&&blog.getTitle()!=null){
                    predicates.add(cb.like(root.<String>get("title"),"%"+blog.getTitle()+"%"));
                }
                if(blog.getType().getId()!=null){
                    predicates.add(cb.equal(root.<Type>get("type").get("id"),blog.getType().getId()));
                }
                if(blog.isCommentabled()){
                    predicates.add(cb.equal(root.<Boolean>get("recommend"),blog.isCommentabled()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b=blogDao.findBlogById(id);
        if(b==null){
            throw new NotFoundException("该博客不存在");

        }
        BeanUtils.copyProperties(b,blog);
        return blogDao.save(b);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteById(id);
    }
}
