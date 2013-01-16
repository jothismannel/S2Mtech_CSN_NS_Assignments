package jothis.otp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class OTPdec {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		int xor1 = 0,xor2;
	    
	    StringBuilder decrypt=new StringBuilder();
	    String hex,encrpt_data;
	    
	    int length = 0,bit_hex,bit_decypt;
	    char char_decypt[];
		char[] char_file_de;
		try
		{
			BufferedReader br_decrypt=new BufferedReader(new FileReader("/home/jothis/JMR/NetworkSecurity/otpetext"));
			encrpt_data=br_decrypt.readLine();
			br_decrypt.close();
		
			System.out.println("Encrypt message from file"+encrpt_data.toString());
		
			BufferedReader br_key=new BufferedReader(new FileReader("/home/jothis/JMR/NetworkSecurity/otpkey"));
			hex=br_key.readLine();
			br_key.close();
		
			System.out.println("key(decrption) from file"+hex.toString());
		
			char_decypt=hex.toCharArray();//key to char array
			char_file_de=encrpt_data.toCharArray();//encrypted data to array
		
			length=char_decypt.length-1;
		
			for (int idx = 0; idx <= length; ++idx)
			{
		     
				bit_decypt=char_file_de[idx];
				bit_hex=char_decypt[idx];
				if(bit_decypt>57)
				{
					bit_hex=bit_hex-48;
					// n=150-n;
					//n=n-48;
					if(bit_decypt==97)
					{
						bit_decypt=10;
					}else if(bit_decypt==98)
					{
						bit_decypt=11;
					}
					else if(bit_decypt==99)
					{
	    			   bit_decypt=12;
					}
					else if(bit_decypt==100)
					{
	    			   bit_decypt=13;
					}else if(bit_decypt==101)
					{
	    			   bit_decypt=14;
					}else if(bit_decypt==102)
					{
	    			   bit_decypt=15;
					}
	    		  	  
					decrypt.append(bit_decypt ^ bit_hex);
					continue;
				}//end of if
				bit_decypt=bit_decypt-48;
				bit_hex=bit_hex-48;
				xor1=bit_decypt & ~bit_hex;
				xor2=~bit_decypt & bit_hex;
				decrypt.append(xor1 | xor2);
	    	 
			}//end of for
		
			System.out.println("Decrypt"+decrypt.toString());
		 
		
		} 
			catch(IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
		}//end of class 
	  
	  
}//end of main


