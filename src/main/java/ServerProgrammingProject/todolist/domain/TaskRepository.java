package ServerProgrammingProject.todolist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task, Long> {
	
	List<Task> findByTitleIgnoreCase(String title);
	
	Task findById(long id);
	

}
