package pj1.dto;

import lombok.Data;

@Data
public class OrderlistDto {
	
	//orderDto
	private int orderNum;
	private String orderStatus;
	private String orderDate;
	private int itemNum;
	private int itemAmount;
	private String itemName;
	private int itemPrice;
	private int memIdx;
	private String memEmail;

	//refundDto
	private int refundAmount;
	private String refundReason;
	private String refundDate;
	private String refundStatus;
	
	//reviewDto
	private int reviewIdx;
	private String reviewWriteYn;
	private String reviewContents;
	private String reviewWriteDate;
	
	
}