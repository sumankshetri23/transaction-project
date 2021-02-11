package com.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.transaction.dtos.BalanceDto;
import com.transaction.dtos.TransactionDto;
import com.transaction.entities.BalanceEntity;
import com.transaction.entities.TransactionEntity;

public class MapperUtil {

	public static BalanceDto mapBalanceFromEntity(BalanceEntity balanceEntity) {

		if (balanceEntity != null) {
			BalanceDto balanceDto = new BalanceDto();
			balanceDto.setAccountNumber(balanceEntity.getAccountNumber());
			balanceDto.setBalance(balanceEntity.getBalance());
			balanceDto.setLastUpdateTimestamp(balanceEntity.getLastUpdateTimestamp());
			return balanceDto;
		}

		return null;
	}

	public static BalanceEntity mapBalanceToEntity(BalanceDto balanceDto) {

		if (balanceDto != null) {

			BalanceEntity balanceEntity = new BalanceEntity();
			balanceEntity.setAccountNumber(balanceDto.getAccountNumber());
			balanceEntity.setBalance(balanceDto.getBalance());
			balanceEntity.setLastUpdateTimestamp(balanceDto.getLastUpdateTimestamp());

			return balanceEntity;
		}

		return null;
	}

	public static TransactionDto mapTransactionFromEntity(TransactionEntity transactionEntity) {

		if (transactionEntity != null) {
			TransactionDto transactionDto = new TransactionDto();
			transactionDto.setAccountNumber(transactionEntity.getAccountNumber());
			transactionDto.setAmount(transactionEntity.getAmount());
			transactionDto.setTransactionTs(transactionEntity.getTransactionTs());
			transactionDto.setType(transactionEntity.getType());
			transactionDto.setDate(transactionEntity.getDate());
	

			return transactionDto;
		}

		return null;
	}

	public static TransactionEntity mapTransactionToEntity(TransactionDto transactionDto) {

		if (transactionDto != null) {
			TransactionEntity transactionEntity = new TransactionEntity();
			transactionEntity.setAccountNumber(transactionDto.getAccountNumber());
			transactionEntity.setAmount(transactionDto.getAmount());
			transactionEntity.setTransactionTs(transactionDto.getTransactionTs());
			transactionEntity.setType(transactionDto.getType());
			transactionEntity.setDate(transactionDto.getDate());
		

			return transactionEntity;
		}

		return null;
	}

//	if (dependentEntityList != null && dependentEntityList.size() > 0) {
//
//		Set<DependentDto> dependentDtos = new HashSet<>();
//
//		for (DependentEntity p : dependentEntityList) {
//			DependentDto dependentDto = new DependentDto();
//			dependentDto.setId(p.getId());
//			
//			dependentDto.setBirthDate(p.getBirthDate());
//			dependentDto.setName(p.getName());
//			dependentDtos.add(dependentDto);
//		}
//		return dependentDtos;
//	}
//
//	return null;

	public static List<TransactionDto> mapTransactionListFromEntity(List<TransactionEntity> transactionEntities) {

		if (transactionEntities != null && transactionEntities.size() > 0) {

			List<TransactionDto> transactionDtos = new ArrayList<TransactionDto>();
			for (TransactionEntity t : transactionEntities) {
				TransactionDto transactionDto = new TransactionDto();
				transactionDto.setAccountNumber(t.getAccountNumber());
				transactionDto.setAmount(t.getAmount());
				transactionDto.setTransactionTs(t.getTransactionTs());
				transactionDto.setType(t.getType());
				transactionDto.setDate(t.getDate());
				transactionDtos.add(transactionDto);
			
			}
			return transactionDtos;

		}

		return null;
	}

}
