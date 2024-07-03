package com.account_service.repositories;


import com.account_service.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT COUNT(1) FROM Account a WHERE a.branch = :branch AND a.id < :maxId")
    Long countAccountsByBranchAndIdLessThan(@Param("branch") Long branch, @Param("maxId") Long maxId);
}
