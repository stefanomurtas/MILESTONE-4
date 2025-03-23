package ticket.platform.service;

import java.util.List;

import ticket.platform.domain.entity.Category;


public interface  CategoryService {
    List<Category>findAll();
    Category findById (Integer Id);
}
