package org.amdatu.tutorial.todo.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.amdatu.tutorial.todo.storage.api.Todo;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.ServiceReference;

@RunWith(MockitoJUnitRunner.class)
public class TodoResourceTest {

	@InjectMocks 
	@Spy
	private TodoResource resource = new TodoResource();
	
	@Mock 
	private TodoService todoService; 
	
	@Before
	public void setup() {

	}
	
	@Test
	public void test() {
		List<Todo> todoItems = Arrays.asList(new Todo("a", "amdatu"), new Todo("b", "amdatu"));
		when(todoService.list("amdatu")).thenReturn(todoItems);
		
		resource.addTodoService(Mockito.mock(ServiceReference.class), todoService);
		
		List<Todo> list = resource.list("amdatu");		
		assertEquals(todoItems, list);		
	}

}
