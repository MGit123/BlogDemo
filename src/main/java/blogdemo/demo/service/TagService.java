package blogdemo.demo.service;

import blogdemo.demo.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> ListTag();

    List<Tag> ListTag(String ids);
}
