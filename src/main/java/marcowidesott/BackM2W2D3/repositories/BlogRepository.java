package marcowidesott.BackM2W2D3.repositories;

import marcowidesott.BackM2W2D3.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}

