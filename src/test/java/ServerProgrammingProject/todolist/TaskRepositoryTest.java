package ServerProgrammingProject.todolist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import ServerProgrammingProject.todolist.domain.CategoryRepository;
import ServerProgrammingProject.todolist.domain.Task;
import ServerProgrammingProject.todolist.domain.TaskRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {
	@Autowired TaskRepository repository;
	@Autowired CategoryRepository catRepository;
	
	/*
	 * @Test public void addTask() { Task task = new Task("Run 50min",
	 * "1.1.2020",catRepository.findByName("Study").get(0),"open");
	 * repository.save(task); assertThat(task.getTitle()).isEqualTo("Run 50min"); }
	 * 
	 * @Test public void deleteTask() { Task task = new Task("Walk 60min",
	 * "1.1.2020",catRepository.findByName("Study").get(0),"open");
	 * repository.save(task); long id = task.getId(); repository.deleteById(id);
	 * assertThat(repository.findById(id)).isNull(); }
	 */
	
	@Test
	public void findByNameShouldReturnTask() {
		List<Task> tasklist = repository.findByTitleIgnoreCase("cleanup the kitchen");
		
		assertThat(tasklist).hasSize(1);
		assertThat(tasklist.get(0).getTitle().equalsIgnoreCase("cleanup the kitchen"));
	}
}
