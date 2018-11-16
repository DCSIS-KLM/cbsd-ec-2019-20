package org.amdatu.tutorial.todo.storage.jpa;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.amdatu.jta.ManagedTransactional;
import org.amdatu.jta.Transactional;
import org.amdatu.tutorial.todo.storage.api.Todo;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;
import org.apache.felix.dm.annotation.api.ServiceDependency;

@Component(provides=ManagedTransactional.class, properties=@Property(name="persistent", value="true"))
@Transactional
public class JpaTodoService implements TodoService, ManagedTransactional{
	

	@Override
	public Class<?>[] getManagedInterfaces() {
		return new Class[] { TodoService.class };
	}

	@ServiceDependency
	private volatile EntityManager m_entityManager;
	
	@Override
	public void storeTodo(Todo todo) {
		m_entityManager.persist(JpaTodo.fromTodo(todo));
	}

	@Override
	public List<Todo> list(String user) {
		
		TypedQuery<JpaTodo> query = 
				m_entityManager.createQuery("select t FROM JpaTodo t WHERE t.user = :user", JpaTodo.class);
		query.setParameter("user", user);
		
		return query.getResultList().stream()
				.map(JpaTodo::asTodo)
				.collect(Collectors.toList());
	}
}
