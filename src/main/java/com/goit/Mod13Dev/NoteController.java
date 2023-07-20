package com.goit.Mod13Dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @PostMapping("/list")
    public String addNote(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }
    @GetMapping("/list")
    public ModelAndView showNoteList(){
        List<Note>notes = noteService.listAll();
        ModelAndView result = new ModelAndView("list");
        result.addObject("notes", notes);
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam Long id){
        Note note = noteService.getById(id);
        ModelAndView result = new ModelAndView("edit");
        result.addObject("editNote", note);
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute Note note) {
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteNote(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
