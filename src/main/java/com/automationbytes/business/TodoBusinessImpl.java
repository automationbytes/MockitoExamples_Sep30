package com.automationbytes.business;

import java.util.ArrayList;
import java.util.List;

import com.automationbytes.data.api.TodoService;

//TodoBusinessImpl SUT
//TodoService Dependency
public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		
		for(String todo:todos){
			if(todo.contains("Java")){
				filteredTodos.add(todo);
			}
		}
		
		return filteredTodos;
	}
	

	public void deleteTodosNotRelatedToSpring(String user){
		List<String> todos = todoService.retrieveTodos(user);
		
		for(String todo:todos){
			if(!todo.contains("Java")){
				todoService.deleteTodo(todo);
			}
		}		
	}


}
