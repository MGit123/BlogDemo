package blogdemo.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2019/9/24 19:56
 */


@Entity
@Table(name = "t_tag")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue
    private  Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs=new ArrayList<>();

    public Tag(){

    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
