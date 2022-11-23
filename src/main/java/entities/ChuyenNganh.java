package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chuyen_nganh database table.
 * 
 */
@Entity
@Table(name="chuyen_nganh")
@NamedQuery(name="ChuyenNganh.findAll", query="SELECT c FROM ChuyenNganh c")
public class ChuyenNganh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="ten")
	private String ten;

	public ChuyenNganh() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}