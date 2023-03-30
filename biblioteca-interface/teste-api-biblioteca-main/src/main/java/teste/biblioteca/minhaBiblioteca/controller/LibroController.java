package teste.biblioteca.minhaBiblioteca.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import teste.biblioteca.minhaBiblioteca.domain.Libro;
import teste.biblioteca.minhaBiblioteca.services.*;

@Controller
public class LibroController {
	
	@Autowired
	private LibroService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/registro_libro")
	public String registroLibro() {
		return "registroLibro";
	}
	
	@GetMapping("/libros_disponiveis")
	public ModelAndView getLibros() {
		List<Libro>list=service.getLibros();
		//ModelAndView m= new ModelAndView();
		//m.setViewName("librosDisponiveis");
		//m.addObject("libro",list);
		return new ModelAndView("librosDisponiveis","libro",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Libro libro) {
		service.save(libro);
		return "redirect:/libros_disponiveis";
	}
	
	@RequestMapping("/editarLibro/{id}")
	public String editarLibro(@PathVariable("id") String id, Model model) {
		Libro libro = service.getLibroPeloId(id);
		model.addAttribute("libro",libro);
		return "editarLibro";
	}
	
	@RequestMapping("/excluirLibro/{id}")
	public String excluirLibro(@PathVariable("id") String id) {
		service.excluirLibroPeloId(id);
		return "redirect:/libros_disponiveis";
	}
}
