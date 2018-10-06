package com.xl.backen.model;

import com.xl.backen.entity.CirclePostComment;
import com.xl.backen.entity.Posts;

import java.util.List;

/**
 * 帖子详情model
 */
public class PostModel extends Posts {

    private static final long serialVersionUID = -3045682964966970736L;

    private List<CirclePostComment> commentList;

    public List<CirclePostComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CirclePostComment> commentList) {
        this.commentList = commentList;
    }
}
