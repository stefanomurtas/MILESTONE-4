package ticket.platform.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import ticket.platform.domain.entity.Category;
import ticket.platform.repository.CategoryRepository;
import ticket.platform.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Category findById(Integer id){
        return categoryRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Categoria non trovata con id: " + id));
}
    }
