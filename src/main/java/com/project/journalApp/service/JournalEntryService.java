package com.project.journalApp.service;

import com.project.journalApp.entity.JournalEntry;
import com.project.journalApp.entity.User;
import com.project.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional //used so that if any transaction fails, it rolls back from previously changed state.
    //example from below. If after journal entry gets saved and then it throws some error/exception . So the user wont be saved
    //@Transactional is therefore used. It treats everything as a single operation.
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user=userService.findByUserName(userName);
            JournalEntry saved=journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
//            user.setUserName(null);
            userService.saveUser(user);
        }catch (Exception e){
//            throw new RuntimeException("An error occurred while saving the entry");
        }

    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry>getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public void deleteById(ObjectId id, String userName){
        try{
            User user=userService.findByUserName(userName);
            boolean removed=user.getJournalEntries().removeIf(x->x.getId().equals(id));
            if(removed){
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entry :"+e);
        }


    }
}
