package com.example.tinh_nang_bai_hat.service.imp;

import com.example.tinh_nang_bai_hat.model.Song;
import com.example.tinh_nang_bai_hat.repository.SongRepository;
import com.example.tinh_nang_bai_hat.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImp implements SongService {
    @Autowired
    SongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void create(Song song) {
        songRepository.save(song);

    }

    @Override
    public Song findbyid(Long id) {
        return songRepository.findById(id).orElse(null);
    }
}
