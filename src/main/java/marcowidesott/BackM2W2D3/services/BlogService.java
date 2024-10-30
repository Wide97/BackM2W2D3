package marcowidesott.BackM2W2D3.services;

import marcowidesott.BackM2W2D3.entities.Blog;
import marcowidesott.BackM2W2D3.exceptions.NotFoundException;
import marcowidesott.BackM2W2D3.payloads.BlogPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> listBlog = new ArrayList<>();

    public List<Blog> findAllBlogs() {
        return this.listBlog;
    }

    public Blog saveBlog(BlogPayload body) {
        Random rndm = new Random();
        Blog blog = new Blog(body.getCategoria(), body.getTitolo(), body.getContenuto(), 60);
        blog.setId(rndm.nextLong(1, 1000));
        this.listBlog.add(blog);
        return blog;

    }

    public Blog findById(Long blogId) {
        Blog found = null;
        for (Blog blog : this.listBlog) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(Math.toIntExact(blogId));
        return found;
    }

    public void findByIdAndDelete(int id) {
        ListIterator<Blog> iterator = this.listBlog.listIterator();

        while (iterator.hasNext()) {
            Blog currentBlog = iterator.next();
            if (currentBlog.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Blog findByIdAndUpdate(int id, Blog body) {
        Blog found = null;

        for (Blog currentBlog : listBlog) {
            if (currentBlog.getId() == id) {
                found = currentBlog;
                found.setCover(body.getCover());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }
}
