package cs.mum.edu.orangeteam.compro.Service;

import cs.mum.edu.orangeteam.compro.Repository.TMIstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TMIstructorServiceImpl implements TMIstructorService{
    @Autowired
    private TMIstructorRepository tmIstructorRepository;

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}
