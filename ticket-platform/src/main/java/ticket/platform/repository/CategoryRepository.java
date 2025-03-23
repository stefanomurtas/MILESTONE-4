package ticket.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.platform.domain.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {

}
