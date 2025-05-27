//package com.project.journalApp.controller;
//
//import com.project.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
////    METHODS INSIDE A CONTROLLER CLASS SHOULD BE
////    PUBLIC SO THAT THEY CAN BE ACCESSED AND INVOKED BY THE SPRING FRAMEWORK OR EXTERNAL
////    HTTP REQUESTS.
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @GetMapping("id/{myId}")
//    public  JournalEntry getJournalEntryById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournal(@PathVariable Long myId){
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{myId}")
//    public JournalEntry updateJournal(@PathVariable Long myId,@RequestBody JournalEntry myEntry){
//        return journalEntries.put(myId,myEntry);
//    }
//}
