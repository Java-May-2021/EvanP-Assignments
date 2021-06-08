package com.evan.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evan.lookify.models.Song;
import com.evan.lookify.repositories.SongRepository;


@Service
public class SongService {

	private SongRepository sRepo;
	
	public SongService(SongRepository repo) {
		this.sRepo = repo;
	}
	
	public List<Song> findAllSongs() {
		return this.sRepo.findAll();
	}
	
	public Song findSong(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	public Song createSong(Song newSong) {
		return this.sRepo.save(newSong);
	}
	
	public Song updateSong(Song updatedSong) {
		return this.sRepo.save(updatedSong);
	}
	
	public void deleteSong(Long id) {
		this.sRepo.deleteById(id);
	}	
	
	public List<Song> topTenByRating() {
		return this.sRepo.findTopTenByOrderByRatingDesc();
	}
	
	public List<Song> findByArtist(String artist) {
		return this.sRepo.findByArtistContaining(artist);
	}

}
