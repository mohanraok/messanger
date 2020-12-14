package com.facebook.app.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.facebook.app.messanger.database.DatabaseClass;
import com.facebook.app.messanger.model.Comment;
import com.facebook.app.messanger.model.Message;

@Service
public class CommentsService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Comment> getAllComments(long messageId) {

		Map<Long, Comment> comments = messages.get(messageId).getComments();

		return new ArrayList<>(comments.values());

	}

	public Comment getComment(long messageId, long commentId) {

		Comment comment = messages.get(messageId).getComments().get(commentId);

		return comment;

	}

}
