package jar.project.timelapsev0.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import jar.project.timelapsev0.models.historicaldata;


@Repository
public interface historicalRepository extends JpaRepository<historicaldata,Serializable> {
    
    Optional<historicaldata> findById(Long id); 
}
