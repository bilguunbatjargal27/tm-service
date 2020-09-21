package cs.mum.edu.orangeteam.compro.Service;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
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
    public List<TMInstructor> getTMInstructors() {
        return tmIstructorRepository.findAll();
    }

    @Override
    public TMInstructor findTMInstructorById(Long id) {
       if(tmIstructorRepository.findById(id).isPresent())
           return tmIstructorRepository.findById(id).get();
       return null;
    }

    @Override
    public TMInstructor addTMInstructor(TMInstructor tmInstructor) {
        return tmIstructorRepository.save(tmInstructor);
    }

    @Override
    public TMInstructor updateTMInstructor(TMInstructor tmInstructor) {
        return tmIstructorRepository.save(tmInstructor);
    }

    @Override
    public void deleteTMInstructor(Long id) {
        tmIstructorRepository.deleteById(id);
    }
}
