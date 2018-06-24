package com.meesho.microservices.entities;

public enum NotificationType {
	NEW_ORDER_PLACED_INVOICE_PENDING(1),NEW_ORDER_PLACED_INVOICE_GENERATED(2),OLD_ORDER_INVOICE_DONE(3);
	
	private int type;
	
	private NotificationType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
