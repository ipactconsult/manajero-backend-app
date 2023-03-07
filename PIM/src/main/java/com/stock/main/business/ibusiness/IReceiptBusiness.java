package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.Receipt;

public interface IReceiptBusiness {
	
	public List<Receipt> getAllReceipts();
	public List<Receipt> getAllReceiptsASC();
	public List<Receipt> getAllReceiptsDESC();
        public Receipt getOneReceipt(String receiptId);
	public Receipt addNewReceipt(Receipt receipt, int currentRate);
	public Receipt archiveReceipt(String receiptId);
	public Receipt restoreReceipt(String receiptId);

}
