package com.goit.Mod13Dev;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteService {
    private final List<Note> noteList = new ArrayList<>();
    @PostConstruct
    private void init(){
        log.info("===>>>     Init my NoteService!");
    }
    public List<Note> listAll(){
        return new ArrayList<>(noteList);}
    public Note add(Note note){
        long generatedId = generateUniqueId();
        note.setId(generatedId);
        noteList.add(note);
        return note;}
    private long lastGeneratedId = 0;
    private synchronized long generateUniqueId() {
        lastGeneratedId++;
        return lastGeneratedId;
    }
    public void deleteById(long id){
        Note note = getById(id);
       if (note==null){
           throw new IllegalArgumentException("Note with id " + id +"does not exist");
       }
       noteList.remove(note);
    }
    public void update(Note note){
    Note updatingNote = getById(note.getId());
    if (updatingNote==null){
        throw new IllegalArgumentException("Note with id "+note.getId()+ "does not exist");
    }
     updatingNote.setTitle(note.getTitle());
     updatingNote.setContent(note.getContent());
    }
    Note getById(long id){
        for (Note note : noteList) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
    @PreDestroy
    public void cleanup() {
       log.info("===>>>     My NoteService cleanup");
    }
}
