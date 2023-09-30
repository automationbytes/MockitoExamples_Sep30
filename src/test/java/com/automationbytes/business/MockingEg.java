package com.automationbytes.business;

import com.automationbytes.data.api.TodoService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockingEg {

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;


    @Test
    public void ExampleusingMock(){

        List<String> todos = Arrays.asList("Learn Java","Write Java", "Learn Python", "Write Python");
        when(todoServiceMock.retrieveTodos("ABC")).thenReturn(todos);

        List<String> filteredtodos = todoBusinessImpl.retrieveTodosRelatedToSpring("ABC");
        System.out.println(filteredtodos);

    }

    @Test
    public void ExampleusingMockusingGiven(){
        List<String> todos = Arrays.asList("Learn Java","Write Java", "Learn Python", "Write Python");
        given(todoServiceMock.retrieveTodos("ABC")).willReturn(todos);

        //when
        List<String> filteredtodos = todoBusinessImpl.retrieveTodosRelatedToSpring("ABC");
        //then
        Assert.assertEquals(filteredtodos.size(),2);
        System.out.println(filteredtodos);

    }


    @Test
    public void ExampleforDelete(){
        List<String> todos = Arrays.asList("Learn Java","Write Java", "Learn Python", "Write Python");
        given(todoServiceMock.retrieveTodos("ABC")).willReturn(todos);

       todoBusinessImpl.deleteTodosNotRelatedToSpring("ABC");
       then(todoServiceMock).should().deleteTodo("Learn Python");
    }


    @Test
    public void ExampletouseCapture(){
        List<String> todos = Arrays.asList("Learn Java","Write Java", "Learn Python");
        given(todoServiceMock.retrieveTodos("ABC")).willReturn(todos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("ABC");
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue(),is("Learn Python"));
    }




    @Test
    public void multivaluecapture(){
        List<String> todos = Arrays.asList("Learn Java","Write Java", "Learn Python","Write Python");
        given(todoServiceMock.retrieveTodos("ABC")).willReturn(todos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("ABC");
//        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
//
//        assertThat(stringArgumentCaptor.getValue(),is("Learn Python"));

        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
//        assertThat(stringArgumentCaptor.getAllValues());
        System.out.println("Values deleted:" +stringArgumentCaptor.getAllValues());


    }
}
