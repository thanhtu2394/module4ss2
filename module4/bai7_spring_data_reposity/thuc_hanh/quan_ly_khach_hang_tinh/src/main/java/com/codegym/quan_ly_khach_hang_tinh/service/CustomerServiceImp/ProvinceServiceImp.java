package com.codegym.quan_ly_khach_hang_tinh.service.CustomerServiceImp;

import com.codegym.quan_ly_khach_hang_tinh.model.Customer;
import com.codegym.quan_ly_khach_hang_tinh.model.Province;
import com.codegym.quan_ly_khach_hang_tinh.repository.ProvinceRepository;
import com.codegym.quan_ly_khach_hang_tinh.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImp implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void delete(Long id) {
provinceRepository.deleteById(id);
    }

    @Override
    public Province find(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
provinceRepository.save(province);
    }
}
