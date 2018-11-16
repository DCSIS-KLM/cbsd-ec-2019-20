package org.amdatu.tutorial.todo.storage.api.test;

import static org.amdatu.testing.configurator.TestConfigurator.cleanUp;
import static org.amdatu.testing.configurator.TestConfigurator.configure;
import static org.amdatu.testing.configurator.TestConfigurator.createServiceDependency;
import static org.amdatu.testing.mongo.OSGiMongoTestConfigurator.configureMongoDb;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.amdatu.mongo.MongoDBService;
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
				.add(createServiceDependency().setService(TodoService.class)
						.setRequired(true)).add(configureMongoDb())
				.add(createServiceDependency().setService(MongoDBService.class)).apply();
	}
	
	@Test
	public void storeAndList() {
		serviceToTest.storeTodo(new Todo("test todo", "amdatu"));
		
		List<Todo> list = serviceToTest.list("amdatu");
		assertEquals(1, list.size());
	}		
	
	@After
	public void after() {
		cleanUp(this);
	}
}