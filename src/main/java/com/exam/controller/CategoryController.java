package com.exam.controller;

import com.exam.model.exams.Category;
import com.exam.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //add category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category)
    {
     Category cat1=this.categoryService.addCategory(category);
     return  ResponseEntity.ok(cat1);
    }

    //get single category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId) throws Exception
    {

        return  this.categoryService.getCategory(categoryId);
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {
        return  ResponseEntity.ok(this.categoryService.getCategories());
    }

    //update any category
    @PutMapping("/")
    public  Category updateCategory(@RequestBody Category category)
    {
        return this.categoryService.updateCategory(category);
    }

    //delete Category
    @DeleteMapping("/{categoryId}")
    public  void  DelteCategory(@PathVariable("categoryId") Long catId)
    {
        this.categoryService.delete(catId);
    }


}
