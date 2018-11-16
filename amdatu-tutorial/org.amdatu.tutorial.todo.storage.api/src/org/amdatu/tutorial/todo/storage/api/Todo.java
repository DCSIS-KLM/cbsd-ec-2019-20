package org.amdatu.tutorial.todo.storage.api;

import javax.persistence.Id;

public class Todo {
	@Id
	private String _id;
	private String description;
	private boolean completed;
	private String user;
	private long completionTimestamp;

	public Todo() {
	}
	
	public Todo(String description, String user) {
		this.description = description;
		this.user = user;
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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
}
