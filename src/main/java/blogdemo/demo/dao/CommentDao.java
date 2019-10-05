package blogdemo.demo.dao;

import blogdemo.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long> {
}
