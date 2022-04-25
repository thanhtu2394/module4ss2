package com.example.test.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class KhuyenMai  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nameKhuyenMai;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String timeStar;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private String timeEnd;
    @NotNull
    @Min(10000)
    private Long mucGiamGia;
    @NotEmpty
    private String chiTiet;

    public KhuyenMai() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameKhuyenMai() {
        return nameKhuyenMai;
    }

    public void setNameKhuyenMai(String nameKhuyenMai) {
        this.nameKhuyenMai = nameKhuyenMai;
    }

    public String getTimeStar() {
        return timeStar;
    }

    public void setTimeStar(String timeStar) {
        this.timeStar = timeStar;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Long getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(Long mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
}
