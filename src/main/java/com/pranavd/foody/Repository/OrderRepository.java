package com.pranavd.foody.Repository;

import com.pranavd.foody.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
