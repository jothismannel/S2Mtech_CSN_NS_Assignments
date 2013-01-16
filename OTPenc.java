package jothis.otp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class OTPenc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	    
	    StringBuilder encrypt=new StringBuilder();
	    String hex = null,mesg = null;
	    
	    int length = 0,bit_hex,bit_mesg;
	    char chara_encypt[];
		char[] chara_mesg;
		
		
		
		BufferedReader br = null;
		try 
		{
			br = new BufferedReader(new FileReader("/home/jothis/JMR/NetworkSecurity/otpkey"));
			BufferedReader br_mesg=new BufferedReader(new FileReader("/home/jothis/JMR/NetworkSecurity/otptext"));
			mesg=br_mesg.readLine();		//reading message from filr
		} //end of try
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //end of try
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of catch
		try 
		{
			hex=br.readLine();
		} //end of try
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end of catch
		System.out.println("Key from file "+hex);
		System.out.println("Message from file "+mesg);
		chara_encypt=hex.toCharArray();
		chara_mesg=mesg.toCharArray();
		
		
		if(chara_mesg.length==chara_encypt.length)
		{
			
			length=chara_encypt.length;
			for(int i=0;i<length;i++)
			{
				bit_hex=chara_encypt[i];
				bit_mesg=chara_mesg[i];
				bit_hex=bit_hex-48;
				bit_mesg=bit_mesg-48;
				hex=Integer.toHexString(bit_hex ^ bit_mesg);
				encrypt.append(hex);
			
			}//end of for
		
			System.out.println("Encrypt message"+encrypt.toString());
			BufferedWriter br_encrypt;
			try 
			{
				br_encrypt = new BufferedWriter(new FileWriter("/home/jothis/JMR/NetworkSecurity/otpetext"));
				br_encrypt.write(encrypt.toString());	//writing encrypted data
				br_encrypt.close();
			} 
			catch(IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end of if
		else
		{
			System.out.println("Key length and message length do no match");
		}//end of else
		
	}//end of class

}//end of main
