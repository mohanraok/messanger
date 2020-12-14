package com.facebook.app.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.facebook.app.messanger.database.DatabaseClass;
import com.facebook.app.messanger.model.Comment;
import com.facebook.app.messanger.model.Message;

@Service
public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		Message m1 = new Message(1, "Hello Koushik!!", "Koushik");
		Map<Long, Comment> comments = new HashMap<>();
		comments.put(1L, new Comment(1, "superb", "mohan"));
		comments.put(2L, new Comment(2, "Terrific", "mohan"));
		m1.setComments(comments);
		
		messages.put(1L, m1);
		messages.put(2L, new Message(2, "Hello Mohan!!", "Mohan"));
	}

	public List<Message> getAllMessages(Integer year) {
		if (year != null && year > 0) {
			return getAllMessagesForYear(year);
		}
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();

		for (Message message : messages.values()) {
			calendar.setTime(message.getCreated());
			if (year == calendar.get(Calendar.YEAR)) {
				messagesForYear.add(message);
			}

		}
		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {

		List<Message> message = new ArrayList<Message>(messages.values());

		if (start + size > message.size())
			return new ArrayList<Message>();

		return message.subList(start, start + size);

	}

	public Message addMessage(Message message) {
		message.setId(messages.values().stream().mapToLong(m -> m.getId()).max().getAsLong() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public void removeMessage(long id) {
		messages.remove(id);
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

}
