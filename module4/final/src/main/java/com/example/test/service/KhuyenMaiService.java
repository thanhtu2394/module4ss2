package com.example.test.service;

import com.example.test.model.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhuyenMaiService {
    List<KhuyenMai> findAll();
    void save(KhuyenMai khuyenMai);
    void delete(Long id);
    KhuyenMai findbyid(Long id);
    List<KhuyenMai> findAllByMucGiamGiaContaining(Long giamgia);
    List<KhuyenMai> findAllByTimeStarContaining(String timestar);
    List<KhuyenMai> findAllByTimeEndContaining(String timeend);
    List<KhuyenMai> findAllByMucGiamGiaContainingAndAndTimeStarContainingAndTimeEndContaining(Long giamgia,String timestar,String timeend);
//    List<KhuyenMai> findAllByID(Long typeId);

}
