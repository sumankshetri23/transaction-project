package com.transaction.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.transaction.entities.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {


	@Query("SELECT t FROM TransactionEntity t WHERE t.accountNumber=?1 AND t.date BETWEEN ?2 AND ?3")
	List<TransactionEntity> findAllByDateBetween(String accountNumber, LocalDate x, LocalDate y);

	@Query("select t from TransactionEntity t where t.accountNumber = ?1")
	Optional<List<TransactionEntity>> findByAccountNumber(String accountNumber);

	@Query("select t from TransactionEntity t where t.type = ?1")
	List<TransactionEntity> findAllByType(String type);




}
