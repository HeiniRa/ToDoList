package ServerProgrammingProject.todolist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ServerProgrammingProject.todolist.domain.Category;
import ServerProgrammingProject.todolist.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;

	@Test
	public void findByNameShouldReturnCategory() {
		Category category = new Category("Study");
		repository.save(category);
		List<Category> cateogries = repository.findByName("Study");
		assertThat(cateogries).hasSize(1);
		assertThat(cateogries.get(0).getName().equalsIgnoreCase("Study"));
	}

	@Test
	public void addNewCategory() {

		Category category = new Category("Other");
		repository.save(category);
		assertThat(category.getCategoryId()).isNotNull();

	}
	
	@Test
	public void deleteCategoryById() {
		Category category = new Category("Other");
		repository.save(category);
		long id = category.getCategoryId();
		repository.deleteById(category.getCategoryId());
		assertThat(repository.findById(id)).isNull();
	}

}
