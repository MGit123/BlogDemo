package blogdemo.demo.service.serviceImpl;

import blogdemo.demo.NotFoundException;
import blogdemo.demo.dao.TypeDao;
import blogdemo.demo.entity.Type;
import blogdemo.demo.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @date 2019/9/26 19:45
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeDao.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {

        return typeDao.findTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.findTypeByName(name);
    }

    @Transactional
    @Override
    public Page<Type> ListType(Pageable pageable) {

        return typeDao.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Type type,Long id) {

        Type t=typeDao.findTypeById(id);

        if(t==null){
            throw new NotFoundException("不存在该类型");
        }

        //把type的值覆盖t中
        BeanUtils.copyProperties(type,t);
        return typeDao.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {

          typeDao.deleteById(id);
    }

    @Override
    public List<Type> ListType() {
        return typeDao.findAll();
    }
}
