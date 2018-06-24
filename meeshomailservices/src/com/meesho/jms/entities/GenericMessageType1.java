package com.meesho.jms.entities;

public enum GenericMessageType1 {
	NEW_ORDER_PLACED_INVOICE_PENDING(1),NEW_ORDER_PLACED_INVOICE_GENERATED(2),OLD_ORDER_INVOICE_DONE(3);
	
	private int type;
	
	private GenericMessageType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
