package com.mstore.model;

public class CartMessage {

	private MessageType type;
	private String sessionId;
	private int count;

	public enum MessageType {
		EMPTY, USING, COUNTER
	}

	public MessageType getType() {
		return type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	
}
