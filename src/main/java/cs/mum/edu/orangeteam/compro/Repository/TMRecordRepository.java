package cs.mum.edu.orangeteam.compro.Repository;

import cs.mum.edu.orangeteam.compro.Model.TMRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMRecordRepository extends JpaRepository<TMRecord,Long> {
}
