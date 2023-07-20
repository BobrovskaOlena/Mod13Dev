package com.goit.Mod13Dev;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Mod13DevApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Mod13DevApplication.class, args);
		NoteService noteService = context.getBean(NoteService.class);

//		Note note = new Note();
//		note.setTitle("My First Note");
//		note.setContent("This is my first note!");
//		noteService.add(note);
//		System.out.println("Added note: " + note);
//
//		System.out.println("All notes: " + noteService.listAll().toString());
//
//		note.setTitle("First Note");
//		note.setContent("Updated content");
//		noteService.update(note);
//		System.out.println("Updated note: " + note);
//
//		System.out.println("Note with id 1: " + noteService.getById(1L).toString());
//
//		noteService.deleteById(1L);
//		System.out.println("All notes after deletion: " + noteService.listAll().toString());
	}
}

