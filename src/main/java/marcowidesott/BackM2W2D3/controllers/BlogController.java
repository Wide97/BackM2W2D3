package marcowidesott.BackM2W2D3.controllers;

import marcowidesott.BackM2W2D3.entities.Blog;
import marcowidesott.BackM2W2D3.payloads.BlogPayload;
import marcowidesott.BackM2W2D3.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    
    @GetMapping
    public ResponseEntity<Page<Blog>> getBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {


        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Sort sortOrder = Sort.by(direction, sort[0]);

        Pageable pageable = PageRequest.of(page, size, sortOrder);


        Page<Blog> blogs = blogService.findAll(pageable);
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{blogId}")
    public Blog getSingleBlog(@PathVariable Long blogId) {
        return this.blogService.findById(blogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody BlogPayload body) {
        return this.blogService.saveBlog(body);
    }
}
