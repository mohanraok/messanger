package com.facebook.app.messanger.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.app.messanger.model.Message;
import com.facebook.app.messanger.model.RequestModel;
import com.facebook.app.messanger.service.MessageService;

@RestController
@RequestMapping("/messanger/messages")
public class MessageResource {

	@Autowired
	MessageService messageService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Message> getAllMessages(@ModelAttribute RequestModel requestModel) {
		if (requestModel.getStart() >= 0 && requestModel.getSize() > 0) {
			return messageService.getAllMessagesPaginated(requestModel.getStart(), requestModel.getSize());
		}
		return messageService.getAllMessages(requestModel.getYear());
	}

	@GetMapping("{messageId}")
	public ResponseEntity getMessage(@PathVariable long messageId) {
		Message message = messageService.getMessage(messageId);
		return new ResponseEntity(message, HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Message addMessage(@RequestBody Message message) {
		return messageService.addMessage(message);
	}

	@PutMapping("{messageId}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Message updateMessage(@PathVariable long messageId, @RequestBody Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DeleteMapping("{messageId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateMessage(@PathVariable long messageId) {
		messageService.removeMessage(messageId);
	}

}
