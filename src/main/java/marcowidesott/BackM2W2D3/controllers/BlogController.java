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

    // 4. - PUT http://localhost:3001/blogs/{id} (+ req.body)
    @PutMapping("/{blogId}")
    public Blog findAndUpdate(@PathVariable int blogId, @RequestBody Blog body) {
        return blogService.findByIdAndUpdate(blogId, body);
    }

    // 5. - DELETE http://localhost:3001/blogs/{id
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int blogId) {
        blogService.findByIdAndDelete(blogId);
    }

}
