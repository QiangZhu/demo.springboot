package rabbitmq.ha.domain;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -5810415223475626164L;
	
	private Long id;
	private String uuid;
	private String description;
	private OrderType type;

	public Order(Long id, String uuid, String description, OrderType type) {
		this.id = id;
		this.uuid = uuid;
		this.description = description;
		this.type = type;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("Order[id=%d,uuid=%s,desc=%s, type=%s]",id,uuid,description,type);
	}
}