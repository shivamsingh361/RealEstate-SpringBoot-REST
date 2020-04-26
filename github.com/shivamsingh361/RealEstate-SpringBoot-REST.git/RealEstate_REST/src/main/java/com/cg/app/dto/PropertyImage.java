package com.cg.app.dto;


import java.util.Arrays;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="property_image")
//@AllArgsConstructor
//@Data
//@NoArgsConstructor
//@ToString
public class PropertyImage {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Lob
	@Column(name = "pic")
	private byte[] pic;
	
	@Column(name = "prop_id")
	private long propId;
	
	public PropertyImage() {
		super();
	}

	//Custom Construtor


	public Long getId() {
		return id;
	}

	public long getPropId() {
		return propId;
	}

	public void setPropId(long propId) {
		this.propId = propId;
	}

	public PropertyImage(String name, String type, byte[] pic, long propId) {
		super();
		this.name = name;
		this.type = type;
		this.pic = pic;
		this.propId = propId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "PropertyImage [id=" + id + ", name=" + name + ", type=" + type + ", pic="
		+ (pic != null ? Arrays.toString(Arrays.copyOf(pic, Math.min(pic.length, maxLen))) : null) + "]";
	}
}