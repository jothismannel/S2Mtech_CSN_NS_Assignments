package jothis.otp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class OTPgen {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int START = 0,length;
		int END = 9;

		Random random = new Random();					//generate random numbers
		ArrayList<Integer> al_rand = new ArrayList<Integer>();
		

		StringBuilder sb_hex = new StringBuilder();

		String hex, mesg = null;

		try 
		{
			BufferedReader br_mesg = new BufferedReader(new FileReader(
					"/home/jothis/JMR/NetworkSecurity/otptext"));
			mesg = br_mesg.readLine();					//reading message from file
			length=mesg.length();
		} //end of try
		catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //end of catch
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of catch

		/*generating random numbers */
		for (int idx = 1; idx <= length; ++idx) 
		{

			long range = (long) END - (long) START + 1;
			long fraction = (long) (range * random.nextDouble());
			int randomNumber = (int) (fraction + START);
			al_rand.add(randomNumber);
			hex = Integer.toHexString(randomNumber);
			sb_hex.append(hex);
			
		}//end of for
		System.out.println("key" + al_rand.toString());

		System.out.println("Message" + mesg);
		System.out.println("key Hex value " + sb_hex.toString());

		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"/home/jothis/JMR/NetworkSecurity/otpkey"));
			bw.write(sb_hex.toString());				//writing the key to the file
			bw.close();
		} //end of try
		catch (IOException e) 
		{
			e.printStackTrace();
		}//end of catch

	}//end of class
}//end of main
