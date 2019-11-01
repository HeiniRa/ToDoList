package ServerProgrammingProject.todolist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


import ServerProgrammingProject.todolist.domain.UserRepository;
import ServerProgrammingProject.todolist.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	UserRepository repository;

	@Test
	public void addNewUSer() {
		User user = new User("User2", "EE11CBB19052E40B07AAC0CA060C23EE", "user", "user2@test.com");
		repository.save(user);

		assertThat(repository.findById(user.getId())).isNotNull();
	}

	@Test
	public void deleteUser() {
		User user = new User("User2", "EE11CBB19052E40B07AAC0CA060C23EE", "user", "user2@test.com");
		repository.save(user);
		long id = user.getId();
		repository.deleteById(id);
		assertThat(repository.findById(id)).isEmpty();

	}

	@Test
	public void findByNameShouldReturnUser() {
		User user = new User("User2", "EE11CBB19052E40B07AAC0CA060C23EE", "user", "user2@test.com");
		repository.save(user);

		assertThat(repository.findByUsername("User2")).isNotNull();
	}

}
