package marcowidesott.BackM2W2D3.services;

import marcowidesott.BackM2W2D3.entities.Blog;
import marcowidesott.BackM2W2D3.exceptions.NotFoundException;
import marcowidesott.BackM2W2D3.payloads.BlogPayload;
import marcowidesott.BackM2W2D3.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Blog saveBlog(BlogPayload body) {
        Blog blog = new Blog(
                body.getCategoria(),
                body.getTitolo(),
                body.getContenuto(),
                body.getTempoLettura().byteValue()
        );
        
        return blogRepository.save(blog);
    }

    public Blog findById(Long blogId) {
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new NotFoundException("Blog not found"));
    }
}
