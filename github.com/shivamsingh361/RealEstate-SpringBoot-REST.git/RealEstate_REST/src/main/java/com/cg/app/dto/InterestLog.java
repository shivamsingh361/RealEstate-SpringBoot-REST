package com.cg.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* DB Schema:
 * 
 * CREATE TABLE intrest_log(
 * user_id varchar(40) not null,
 * timestamp datetime not null,
 * intrested_city varchar(40),
 * prop_id int(10) not null);
*/

@Entity
@Table(name="interest_log")
public class InterestLog{
	@Column(name="user_id")
	private String userId;
	/*
	 * java.util.Date dt = new java.util.Date(); java.text.SimpleDateFormat sdf =
	 * new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String currentTime =
	 * sdf.format(dt);
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "id")
	private long id;
	@Column(name = "time_stamp")
	private String timestamp;
	@Column(name="intrested_city")
	private String city;
	@Column(name="prop_id")
	private int propId;
	public InterestLog(String userId, String timestamp, String city, int propId) {
		super();
		this.userId = userId;
		this.timestamp = timestamp;
		this.city = city;
		this.propId = propId;
	}

	/*
	 * public InterestLog(String userId, String city, int propId) { super();
	 * this.userId = userId; this.timestamp = Date.from( LocalDateTime.now().atZone(
	 * ZoneId.systemDefault()).toInstant()); this.city = city; this.propId = propId;
	 * }
	 */
	public InterestLog() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}

}
