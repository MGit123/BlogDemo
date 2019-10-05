package blogdemo.demo.service.serviceImpl;

import antlr.StringUtils;
import blogdemo.demo.dao.TagDao;
import blogdemo.demo.entity.Tag;
import blogdemo.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author admin
 * @date 2019/9/26 19:45
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> ListTag() {
        return tagDao.findAll();
    }

    @Override
    public List<Tag> ListTag(String ids) {
        return tagDao.findAllById(convetToList(ids));
    }

    private List<Long> convetToList(String tagIds){
        List<Long> list=new ArrayList<>();

        if("".equals(tagIds)&&tagIds!=null){
             String[] array=tagIds.split(",");
             for (int i=0;i<array.length;i++){
                 list.add(Long.valueOf(array[i]));
             }
        }
        return list;
    }
}
