package ServerProgrammingProject.todolist;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ServerProgrammingProject.todolist.domain.Category;
import ServerProgrammingProject.todolist.domain.CategoryRepository;
import ServerProgrammingProject.todolist.domain.Task;
import ServerProgrammingProject.todolist.domain.TaskRepository;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner clr(CategoryRepository catRepository, TaskRepository taskRepository) {
		return (args) -> {
			
			
			
			  Category cat1 = new Category("Home"); Category cat2 = new Category("Study");
			  
			  catRepository.save(cat1); catRepository.save(cat2);
			 
			
			
			  Task task1 = new Task("Cleanup the kitchen", "01-01-2020",
			  catRepository.findByName("Home").get(0)); Task task2 = new
			  Task("Remove stains from microwave", "31-12-2019",
			  catRepository.findByName("Study").get(0));
			  
			  taskRepository.save(task1); taskRepository.save(task2);
			 
		};
	}

}
