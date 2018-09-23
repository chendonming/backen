package com.xl.backen.model;

import com.xl.backen.entity.Comment;
import com.xl.backen.entity.Posts;

import java.util.Date;
import java.util.List;

/**
 * 帖子详情model
 */
public class PostModel extends Posts {

    private static final long serialVersionUID = -3045682964966970736L;

    private List<CommentModel> commentList;

    public List<CommentModel> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentModel> commentList) {
        this.commentList = commentList;
    }
}
