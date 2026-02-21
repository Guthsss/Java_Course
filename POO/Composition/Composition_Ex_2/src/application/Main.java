package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        Comment comment1 = new Comment("Have a nice trip!");
        Comment comment2 = new Comment("Wow that's awesome!");

        Post post1 = new Post(LocalDateTime.parse("13/05/2312 13:54:32", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);
        post1.addComment(comment1);
        post1.addComment(comment2);

        System.out.println(post1);


    }
}
