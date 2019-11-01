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

			catRepository.save(new Category("Other"));
			catRepository.save(new Category("Home"));
			catRepository.save(new Category("Study"));

			userRepository.save(new User("user", "$2a$09$h8GUNwXMAxjuzHXUuhWVu.6cOnNhwITNmWRXGBieLeOut1cGTixJy", "USER",
					"testi@testi.com"));
			userRepository.save(new User("admin", "$2a$09$JV1vi0Tf/rmRpqtXhyH6AO7IJ2Kcl3a/v5XZLxG9b5q24O2ppkGAK",
					"ADMIN", "testi1@testi.com"));

			taskRepository.save(
					new Task("Cleanup the kitchen", "01-01-2020", catRepository.findByName("Home").get(0), "done"));
			taskRepository.save(new Task("Remove stains from microwave", "31-12-2019",
					catRepository.findByName("Study").get(0), "Open"));

		};
	}

}
