package com.transaction.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.entities.BalanceEntity;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, Integer> {

	Optional<BalanceEntity> findByAccountNumber(String accountNumber);

	




}
