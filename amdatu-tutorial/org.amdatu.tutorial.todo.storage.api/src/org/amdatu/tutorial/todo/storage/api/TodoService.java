package org.amdatu.tutorial.todo.storage.api;

import java.util.List;

public interface TodoService {
	void storeTodo(Todo todo);
	List<Todo> list(String user);
}
