package com.example.blogweb.Controller;

import com.example.blogweb.Model.Blog;
import com.example.blogweb.Model.Category;
import com.example.blogweb.Service.imp.BlogServiceImp;
import com.example.blogweb.Service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("category")
public class CategoryControllerRest {
    @Autowired
    CategoryServiceImp categoryServiceImp;
    @Autowired
    BlogServiceImp blogServiceImp;
    @GetMapping("/cate")
    public ResponseEntity<List<Category>> getCatrgory(){
        List<Category> list= categoryServiceImp.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/cateedit")
    public ResponseEntity<Map<Long,String>> getCate(){
        Map<Long,String> stringMap=new HashMap<>();
        List<Category> list12= categoryServiceImp.findAll();
        for (Category in:list12
             ) {
            stringMap.put(in.getId(), in.getNameCategory());
        }
        return new ResponseEntity<>(stringMap,HttpStatus.OK);
    }
    @GetMapping("/baiviet")
    public ResponseEntity<List<Blog>> getBlog(){
        List<Blog> blogList=blogServiceImp.findall23();
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/baivietedit")
    public ResponseEntity<Map<Long,String>> getBlog1(){
        Map<Long,String> stringMap=new HashMap<>();
        List<Blog> list12= blogServiceImp.findall23();
        for (Blog in:list12
        ) {
            stringMap.put(in.getId(), in.getName());
        }
        return new ResponseEntity<>(stringMap,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Blog>> getBlogbycategory(@RequestBody Category category){
        List<Blog> blogList=blogServiceImp.findbycategory(category);
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
