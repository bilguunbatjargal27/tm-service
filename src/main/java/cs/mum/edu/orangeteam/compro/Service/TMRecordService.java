package cs.mum.edu.orangeteam.compro.Service;

import cs.mum.edu.orangeteam.compro.Model.TMRecord;

import java.util.List;
import java.util.Optional;

public interface TMRecordService {
   public List<TMRecord> getTMRecords();
    public TMRecord updateTMRecord(TMRecord tmRecord);
    public void deleteTMRecord(Long id);
    TMRecord findTMRecordById(Long id);

    public TMRecord getTMRecord(TMRecord tmRecord);

    public TMRecord addTMRecord(TMRecord tmRecord);
}
