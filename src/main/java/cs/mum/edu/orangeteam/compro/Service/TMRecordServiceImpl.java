package cs.mum.edu.orangeteam.compro.Service;

import cs.mum.edu.orangeteam.compro.Model.TMRecord;
import cs.mum.edu.orangeteam.compro.Repository.TMRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TMRecordServiceImpl implements TMRecordService {
    @Autowired
    private TMRecordRepository tmRecordRepository;
    @Override
    public List<TMRecord> getTMRecords() {
        return tmRecordRepository.findAll();
    }
    @Override
    public TMRecord getTMRecord(TMRecord tmRecord) {
        return null;
    }

    @Override
    public TMRecord updateTMRecord(TMRecord tmRecord) {
        return null;
    }

    @Override
    public void deleteTMRecord(Long id) {

    }

    @Override
    public TMRecord findTMRecordById(Long id) {
        if(tmRecordRepository.findById(id).isPresent()) return tmRecordRepository.findById(id).get();
        return null;
    }
}
