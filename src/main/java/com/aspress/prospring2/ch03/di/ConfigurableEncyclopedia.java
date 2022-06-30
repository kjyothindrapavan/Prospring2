package com.aspress.prospring2.ch03.di;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

public class ConfigurableEncyclopedia implements Encyclopedia {
	private Map<String,Long> entryValues;
	
	public ConfigurableEncyclopedia(Map<String,Long> entries) {
		Assert.notNull(entries, "The 'entries' argument cannot be null.");
		this.entryValues = entries;
	}
	
	@Override
	public Long findLong(String entry) {
		return this.entryValues.get(entry);
	}
}
