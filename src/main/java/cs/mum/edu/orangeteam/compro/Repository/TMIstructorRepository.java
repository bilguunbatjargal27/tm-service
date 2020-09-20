package cs.mum.edu.orangeteam.compro.Repository;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMIstructorRepository extends JpaRepository<TMInstructor,Integer> {
}
