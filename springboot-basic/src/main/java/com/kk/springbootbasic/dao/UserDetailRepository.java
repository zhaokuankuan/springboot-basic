package com.kk.springbootbasic.dao;

import com.kk.springbootbasic.domain.UserDetail;
import com.kk.springbootbasic.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long>{

    @Query("select u.userName as userName, u.email as email, d.address as address , d.hobby as hobby from User u , UserDetail d " +
            "where u.id=d.userId  and  d.hobby = ?1 ")
    List<UserInfo> findUserInfo(String hobby);
}
