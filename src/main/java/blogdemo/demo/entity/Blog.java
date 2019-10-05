package blogdemo.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @date 2019/9/24 19:45
 */

@Entity
@Table(name = "t_blog")
@Getter
@Setter
public class Blog {

    @Id
    @GeneratedValue
    private  Long id;

    private String title; //标题
    private String content; //内容
    private String firstPicture;  //首图
    private String tag;           //标签
    private Integer viewCount;    //浏览数
    private boolean appreciation;  //是否打赏
    private boolean shareStatement; //分享
    private boolean commentabled;  //评论
    private boolean published;    //是否发布
    private boolean recommend;   //推荐

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags=new ArrayList<>();

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments=new ArrayList<>();

    @Transient
    private String tagIds;

    public Blog(){

    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", tag='" + tag + '\'' +
                ", viewCount=" + viewCount +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", user=" + user +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }

}
