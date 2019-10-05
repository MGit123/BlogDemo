package blogdemo.demo.vo;

/**
 * @author admin
 * @date 2019/10/5 18:29
 */
public class BlogQuery {

    Long typeId;
    String title;
    boolean commentabled;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCommentabled() {
        return  commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        commentabled = commentabled;
    }
}
