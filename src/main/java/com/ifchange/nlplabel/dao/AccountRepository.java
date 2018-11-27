package com.ifchange.nlplabel.dao;

import com.ifchange.nlplabel.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName: AccountRepository
 * @Description:
 * @author: Dieson Zuo
 * @date: Created in 19:55 2018/11/20
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(nativeQuery = true, value = "select * from user u where uname=:username and password=:password")
    Account findByUnameAndPassword(@Param("uname") String username, @Param("password") String password);

    @Query(nativeQuery = true, value = "select * from user u where uname=:username")
    Account findByUsername(@Param("uname")String username);
}
