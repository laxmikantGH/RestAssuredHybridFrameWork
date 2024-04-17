package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String [][] AllData(){
		
		String fName="C:\\Users\\DELL\\eclipse-workspace\\MavenProjectRestAssuredFramework\\testData\\testData.xlsx";
		
		int row=ReadExcelFile.getRowCount(fName, "Data");
		int col=ReadExcelFile.getColumnCount(fName, "Data");
		
		
		String data [][]=new String [row-1][col];
		
		for(int i=1;i<row;i++) {
			
			for(int j=0;j<col;j++) {
				
				data [i-1][j]=ReadExcelFile.getCellValue(fName, "Data", i, j);
				
			}
			
		}
		
		return data;
		
		
	}
	
	@DataProvider(name="UserNameData")
	public String [] UserNamesData(){
		
		String fName="C:\\Users\\DELL\\eclipse-workspace\\MavenProjectRestAssuredFramework\\testData\\testData.xlsx";
		
		int TotalRowCount=ReadExcelFile.getRowCount(fName, "Data");
		//int TotalColumnCount=ReadExcelFile2.columnCount(fName, "Data");
		
		String userNamedata []=new String[TotalRowCount-1];
		
		for(int i=1;i<TotalRowCount;i++) {
			
			userNamedata[i-1]=ReadExcelFile.getCellValue(fName, "Data", i, 2);
		}
		
		return userNamedata;
	}
	
	
	
	
	
	
	
	
	

}
