package org.amdatu.tutorial.todo.storage.api.test;

import static org.amdatu.testing.configurator.TestConfigurator.cleanUp;
import static org.amdatu.testing.configurator.TestConfigurator.configure;
import static org.amdatu.testing.configurator.TestConfigurator.createServiceDependency;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.amdatu.tutorial.todo.storage.api.Todo;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TodoServiceTest {
		
	private volatile TodoService serviceToTest;

	@Before
	public void setup() {
		configure(this).add(createServiceDependency().setService(TodoService.class).setRequired(true))
				.apply();
	}
	
	@Test
	public void test() {
		serviceToTest.storeTodo(new Todo("Test todo 1", "amdatu"));
		serviceToTest.storeTodo(new Todo("Test todo 2", "amdatu"));
		serviceToTest.storeTodo(new Todo("Test todo 3", "other"));
		
		List<Todo> list = serviceToTest.list("amdatu");
		assertEquals(2, list.size());
	}		
	
	@After
	public void after() {
		cleanUp(this);
	}
}