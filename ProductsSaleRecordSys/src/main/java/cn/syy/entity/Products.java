package cn.syy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Mathartsys
 * time:2017-3-20
 *
 */

@XmlRootElement(name = "products")
public class Products implements Serializable{
	
	private int soldId;
	
	private String proName;
	
	private String soldTime;
	
	private int soldNum;
	
	private String price;
    
    private String purchaser;
    
    private int proId;
	
	private Date proTime;
	
	private String proType;
	
	private String remark;
        
	public int getSoldId() {
		return soldId;
	}

	public void setSoldId(int soldId) {
		this.soldId = soldId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getSoldTime() {
		return soldTime;
	}

	public void setSoldTime(String soldTime) {
		this.soldTime = soldTime;
	}

	public int getSoldNum() {
		return soldNum;
	}

	public void setSoldNum(int soldNum) {
		this.soldNum = soldNum;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String twoDecimalPrice) {
		this.price = twoDecimalPrice;
	}

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	
//	4-26
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public Date getProTime() {
		return proTime;
	}

	public void setProTime(Date proTime) {
		this.proTime = proTime;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Products [soldId=" + soldId + ", proName=" + proName
				+ ", soldTime=" + soldTime + ", soldNum=" + soldNum
				+ ", price=" + price + ", purchaser=" + purchaser + "]";
	}
}
