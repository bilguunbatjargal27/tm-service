package cs.mum.edu.orangeteam.compro.Service;

import cs.mum.edu.orangeteam.compro.Model.TMRecord;

import java.util.List;

public interface TMIstructorService {
   public List<Student> getAllStudents();
   public Student addStudent(Integer id);
   public void setTMCheckingTime(Integer id);
   public void setTMAttendance(Integer id);

}
