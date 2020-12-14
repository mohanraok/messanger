package com.facebook.app.messanger.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.app.messanger.model.Comment;
import com.facebook.app.messanger.service.CommentsService;

@RestController
@RequestMapping("/messanger/messages/{messageId}/comments")
public class CommentResource {

	@Autowired
	CommentsService commentsService;

	@GetMapping
	public List<Comment> getAllComments(@PathVariable long messageId) {
		return commentsService.getAllComments(messageId);
	}

	@GetMapping("/{commentId}")
	public String getComments(@PathVariable long messageId,@PathVariable int commentId) {
		return "test" + commentId;
	}

}
