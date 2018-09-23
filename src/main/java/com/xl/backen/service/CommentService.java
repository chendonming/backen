package com.xl.backen.service;

import com.xl.backen.entity.Comment;

public interface CommentService {
    int add(Comment comment);

    int update(Comment comment);
}
