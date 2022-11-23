package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mon database table.
 * 
 */
@Entity
@NamedQuery(name="Mon.findAll", query="SELECT m FROM Mon m")
public class Mon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="hoc_ky")
	private int hocKy;

	@Column(name="so_tin_chi")
	private int soTinChi;

	private String ten;

	public Mon() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHocKy() {
		return this.hocKy;
	}

	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}

	public int getSoTinChi() {
		return this.soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}