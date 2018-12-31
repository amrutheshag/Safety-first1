package com.test;



import org.testng.annotations.Test;

import generics.DataDriven;

public class ambi {
	@Test
	public void testme(){
	String XLPATH="./TestData/input.xlsx";
	int rc=DataDriven.getRowCount(XLPATH,"Screens");
	for(int i=1;i<=rc;i++)
	{
		String values=DataDriven.getCellValue(XLPATH,"Screens",i,1);
		System.out.println(values);
	}
}	

}
