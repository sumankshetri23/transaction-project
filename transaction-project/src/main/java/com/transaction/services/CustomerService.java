package com.transaction.services;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.transaction.dtos.BalanceDto;
import com.transaction.dtos.TransactionDto;
import com.transaction.entities.BalanceEntity;
import com.transaction.entities.TransactionEntity;
import com.transaction.repositories.BalanceRepository;
import com.transaction.repositories.TransactionRepository;
import com.utils.MapperUtil;

@Service
public class CustomerService {

	@Autowired
	BalanceRepository balanceRepository;

	@Autowired
	TransactionRepository transactionRepository;

	public BalanceDto saveBalance(BalanceDto balanceDto) {
		balanceDto.setLastUpdateTimestamp(new Timestamp(System.currentTimeMillis()));
		BalanceEntity balanceEntity = MapperUtil.mapBalanceToEntity(balanceDto);
		balanceRepository.save(balanceEntity);
		return balanceDto;
	}

	public Double getBalance(String accountNumber) {
		Optional<BalanceEntity> optional = balanceRepository.findByAccountNumber(accountNumber);

		if (optional.isPresent()) {
			BalanceDto balanceDto = MapperUtil.mapBalanceFromEntity(optional.get());
			return balanceDto.getBalance();

		}
		throw new EntityNotFoundException();
	}

	public TransactionDto saveTransaction(TransactionDto transactionDto) {
		transactionDto.setTransactionTs(new Timestamp(System.currentTimeMillis()));
		transactionDto.setDate(LocalDate.now());
		TransactionEntity transcationEntity = MapperUtil.mapTransactionToEntity(transactionDto);
		transactionRepository.save(transcationEntity);
		return transactionDto;

	}

	public List<TransactionDto> getTransaction(String accountNumber, LocalDate x, LocalDate y, String type) {

		Optional<List<TransactionEntity>> optional = transactionRepository.findByAccountNumber(accountNumber);

		if (optional.isPresent()) {
			List<TransactionEntity> transactionEntities = transactionRepository.findAllByDateBetween(accountNumber,x, y);
			List<TransactionDto> transactionDtos = MapperUtil.mapTransactionListFromEntity(transactionEntities);
			if (StringUtils.hasLength(type)) {
				return transactionDtos.stream().filter(t -> type.equals(t.getType())).collect(Collectors.toList());
			}
			return transactionDtos;

		}
		throw new EntityNotFoundException();

	}



}
