package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;

    private List<Comment> commentList = new ArrayList<>();

    public Post(LocalDateTime moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void addComment (Comment comment) {
        commentList.add(comment);
    }

    public void removeComment (Comment comment) {
        commentList.add(comment);
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getLikes() {
        return likes;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(title + "\n");
        stringBuilder.append(likes + " Likes - ");
        stringBuilder.append(fmt.format(moment) + "\n");
        stringBuilder.append(content + "\n");
        stringBuilder.append("Comments: \n");
        for (Comment c : commentList) {
            stringBuilder.append(c.getText() + "\n");
        }
        return stringBuilder.toString();
    }
}
