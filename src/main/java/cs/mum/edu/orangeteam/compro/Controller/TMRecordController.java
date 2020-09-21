package cs.mum.edu.orangeteam.compro.Controller;
import cs.mum.edu.orangeteam.compro.Model.TMRecord;
import cs.mum.edu.orangeteam.compro.Service.TMRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tmrecord/tmrecords")
public class TMRecordController {
    @Autowired
    private TMRecordService tmRecordService;
    @GetMapping("")
    public List<TMRecord> getAllTMRecords(){
        return tmRecordService.getTMRecords();
    }
    @GetMapping("/{id}")
    public TMRecord getTMRecordById(@PathVariable("id") Long id) {

        return tmRecordService.findTMRecordById(id);
    }
    @GetMapping("/add")
    public TMRecord addTMRecord(@RequestBody final TMRecord tmRecord) {

        return tmRecordService.addTMRecord(tmRecord);
    }
    @GetMapping("update")
    public TMRecord updateTMRecord(@RequestBody final TMRecord tmRecord) {
        return tmRecordService.updateTMRecord(tmRecord);
    }
    @GetMapping("delete/{id}")
    public boolean deleteTMRecord(@PathVariable ("id") Long id) {
       TMRecord tmRecord=tmRecordService.findTMRecordById(id);
        if(tmRecord==null) return false;
        tmRecordService.deleteTMRecord(id);
        return true;
    }
}
