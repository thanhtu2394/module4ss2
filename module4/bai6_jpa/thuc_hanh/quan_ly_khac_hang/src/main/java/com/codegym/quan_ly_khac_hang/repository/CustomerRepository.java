package com.codegym.quan_ly_khac_hang.repository;

import com.codegym.quan_ly_khac_hang.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Modifying
    @Transactional
    @Query(value = "CALL Insert_Customer(:firtsName,:lastName)", nativeQuery = true)
    public void createProcedue(@Param("firtsName") String firtsName,@Param("lastName") String lastName);
}
