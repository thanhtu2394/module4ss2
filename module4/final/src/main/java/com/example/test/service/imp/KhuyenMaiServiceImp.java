package com.example.test.service.imp;

import com.example.test.model.KhuyenMai;
import com.example.test.repository.KhuyenMaiRepository;
import com.example.test.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiServiceImp implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Override
    public List<KhuyenMai> findAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(Long id) {
khuyenMaiRepository.deleteById(id);
    }

    @Override
    public KhuyenMai findbyid(Long id) {
        return khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public List<KhuyenMai> findAllByMucGiamGiaContaining(Long giamgia) {
        return khuyenMaiRepository.findAllByMucGiamGiaContaining(giamgia);
    }

    @Override
    public List<KhuyenMai> findAllByTimeStarContaining(String timestar) {
        return khuyenMaiRepository.findAllByTimeStarContaining(timestar);
    }

    @Override
    public List<KhuyenMai> findAllByTimeEndContaining(String timeend) {
        return khuyenMaiRepository.findAllByTimeEndContaining(timeend);
    }

    @Override
    public List<KhuyenMai> findAllByMucGiamGiaContainingAndAndTimeStarContainingAndTimeEndContaining(Long giamgia, String timestar, String timeend) {
        return khuyenMaiRepository.findAllByMucGiamGiaContainingAndAndTimeStarContainingAndTimeEndContaining(giamgia,timestar,timeend);
    }

//    @Override
//    public List<KhuyenMai> findAllByID(Long typeId) {
//        return khuyenMaiRepository.findAllByID(typeId);
//    }
}
