package com.example.tinh_nang_bai_hat.repository;

import com.example.tinh_nang_bai_hat.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository  extends JpaRepository<Song,Long> {
}
