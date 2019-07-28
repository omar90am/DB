

//import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CSVReader {

	private static List<CSVFile> csvFileList = new LinkedList<CSVFile>();
	private static String file;
	
	public CSVReader(String file) {
		CSVReader.file = file;
	}

	public List<CSVFile> csvReader()
		{
			BufferedReader br;
			String line;
			try {
				br = new BufferedReader(new FileReader(new File(file)));System.out.println("the File <"+file+"> is exsixt");
				br.readLine(); System.out.println("Start Reading file successful !");
				while ((line = br.readLine()) != null) {	 
					fullAddressObject(line);
						}
				} catch (IOException e) {
					System.out.println("\nFile Not found !\n");
					System.out.println("\nPlease check the file Name !\n");
						
						}
			return csvFileList;
		}
	public void fullAddressObject(String line)
	{
		String[] strArray = line.split(",");
		CSVFile csvFile = new CSVFile();
		DateFormatter dFormatter = new DateFormatter();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		csvFile.setId(Integer.parseInt(strArray[0]));
		csvFile.setAddress(strArray[1]);
		csvFile.setDistrict(strArray[2]);
		csvFile.setCity_id(Integer.parseInt(strArray[3]));
		csvFile.setPostal_code(Integer.parseInt(strArray[4]));
		try {
			csvFile.setLast_update(dFormatter.formateDate(formatter.parse(strArray[5])));
		} catch (ParseException e) {
			System.out.println("Date Format converting error");
		}
		csvFileList.add(csvFile);
	}
}