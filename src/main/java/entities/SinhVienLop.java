package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sinh_vien_lop database table.
 * 
 */
@Entity
@Table(name="sinh_vien_lop")
@NamedQuery(name="SinhVienLop.findAll", query="SELECT s FROM SinhVienLop s")
public class SinhVienLop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="diem_tb")
	private double diemTb;

	@Column(name="lop_id")
	private int lopId;

	@Column(name="sinh_vien_id")
	private int sinhVienId;

	@Column(name="trang_thai")
	private int trangThai;

	public SinhVienLop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDiemTb() {
		return this.diemTb;
	}

	public void setDiemTb(double diemTb) {
		this.diemTb = diemTb;
	}

	public int getLopId() {
		return this.lopId;
	}

	public void setLopId(int lopId) {
		this.lopId = lopId;
	}

	public int getSinhVienId() {
		return this.sinhVienId;
	}

	public void setSinhVienId(int sinhVienId) {
		this.sinhVienId = sinhVienId;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}