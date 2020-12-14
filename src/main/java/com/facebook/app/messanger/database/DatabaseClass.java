package com.facebook.app.messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.facebook.app.messanger.model.Comment;
import com.facebook.app.messanger.model.Message;
import com.facebook.app.messanger.model.Profile;

public class DatabaseClass {

	public static Map<Long, Message> messages = new HashMap<>();
	public static Map<String, Profile> profiles = new HashMap<>();
	public static Map<Long, Comment> comments = new HashMap<>();


	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	public static Map<Long, Comment> getComments() {
		return comments;
	}


}
