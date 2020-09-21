package cs.mum.edu.orangeteam.compro.Service;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;

import java.util.List;

public interface TMIstructorService {
   public List<TMInstructor> getTMInstructors();

   public  TMInstructor findTMInstructorById(Long id);

    public TMInstructor addTMInstructor(TMInstructor tmInstructor);

   public  TMInstructor updateTMInstructor(TMInstructor tmInstructor);

   public  void deleteTMInstructor(Long id);
}
