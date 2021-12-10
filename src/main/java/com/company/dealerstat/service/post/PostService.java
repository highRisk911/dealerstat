package com.company.dealerstat.service.post;

import com.company.dealerstat.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAllPosts();

    List<Post> findPostsOfDealer(int dealerId);

    Post findPost(int postId);

    void addPost(Post post);

    void removePost(int postId);
}