package com.company.dealerstat.database.repository.post;

import com.company.dealerstat.entity.Post;

import java.util.List;

public interface PostRepository {

    List<Post> getAllPosts();

    List<Post> getPostsOfDealer(int dealerId);

    Post getPost(int postId);

    void addPost(Post post);

    void deletePost(int postId);
}