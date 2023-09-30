package com.automationbytes.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Java","Write programs in Java","Learn Python", "Write Programs in Python");
	}

	@Override
	public void deleteTodo(String todo) {

	}
	// Dynamic Condition
	// Service Definition


}
