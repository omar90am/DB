public class FileImporter {
	public static int importedItemCounter=0;
	private CSVReader reader;
	public void importFileToPostgresqlDB (String fileName) {
		
	reader = new CSVReader(fileName);//open the desired file;
	
	//Some PostgreSQL Commands
	String sql;
	String truncate = "Truncate address;";
	String drop = "Drop Table public.address;";
	String create = "CREATE TABLE address (\r\n" + 
			"	specialidPrimaryKey integer NOT NULL,\r\n" + 
			"	id integer NOT NULL,\r\n" + 
			"	address character varying(255),\r\n" + 
			"	district character varying(255),\r\n" + 
			"	city_id int,\r\n" + 
			"	postal_code int,\r\n" + 
			"	last_update character varying(255),\r\n" + 
			"	PRIMARY KEY (specialidPrimaryKey));";
	String insert = " Insert into address(specialidPrimaryKey,id,address,district,city_id,postal_code,last_update)values(?,?,?,?,?,?,?);";
	
	
	for(CSVFile csvFile: reader.csvReader()){
		//initially create the table and inserting the first line
		if(importedItemCounter==0) 
		{ 
		sql = truncate+drop+create+insert;
		importedItemCounter++;
		App_v2.connection.createStatments(sql,importedItemCounter,csvFile.getId(),csvFile.getAddress(),csvFile.getDistrict(),csvFile.getCity_id(),csvFile.getPostal_code(),csvFile.getLast_update());
		System.out.println("Table is created!");
		System.out.println("Please wait...Start importing the Data to the DB :)");}
		
		else //Inserting to the table till the end of the files
		{
			sql =insert;
			importedItemCounter++; 
			//push a statement to the query with the values
			App_v2.connection.createStatments(sql,importedItemCounter,csvFile.getId(),csvFile.getAddress(),csvFile.getDistrict(),csvFile.getCity_id(),csvFile.getPostal_code(),csvFile.getLast_update());
		}
		//Users massages
		userMsg();
	}
}
	private void userMsg() {
		//Users massages
		if (importedItemCounter==10000)System.out.println("Please wait...Already imported 10,0000 line of Data :)");
		if (importedItemCounter==100000)System.out.println("Please wait...Already imported 100,000 line of Data :)");
		if (importedItemCounter==250000)System.out.println("Please wait...Already imported 250,000 line of Data :)");
		if (importedItemCounter==500000)System.out.println("Please wait...Already imported 500,000 line of Data :)");
		if (importedItemCounter==750000)System.out.println("Please wait...Already imported 750,000 line of Data :)");
		if (importedItemCounter==1000000)System.out.println("Please wait...Already imported 1,000,000 line of Data :)...counting will be every 500,000");
		if (importedItemCounter==1500000)System.out.println("Please wait...Already imported 1,500,000 line of Data :)");
		if (importedItemCounter==2000000)System.out.println("Please wait...Already imported 2,000,000 line of Data :)");
		if (importedItemCounter==2500000)System.out.println("Please wait...Already imported 2,500,000 line of Data :)");
		if (importedItemCounter==3000000)System.out.println("Please wait...Already imported 3,000,000 line of Data :)");
		if (importedItemCounter==3500000)System.out.println("Please wait...Already imported 3,500,000 line of Data :)");
		if (importedItemCounter==4000000)System.out.println("Please wait...Already imported 4,000,000 line of Data :)...counting will be every 1,000,000");
		if (importedItemCounter==5000000)System.out.println("Please wait...Already imported 5,000,000 line of Data :)");
		if (importedItemCounter==6000000)System.out.println("Please wait...Already imported 6,000,000 line of Data :)");
		if (importedItemCounter==7000000)System.out.println("Please wait...Already imported 7,000,000 line of Data :)");
		if (importedItemCounter==8000000)System.out.println("Please wait...Already imported 8,000,000 line of Data :)");
		if (importedItemCounter==9000000)System.out.println("Please wait...Already imported 9,000,000 line of Data :)");
		if (importedItemCounter==10000000)System.out.println("Please wait...Already imported 10,000,000 line of Data :)...counting will be every 2,000,000");
		if (importedItemCounter==12000000)System.out.println("Please wait...Already imported 12,000,000 line of Data :)");
		if (importedItemCounter==14000000)System.out.println("Please wait...Already imported 14,000,000 line of Data :)");
		if (importedItemCounter==16000000)System.out.println("Please wait...Already imported 16,000,000 line of Data :)");
		if (importedItemCounter==18000000)System.out.println("Please wait...Already imported 18,000,000 line of Data :)");
		if (importedItemCounter==20000000)System.out.println("Please wait...Already imported 20,000,000 line of Data :)");
		if (importedItemCounter==22000000)System.out.println("Please wait...Already imported 22,000,000 line of Data :)");
		if (importedItemCounter==24000000)System.out.println("Please wait...Already imported 24,000,000 line of Data :)");
		if (importedItemCounter==26000000)System.out.println("Please wait...Already imported 26,000,000 line of Data :)");
		if (importedItemCounter==28000000)System.out.println("Please wait...Already imported 28,000,000 line of Data :)");
		if (importedItemCounter==30000000)System.out.println("Please wait...Already imported 30,000,000 line of Data :)");
		if (importedItemCounter==32000000)System.out.println("Please wait...Already imported 32,000,000 line of Data :)");
		if (importedItemCounter==34000000)System.out.println("Please wait...Already imported 34,000,000 line of Data :)");
		if (importedItemCounter==36000000)System.out.println("Please wait...Already imported 36,000,000 line of Data :)");
		if (importedItemCounter==38000000)System.out.println("Please wait...Already imported 38,000,000 line of Data :)");		
		if (importedItemCounter==40000000)System.out.println("Please wait...Already imported 40,000,000 line of Data :)...next count after 5 Million");
		if (importedItemCounter==45000000)System.out.println("Please wait...Already imported 45,000,000 line of Data :)...next count after 5 Million");
		if (importedItemCounter==50000000)System.out.println("Please wait...Already imported 50,000,000 line of Data :)...next count after 5 Million");		
		if (importedItemCounter==55000000)System.out.println("Please wait...Already imported 55,000,000 line of Data :)...next count after 5 Million");	
		if (importedItemCounter==60000000)System.out.println("Please wait...Already imported 60,000,000 line of Data :)...next count after 5 Million");		
		if (importedItemCounter==65000000)System.out.println("Please wait...Already imported 65,000,000 line of Data :)...next count after 5 Million");		
		if (importedItemCounter==70000000)System.out.println("Please wait...Already imported 70,000,000 line of Data :)...next count after 5 Million");
		if (importedItemCounter==75000000)System.out.println("Please wait...Already imported 75,000,000 line of Data :)...next count after 5 Million");	
		if (importedItemCounter==80000000)System.out.println("Please wait...Already imported 80,000,000 line of Data :)...next count after 5 Million");		
		if (importedItemCounter==85000000)System.out.println("Please wait...Already imported 85,000,000 line of Data :)...next count after 5 Million");		
		if (importedItemCounter==90000000)System.out.println("Please wait...Already imported 90,000,000 line of Data :)...next count after 5 Million");	
		if (importedItemCounter==95000000)System.out.println("Please wait...Already imported 95,000,000 line of Data :)...next count after 5 Million");		
		if (importedItemCounter==100000000)System.out.println("Please wait...Already imported 100,000,000 line of Data :)...no more counting till the end of the files");
	}
}
