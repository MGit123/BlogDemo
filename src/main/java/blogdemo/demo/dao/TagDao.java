package blogdemo.demo.dao;

import blogdemo.demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag,Long> {
}
