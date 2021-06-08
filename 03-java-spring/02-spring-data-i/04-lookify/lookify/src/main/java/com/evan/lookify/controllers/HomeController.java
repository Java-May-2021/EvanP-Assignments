package com.evan.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evan.lookify.models.Song;
import com.evan.lookify.services.SongService;

@Controller
public class HomeController {
	private final SongService sService;
	public HomeController(SongService service) {
		this.sService = service;
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String findAllSongs(Model model) {
		List<Song> allSongs = sService.findAllSongs();
		model.addAttribute("songs", allSongs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song, Model model) {
		return "new.jsp";
	}
	
	@PostMapping(value="/dashboard")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			sService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/songs/{id}")
	public String details(@PathVariable("id") Long id, @ModelAttribute("song") Song song, Model model) {
		Song newSong = this.sService.findSong(id);
		model.addAttribute("song", newSong);
		return "details.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTenByRating(Model model) {
		List<Song> songs = sService.topTenByRating();
		model.addAttribute("songs", songs);
		return "topten.jsp";
	}
	
	@PostMapping(value="/search")
	public String findByArtist(@RequestParam("artist") String artist, Model model) {
		List<Song> songs = sService.findByArtist(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	
	@GetMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.sService.deleteSong(id);
		return "redirect:/dashboard";
	}
		
}
