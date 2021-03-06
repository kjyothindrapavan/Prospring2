package com.aspress.prospring2.ch03.di;

public class BookWormOracle implements Oracle {
	private Encyclopedia encyclopedia;

	@Override
	public String defineMeaningOfLife() {
		Long ageOfUniverse = this.encyclopedia.findLong("AgeOfUniverse");
		Long constantOfLife = this.encyclopedia.findLong("ConstantOfLife");
		
		return String.valueOf(ageOfUniverse/constantOfLife);
	}
	
	public void setEncyclopedia(Encyclopedia encyclopedia) {
		this.encyclopedia = encyclopedia;
	}
}
