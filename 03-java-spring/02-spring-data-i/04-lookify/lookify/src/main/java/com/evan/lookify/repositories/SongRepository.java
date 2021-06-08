package com.evan.lookify.repositories;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evan.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findTopTenByOrderByRatingDesc();
	List<Song> findByArtistContaining(String artist);

}
