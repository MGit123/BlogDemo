package blogdemo.demo.dao;

import blogdemo.demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagDao extends JpaRepository<Tag,Long> {

    List<Tag> findAllById(List<Long> tagIds);
}
