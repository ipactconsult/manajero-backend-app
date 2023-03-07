package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IReceiptBusiness;
import com.stock.main.entities.Receipt;
import com.stock.main.repositories.ReceiptRepository;

@Service
public class ReceiptBusiness implements IReceiptBusiness {
	
	@Autowired
	private ReceiptRepository receiptRepo;
	
        @Override
	public List<Receipt> getAllReceipts() {
		List<Receipt> receipts = receiptRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "receiptCreationDate")
                );
		if (!receipts.isEmpty()) {
			return receipts;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Receipt> getAllReceiptsASC() {
		List<Receipt> receipts = receiptRepo.findAll(
				Sort.by(Sort.Direction.ASC, "receiptRef"));
		if (!receipts.isEmpty()) {
			return receipts;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Receipt> getAllReceiptsDESC() {
		List<Receipt> receipts = receiptRepo.findAll(
				Sort.by(Sort.Direction.DESC, "receiptRef"));
		if (!receipts.isEmpty()) {
			return receipts;
		}
		return new ArrayList<>();
	}
        
        @Override
	public Receipt getOneReceipt(String receiptId) {
		Receipt existedReceipt = receiptRepo.findById(receiptId).orElse(null);
		if (existedReceipt != null) {
                    return existedReceipt;
		} else {
                    return null;
		}
	}
	
        @Override
	public Receipt addNewReceipt(Receipt receipt, int currentRate) {
		receipt.setReceiptCreationDate(new Date());
		receipt.setReceiptState(true);
                receipt.setReceiptRate(currentRate);
		receiptRepo.save(receipt);
		return receipt;
	}
	
        @Override
	public Receipt archiveReceipt(String receiptId) {
		Receipt existedReceipt = receiptRepo.findById(receiptId)
				.orElse(null);
		if (existedReceipt != null) {
			existedReceipt.setReceiptState(false);
			receiptRepo.save(existedReceipt);
			return existedReceipt;
		} else {
			return null;
		}
	}
	
        @Override
	public Receipt restoreReceipt(String receiptId) {
		Receipt existedReceipt = receiptRepo.findById(receiptId)
				.orElse(null);
		if (existedReceipt != null) {
			existedReceipt.setReceiptState(true);
			receiptRepo.save(existedReceipt);
			return existedReceipt;
		} else {
			return null;
		}
	}

}
