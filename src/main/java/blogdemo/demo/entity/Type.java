package blogdemo.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2019/9/24 19:56
 */


@Entity
@Table(name = "t_type")
@Getter
@Setter
public class Type {

    @Id
    @GeneratedValue
    private  Long id;

    @NotBlank(message="分类名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs=new ArrayList<>();

    public Type(){

    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }


}
