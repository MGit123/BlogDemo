package blogdemo.demo.dao;

import blogdemo.demo.entity.Blog;
import blogdemo.demo.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDao extends JpaRepository<Type,Long> {

     public Type findTypeById(Long id);

     public Type findTypeByName(String name);

}
