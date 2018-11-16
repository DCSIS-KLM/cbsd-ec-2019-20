package org.amdatu.tutorial.todo.storage.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.amdatu.tutorial.todo.storage.api.Todo;

@Entity
public class JpaTodo {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String description;
	private boolean completed;
	private String user;
	private long completionTimestamp;

	public JpaTodo() {
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getCompletionTimestamp() {
		return completionTimestamp;
	}

	public void setCompletionTimestamp(long completionTimestamp) {
		this.completionTimestamp = completionTimestamp;
	}
	
	public static JpaTodo fromTodo(Todo todo) {
		JpaTodo jpaTodo = new JpaTodo();
		
		jpaTodo.setUser(todo.getUser());
		jpaTodo.setDescription(todo.getDescription());
		jpaTodo.setCompletionTimestamp(todo.getCompletionTimestamp());
		jpaTodo.setCompleted(todo.isCompleted());
		
		if(todo.get_id() != null) {
			jpaTodo.id = Long.parseLong(todo.get_id());
		}
		
		return jpaTodo;
	}
	
	public Todo asTodo() {
		Todo todo = new Todo();
		todo.set_id(Long.toString(id));
		todo.setCompleted(completed);
		todo.setCompletionTimestamp(completionTimestamp);
		todo.setDescription(description);
		todo.setUser(user);
		
		return todo;
	}
}