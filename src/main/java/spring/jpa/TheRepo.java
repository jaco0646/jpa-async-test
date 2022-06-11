package spring.jpa;

import org.springframework.data.repository.CrudRepository;

public interface TheRepo extends CrudRepository<TheEntity, Integer> {
}
