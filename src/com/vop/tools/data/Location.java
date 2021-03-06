package com.vop.tools.data;

import java.io.File;

/**
 * Represents a Location. It has a Point and extra information.
 * 
 * @author henridv
 * 
 */
public class Location extends Point {
	private final Integer id;
	private String name;
	private String date;
	private Integer pers_id;
	private File img;

	/**
	 * Create a Location with all fields. This constructor is only used when a
	 * location is retrieved from the database.
	 * 
	 * @param id
	 * @param name
	 * @param latitute
	 * @param longitude
	 * @param altitude
	 * @param date
	 * @param persId
	 */
	public Location(Integer id, String name, Double latitute, Double longitude,
			Double altitude, String date, Integer persId, File img) {
		super(latitute, longitude, altitude);
		this.id = id;
		this.name = name;
		this.date = date;
		this.pers_id = persId;
		this.img = img;
	}

	/**
	 * A location with no image.
	 * 
	 * @param name
	 * @param description
	 * @param latitute
	 * @param longitude
	 * @param altitude
	 * @param persId
	 */
	public Location(String name, Double latitute, Double longitude,
			Double altitude, Integer persId) {
		this(null, name, latitute, longitude, altitude, null, persId, null);
	}

	/**
	 * Create a Location with an image (photo)
	 * 
	 * @param name
	 * @param description
	 * @param latitude
	 * @param longitude
	 * @param altitude
	 * @param persId
	 * @param img
	 */
	public Location(String name, Double latitude, Double longitude,
			Double altitude, Integer persId, File img) {
		this(null, name, latitude, longitude, altitude, null, persId, img);
	}

	public String toString() {
		return this.name;
	}

	public String getDate() {
		return date;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getPersId() {
		return pers_id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersId(Integer persId) {
		pers_id = persId;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public File getImg() {
		return img;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Location) {
			return ((Location) o).getId().equals(this.id);
		} else {
			return super.equals(o);
		}
	}

}
