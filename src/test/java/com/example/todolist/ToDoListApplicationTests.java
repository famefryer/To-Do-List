package com.example.todolist;

import com.example.todolist.todo.ToDoItem;
import com.example.todolist.todo.ToDoRepository;
import com.example.todolist.todo.ToDoService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ToDoListApplicationTests {

	@Autowired
	private ToDoService toDoService;

	@Autowired
	private ToDoRepository toDoRepository;

	@BeforeEach
	public void setup(){
		toDoRepository.deleteAll();
		toDoRepository.save(new ToDoItem("Update Software","Update operating system at Sale department"));
		toDoRepository.save(new ToDoItem("Meeting with designer","Have a meeting with designer at 11AM"));
	}

	@Test
	public void testGetToDoList(){
		List<ToDoItem> todoList = toDoService.getToDoList();
		Assert.assertThat(todoList.size(), Matchers.equalTo(2));
	}

	@Test
	public void testFindToDoByID(){
		ToDoItem toDoItem = toDoService.findToDoByID(1);
		Assert.assertThat(toDoItem.getName(), Matchers.equalTo("Update Software"));
		ToDoItem toDoItem2 = toDoService.findToDoByID(2);
		Assert.assertThat(toDoItem2.getName(), Matchers.equalTo("Meeting with designer"));
	}

	@Test
	public void testFindToDoByInvalidID(){
		//Positive
		ToDoItem toDoItem = toDoService.findToDoByID(10000);
		Assert.assertThat(toDoItem, Matchers.equalTo(null));

		//Zero
		ToDoItem toDoItem2 = toDoService.findToDoByID(0);
		Assert.assertThat(toDoItem2, Matchers.equalTo(null));

		//Negative
		ToDoItem toDoItem3 = toDoService.findToDoByID(-1);
		Assert.assertThat(toDoItem3, Matchers.equalTo(null));
	}

	@Test
	public void testUpdateToDoByID(){
		ToDoItem savedItem = toDoRepository.save(new ToDoItem("Meeting with Mr.Parker", "AKA Spiderman"));
		ToDoItem updatedItem = toDoService.updateToDoByID(savedItem.getId(),new ToDoItem("Check email","Checking email"));
		Assert.assertThat(updatedItem.getName(), Matchers.equalTo("Check email"));
	}

	@Test
	public void testUpdateToDoByInvalidID(){
		ToDoItem updatedItem = toDoService.updateToDoByID(10000,new ToDoItem("Check email","Checking email"));
		Assert.assertThat(updatedItem, Matchers.equalTo(null));
	}

	@Test
	public void deleteToDoByID(){
		ToDoItem savedItem = toDoRepository.save(new ToDoItem("Meeting with Mr.Parker", "AKA Spiderman"));
		boolean isDeleted = toDoService.deleteToDoByID(savedItem.getId());
		Assert.assertThat(isDeleted, Matchers.equalTo(true));
	}

	@Test
	public void deleteToDoByInvalidID(){
		boolean isDeleted = toDoService.deleteToDoByID(10000);
		Assert.assertThat(isDeleted, Matchers.equalTo(false));
	}



}
