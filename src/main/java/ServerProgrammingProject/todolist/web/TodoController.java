package ServerProgrammingProject.todolist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ServerProgrammingProject.todolist.domain.Category;
import ServerProgrammingProject.todolist.domain.CategoryRepository;
import ServerProgrammingProject.todolist.domain.Task;
import ServerProgrammingProject.todolist.domain.TaskRepository;
import ServerProgrammingProject.todolist.domain.UserRepository;

@Controller
public class TodoController {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private CategoryRepository catRepository;
	@Autowired
	private UserRepository userRepository;

	// List of all tasks (tasks that are not done)
	public Iterable<Task> listAllTasks() {
		return taskRepository.findAll();
	}

	// List of all categories
	public Iterable<Category> listAllCategories() {
		return catRepository.findAll();
	}

	// Go to homepage
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("tasks", listAllTasks());
		return "index";
	}

	// Go to add task view
	@GetMapping("/addtask")
	public String addTask(@ModelAttribute Task task, Model model) {
		model.addAttribute("categories", listAllCategories());
		return "addtask";

	}

	// Save new task
	@PostMapping("/addtask")
	public String save(Task task) {
		taskRepository.save(task);
		return "redirect:/";
	}

	// Delete task
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") long taskId, Model model) {
		taskRepository.deleteById(taskId);
		return "redirect:/";

	}

	// Edit task
	@GetMapping("/edit/{id}")
	public String editTask(@PathVariable("id") long taskId, Model model) {
		model.addAttribute("task", taskRepository.findById(taskId));
		model.addAttribute("categories", listAllCategories());
		return "edittask";
	}

	// Update task
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") long taskId, Task taskDetails) {
		Task task = taskRepository.findById(taskId);

		task.setCategory(taskDetails.getCategory());
		task.setDate(taskDetails.getDate());
		task.setTitle(taskDetails.getTitle());
		task.setStatus(taskDetails.getStatus());
		// task.setUser(taskDetails.getUser());

		taskRepository.save(task);

		return "redirect:../";
	}

	// Go to Add new category view
	@GetMapping("/addcategory")
	public String addCategory(@ModelAttribute Category category) {
		return "addcategory";

	}

	// Add new category
	@PostMapping("/addcategory")
	public String saveNewCategory(Category category) {

		catRepository.save(category);
		return "redirect:/";
	}

	// Log out
	@PostMapping("/logout")
	public String logout() {
		return "login";
	}

	// Log in
	@GetMapping("login")
	public String login() {
		return "login";
	}

	// Go to tasks by users view
	@GetMapping("todosByUser")
	public String tasksByUsers(Model model) {
		model.addAttribute("tasks", listAllTasks());
		model.addAttribute("users", userRepository.findAll());
		return "todosByUser";
	}

	// RESTful service to get all tasks
	@GetMapping("tasks")
	public @ResponseBody List<Task> taskListRest() {
		return (List<Task>) taskRepository.findAll();
	}

	// RESTful service to get all categories
	@GetMapping("categories")
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) catRepository.findAll();
	}

	// RESTful service to get category by id
	@GetMapping("category/{id}")
	public @ResponseBody Category categoryRest(@PathVariable("id") long id) {
		return catRepository.findById(id);
	}

}
