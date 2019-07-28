import java.io.IOException;

public class App_v2 {
	public static DBConnection connection;
	public static CSVReader[] reader;

	public static void main(String[] args) throws IOException {
		int numberOfFiles = 1;
		String fileName = "a";
		connection = new DBConnection();// connect to the DB
		FileImporter importer = new FileImporter();

		for (int i = 1; i <= numberOfFiles; i++) // for opening more than one file
		{
			fileName = fileName+ i + ".csv";
			importer.importFileToPostgresqlDB(fileName);// Initialize Connection and the desired CSV file
		}

		// close connection
		App_v2.connection.closeConnection();
		System.out.println(
				FileImporter.importedItemCounter + " Files sucssesfully imported!" + "\n" + "connection is closed!");

	}
}
