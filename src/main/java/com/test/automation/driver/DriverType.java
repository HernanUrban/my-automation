package com.test.automation.driver;

/**
 * Driver type enumerator.
 * 
 * @author hernan.urban
 * 
 */
public enum DriverType {

	FIREFOX("firefox"),
	CHROME("chrome"),
	IE("ie"),
	SAFARI("safari"),
	OPERA("opera"),
	UNKNOWN("unknown");

	private String name;

	private DriverType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the driver type for a given name.
	 * 
	 * @param name
	 *            the driver type name.
	 * @return the driver type.
	 */
	public static DriverType fromValue(String name) {
		for (DriverType value : DriverType.values()) {
			if (value.getName().equalsIgnoreCase(name)) {
				return value;
			}
		}
		return DriverType.UNKNOWN;
	}

}
