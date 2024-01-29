package com.exam.services.implement;

import com.exam.exception.ResourceNotFoundException;
import com.exam.model.exams.Category;
import com.exam.repo.CategoryRepository;
import com.exam.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
       return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) throws Exception {
        return this.categoryRepository.findById(categoryId)
        		.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
    }

    @Override
    public void delete(Long categoryId) {
    this.categoryRepository.deleteById(categoryId);
    }
}
