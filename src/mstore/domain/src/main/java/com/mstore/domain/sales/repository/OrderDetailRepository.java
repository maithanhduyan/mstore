package com.mstore.domain.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mstore.domain.sales.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
