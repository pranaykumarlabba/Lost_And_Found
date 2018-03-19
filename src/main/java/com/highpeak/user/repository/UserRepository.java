package com.highpeak.user.repository;

import com.highpeak.springproject.Address;
import com.highpeak.springproject.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    User findByEmailAndPassword(String email,String password);
        @Modifying
        @Query(nativeQuery = true,value = " UPDATE user_table SET password = :newPassword " +
                "where email = :email  ")
        void findByEmail(@Param("email") String email,@Param("newPassword") String newPassword);




}

