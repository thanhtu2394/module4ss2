package com.codegym.quan_ly_khach_hang_tinh.service;

import com.codegym.quan_ly_khach_hang_tinh.model.Customer;
import com.codegym.quan_ly_khach_hang_tinh.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    void delete(Long id);
    Province find(Long id);
    void save(Province province);
}
