package com.company.dealerstat.service.comment;

import com.company.dealerstat.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findCommentsFromPost(int postId);

    List<Comment> findUnapprovedComments();

    void addComment(Comment comment);

    void removeComment(int commentId);

    void editComment(Comment comment);

    void approveComment(int commentId);
}