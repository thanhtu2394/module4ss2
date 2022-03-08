package com.codegym.quan_ly_khach_hang_tinh.repository;

import com.codegym.quan_ly_khach_hang_tinh.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
}
