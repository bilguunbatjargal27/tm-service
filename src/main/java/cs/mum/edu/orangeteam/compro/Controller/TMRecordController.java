package cs.mum.edu.orangeteam.compro.Controller;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
import cs.mum.edu.orangeteam.compro.Model.TMRecord;
import cs.mum.edu.orangeteam.compro.Service.TMRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tmrecord/tmrecords")
public class TMRecordController {

    @Autowired
    private TMRecordService tmRecordService;

    @GetMapping("")
    public ResponseEntity<?> getAllTMRecords() {
        List<TMRecord> tmRecords=(List<TMRecord>) tmRecordService.getTMRecords();
        return ResponseEntity.ok(tmRecords);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTMRecordById(@PathVariable("id") Long id) {
      TMRecord tmRecord= tmRecordService.findTMRecordById(id);
        return ResponseEntity.ok(tmRecord);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addTMRecord(@Valid @RequestBody final TMRecord tmRecord, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
         tmRecordService.addTMRecord(tmRecord);
         return ResponseEntity.badRequest().body("TMRecord is created successfully");
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateTMRecord(@Valid @RequestBody final TMRecord tmRecord, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
       TMRecord tm= tmRecordService.updateTMRecord(tmRecord);
        return  ResponseEntity.status(HttpStatus.OK).body("TMRecord is updated successfully");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?>  deleteTMRecord(@PathVariable("id") Long id){
        TMRecord tmRecord = tmRecordService.findTMRecordById(id);
        if (tmRecord == null) return ResponseEntity.badRequest().body("There is no TMRecord has an id equal to " + id);
        tmRecordService.deleteTMRecord(id);
        return ResponseEntity.status(HttpStatus.OK).body("TMRecord is deleted successfully");
    }
}
