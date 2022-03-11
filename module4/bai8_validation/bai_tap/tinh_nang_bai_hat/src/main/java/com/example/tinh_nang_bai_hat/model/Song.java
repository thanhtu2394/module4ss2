package com.example.tinh_nang_bai_hat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(max=800)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String nameSong;
    @NotEmpty
    @Size(max=300)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String artistStong;
    @NotEmpty
    @Size(max=1000)
    @Pattern(regexp = "^[^,;]*$")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtistStong() {
        return artistStong;
    }

    public void setArtistStong(String artistStong) {
        this.artistStong = artistStong;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Song() {
    }
}
