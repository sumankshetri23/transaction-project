package com.transaction.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dtos.BalanceDto;
import com.transaction.dtos.TransactionDto;
import com.transaction.services.CustomerService;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/balance")
	public ResponseEntity<BalanceDto> saveBalance(@RequestBody BalanceDto balance) {
		return new ResponseEntity<>(customerService.saveBalance(balance), HttpStatus.OK);
	}

	@GetMapping("/balance")
	public ResponseEntity<Double> getBalance(@RequestParam String accountNumber) {

		return new ResponseEntity<>(customerService.getBalance(accountNumber), HttpStatus.OK);
	}

	@PostMapping("/transaction")
	public ResponseEntity<TransactionDto> saveTransaction(@RequestBody TransactionDto transaction) {
		return new ResponseEntity<>(customerService.saveTransaction(transaction), HttpStatus.OK);
	}

	@GetMapping("/transaction/{accNum}")
	public ResponseEntity<List<TransactionDto>> getTransaction(@PathVariable("accNum") String accNum,
			@RequestParam("x") @DateTimeFormat(iso = ISO.DATE) LocalDate x,
			@RequestParam("y") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate y,
			@RequestParam(value = "type", required = false) String type) {
		List<TransactionDto> transactionDtos = customerService.getTransaction(accNum, x, y, type);
		return new ResponseEntity<>(transactionDtos, HttpStatus.OK);
	}

}
