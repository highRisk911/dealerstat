package com.company.dealerstat.service.post;

import com.company.dealerstat.database.repository.post.PostRepository;
import com.company.dealerstat.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public List<Post> findAllPosts() {
        return postRepository.getAllPosts();
    }

    @Override
    public List<Post> findPostsOfDealer(int dealerId) {
        return postRepository.getPostsOfDealer(dealerId);
    }

    @Override
    public Post findPost(int postId) {
        return postRepository.getPost(postId);
    }

    @Override
    public void addPost(Post post) {
        postRepository.addPost(post);
    }

    @Override
    public void removePost(int postId) {
        postRepository.deletePost(postId);
    }
}