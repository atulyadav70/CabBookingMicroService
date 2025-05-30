package com.cbs.Driver.Repository;

import com.cbs.Driver.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDriverRepository extends JpaRepository<Driver,Long> {
    @Query("SELECT d FROM Driver d WHERE d.email = :email")
    Driver findByEmail (@Param("email") String email);
}
