package com.automationbytes.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.automationbytes.data.api.TodoService;
import com.automationbytes.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

		List<String> list = todoBusiness.retrieveTodosRelatedToSpring("ABC");
		System.out.println(list);
	}

}
