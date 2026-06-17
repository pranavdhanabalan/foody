package com.pranavd.foody.Repository;

import com.pranavd.foody.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByuserEmail(String Email);

}
