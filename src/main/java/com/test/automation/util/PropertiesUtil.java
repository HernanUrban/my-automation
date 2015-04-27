package com.test.automation.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Handles the application properties.
 * 
 * @author hernan.urban
 * 
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer {
	private static Map<String, String> propertiesMap;

	private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

	@Override
	public void setSystemPropertiesMode(int systemPropertiesMode) {
		super.setSystemPropertiesMode(systemPropertiesMode);
		springSystemPropertiesMode = systemPropertiesMode;
	}

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		super.processProperties(beanFactory, props);

		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String valueStr = resolvePlaceholder(keyStr, props,
					springSystemPropertiesMode);
			propertiesMap.put(keyStr, valueStr);
		}
	}

	/**
	 * Retrieves the value of a given property name.
	 * 
	 * @param name
	 *            the property name.
	 * @return the value of the property.
	 */
	public String getProperty(String name) {
		return getProperty(name, null);
	}

	/**
	 * Retrieves the value of a given property name.
	 * 
	 * @param name
	 *            The property name.
	 * @param defaultValue
	 *            the default value to return if property does not exist.
	 * @return The value of the property or the default value if property des
	 *         not exist.
	 */
	public String getProperty(String name, String defaultValue) {
		return propertiesMap.get(name) != null ? propertiesMap.get(name)
				.toString() : defaultValue;
	}
}