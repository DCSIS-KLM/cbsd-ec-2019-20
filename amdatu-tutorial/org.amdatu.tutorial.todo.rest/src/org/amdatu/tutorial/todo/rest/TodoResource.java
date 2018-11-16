package org.amdatu.tutorial.todo.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.amdatu.tutorial.todo.storage.api.Todo;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.osgi.framework.ServiceReference;

@Path("todo")
@Component(provides=Object.class)
public class TodoResource {
	
	private final Map<ServiceReference<TodoService>, TodoService> m_todoServices = new ConcurrentHashMap<>();
	
	@ServiceDependency(required=false, removed="removeTodoService")
	public void addTodoService(ServiceReference<TodoService> sr, TodoService todoService) {
		m_todoServices.put(sr, todoService);
	}
	
	public void removeTodoService(ServiceReference<TodoService> sr) {
		m_todoServices.remove(sr);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{user}")
	public List<Todo> list(@PathParam("user") String user) {
        System.out.println("test!");

		List<Todo> todos = m_todoServices.values().stream()
				.flatMap(t -> t.list(user).stream())
				.collect(Collectors.toList());
		return todos;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTodo(Todo todo) {
		
		Optional<ServiceReference<TodoService>> persistent = m_todoServices.keySet().stream()
				.filter(sr -> sr.getProperty("persistent") != null)
				.findAny();
		
		if(persistent.isPresent()) {
			TodoService todoService = m_todoServices.get(persistent.get());
			todoService.storeTodo(todo);
			
			return Response.ok().build();
		} else {
			return Response.status(503).build();
		}
	}
}
