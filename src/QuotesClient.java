import java.io.*;
import java.net.*;

public class QuotesClient {

	private static String SERVER_HOST = "localhost";
	private static int SERVER_PORT = 10001;

	public static void main(String[] args) {
	
		Socket cskt;
		try {
			cskt = new Socket(SERVER_HOST, SERVER_PORT);
			ObjectOutputStream oos = new ObjectOutputStream(cskt.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(cskt.getInputStream());
			
			oos.writeObject("get quote");
			String[] reply = (String[])ois.readObject();
			System.out.println(reply[0] + " -" + reply[1]);
			oos.close();
			ois.close();
			cskt.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
