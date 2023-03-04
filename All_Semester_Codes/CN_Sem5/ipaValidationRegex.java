//validating an IP address using Regular Expression or ReGex

import java.util.regex.*;
import java.util.*;  

class Cn6a{

	static String findClass(String str){
		// Calculating first occurrence of '.' in str
		int index = str.indexOf('.');
		// First octate in str in decimal form
		String ipsub = str.substring(0,index);
		int ip = Integer.parseInt(ipsub);
		// Class A
		if (ip>=1 && ip<=126)
			return "A";
		// Class B
		else if (ip>=128 && ip<=191)
			return "B";
		// Class C
		else if (ip>=192 && ip<223)
			return "C";
		// Class D
		else if (ip >=224 && ip<=239)
			return "D";
		// Class E
		else
			return "E";
	}
	static void separate(String str, String ipClass){
		// Initializing network and host empty
		String network = "", host = "";

		if(ipClass == "A"){
			int index = str.indexOf('.');
			network = str.substring(0,index);
			host = str.substring(index+1,str.length());
		}else if(ipClass == "B"){
			//Position of breaking network and HOST id
			int index = -1;
			int dot = 2;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='.'){
					dot -=1;
					if(dot==0){
						index = i;
						break;
					}
				}
			}
			network = str.substring(0,index);
			host = str.substring(index+1,str.length());
		}else if(ipClass == "C"){
			//Position of breaking network and HOST id
			int index = -1;
			int dot = 3;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)=='.'){
					dot -=1;
					if(dot==0){
						index = i;
						break;					
					}
				}
			}
			network = str.substring(0,index);
			host = str.substring(index+1,str.length());
		}else if(ipClass == "D" || ipClass == "E"){
			System.out.println("In this Class, IP address"+
			" is not divided into Network and Host IDs");
			return;
		}
		System.out.println("Network ID: "+network+"\n");
		System.out.println("Host ID: "+host+"\n");
	}
	// Function to validate the IPs address.
	public static boolean isValidIPAddress(String ip)
	{

		// Regex for digit from 0 to 255.
		String zeroTo255
			= "(\\d{1,2}|(0|1)\\"
			+ "d{2}|2[0-4]\\d|25[0-5])";

		// Regex for a digit from 0 to 255 and
		// followed by a dot, repeat 4 times.
		// this is the regex to validate an IP address.
		String regex
			= zeroTo255 + "\\."
			+ zeroTo255 + "\\."
			+ zeroTo255 + "\\."
			+ zeroTo255;

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		// If the IP address is empty
		// return false
		if (ip == null) {
			return false;
		}

		// Pattern class contains matcher() method
		// to find matching between given IP address
		// and regular expression.
		Matcher m = p.matcher(ip);

		// Return if the IP address
		// matched the ReGex
		return m.matches();
	}





	// Driver code
	public static void main(String args[])
	{
Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
System.out.print("\nEnter an IPv4 Address: ");  
String str= sc.nextLine();  


// TO CHECK VALIDITY OF IPV4 ADDRESS
	if (isValidIPAddress(str)){
	    System.out.println(str+ " is a valid IPv4 Address.");

	
	// TO CALCULATE SUBNET MASK
	String checkclass = str.substring(0, 3);
        int cc = Integer.parseInt(checkclass);
        String mask = null;
        if(cc>0 && cc<224)
        {
            if(cc<128)
            {
                mask = "255.0.0.0";
            }
            if(cc>127 && cc<192)
            {
                mask = "255.255.0.0";
            }
            if(cc>191)
            {
                mask = "255.255.255.0";
            }
        }
        System.out.println("\nsubnet mask: "+mask);

        // String networkAddr="";
        // String[] ipAddrParts=str.split("\\.");
        // String[] maskParts=mask.split("\\.");

        // for(int i=0;i<4;i++){
        // int x=Integer.parseInt(ipAddrParts[i]);
        // int y=Integer.parseInt(maskParts[i]);
        // int z=x&y;
        // networkAddr+=z+".";
        // }
       //System.out.println("\naddress: "+networkAddr+"\n");
    
    
String ipClass = findClass(str);
		System.out.println("\nGiven IP address belongs to Class : "+ipClass+"\n");
		separate(str,ipClass);
	
    
    
    
	}
	else {
	    System.out.println(str+" is an invalid IPv4 Address.\n");
	}
	
	
	
	}
}
		