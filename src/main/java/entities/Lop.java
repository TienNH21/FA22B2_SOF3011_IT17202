package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lop database table.
 * 
 */
@Entity
@NamedQuery(name="Lop.findAll", query="SELECT l FROM Lop l")
public class Lop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

//	@Column(name="chuyen_nganh_id")
//	private int chuyenNganhId;
	// https://shareprogramming.net/diem-khac-nhau-giua-lazy-va-eager-trong-hibernate-va-jpa/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chuyen_nganh_id")
	private ChuyenNganh chuyenNganh;

	private int khoa;

	@Column(name="mon_id")
	private int monId;

	private String ten;

	public Lop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getKhoa() {
		return this.khoa;
	}

	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}

	public int getMonId() {
		return this.monId;
	}

	public void setMonId(int monId) {
		this.monId = monId;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}