package com.example.test.repository;

import com.example.test.model.KhuyenMai;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,Long> {
    List<KhuyenMai> findAllByMucGiamGiaContaining(Long mucgia);
    List<KhuyenMai> findAllByTimeStarContaining(String timestar);
    List<KhuyenMai> findAllByTimeEndContaining(String timeend);
    List<KhuyenMai> findAllByMucGiamGiaContainingAndAndTimeStarContainingAndTimeEndContaining(Long giamgia,String timestar,String timeend);
//    @Query("select q from KhuyenMai q where (:typeId is null or q.mucGiamGia = :typeId)")
//    List<KhuyenMai> findAllByID(Long typeId);

}
