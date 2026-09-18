package tw.harry.hibernate.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oitem")
public class OrderItem {

	@Id
	private long id;
	
	@Column(nullable = false)
	private String pname;
	@Column(nullable = false)
	private int price;
	@Column(nullable = false)
	private int qty;
	
	public OrderItem() {}
	
	public OrderItem(String pname, int price, int qty) {
		super();
		this.pname = pname;
		this.price = price;
		this.qty = qty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	//---------------------------------
	@ManyToOne(fetch = FetchType.EAGER)
//	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oid", nullable = false)
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
