package com.example.tinh_nang_bai_hat.service;

import com.example.tinh_nang_bai_hat.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();
    void create(Song song);
    Song findbyid(Long id);

}
