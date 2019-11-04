package ServerProgrammingProject.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ServerProgrammingProject.todolist.domain.Category;
import ServerProgrammingProject.todolist.domain.CategoryRepository;
import ServerProgrammingProject.todolist.domain.Task;
import ServerProgrammingProject.todolist.domain.TaskRepository;
import ServerProgrammingProject.todolist.domain.User;
import ServerProgrammingProject.todolist.domain.UserRepository;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(CategoryRepository catRepository, TaskRepository taskRepository,
			UserRepository userRepository) {
		return (args) -> {
			 

		};
	}

}
