package marcowidesott.BackM2W2D3.controllers;

import marcowidesott.BackM2W2D3.entities.Blog;
import marcowidesott.BackM2W2D3.payloads.BlogPayload;
import marcowidesott.BackM2W2D3.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getBlogs() {
        return this.blogService.findAllBlogs();

    }

    @GetMapping("/{blogId}")
    public Blog getSingleBlog(@PathVariable Long blogId) {
        return this.blogService.findById(blogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(BlogPayload body) {
        return this.blogService.saveBlog(body);

    }

    //@PutMapping
    //public Blog modifyingBlog() {

    // }

    // @DeleteMapping
    // public Blog deleteBlog() {

    //}

}
