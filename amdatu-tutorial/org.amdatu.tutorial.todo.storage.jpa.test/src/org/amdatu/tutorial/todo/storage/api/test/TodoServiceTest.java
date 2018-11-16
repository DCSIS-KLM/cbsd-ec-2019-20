package org.amdatu.tutorial.todo.storage.api.test;

import static org.amdatu.testing.configurator.TestConfigurator.cleanUp;
import static org.amdatu.testing.configurator.TestConfigurator.configure;
import static org.amdatu.testing.configurator.TestConfigurator.createFactoryConfiguration;
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
		configure(this)
				.add(createServiceDependency().setService(TodoService.class).setRequired(true))
				.add(createFactoryConfiguration("org.amdatu.jpa.datasourcefactory")
						.set("managed", "true")
						.set("name", "todoDS")
						.set("jdbcUrl", "jdbc:h2:mem:demo")
						.set("driverClassName", "org.h2.Driver")
						.set("password", "sa")
						.set("userName", "sa")).apply();
	}
	
	@Test
	public void testSaveAndList() {
		Todo todo = new Todo("test todo", "amdatu");
		
		serviceToTest.storeTodo(todo);
		
		List<Todo> list = serviceToTest.list("amdatu");
		assertEquals(1, list.size());
	}		
	
	@After
	public void after() {
		cleanUp(this);
	}
}