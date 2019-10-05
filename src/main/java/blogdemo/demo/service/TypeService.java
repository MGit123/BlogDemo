package blogdemo.demo.service;

import blogdemo.demo.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    Page<Type> ListType(Pageable pageable);

    Type updateType(Type type,Long id);

    void deleteType(Long id);

    List<Type> ListType();
}
