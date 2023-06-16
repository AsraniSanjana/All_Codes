import java.util.Scanner;

public class additiveCipher {
   
    public static final String Alphabet = "abcdefghijklmnopqrstuvwxyz";

    //                                       ENCRYPTION
    public static String encryptData(String input, int shift){
        input = input.toLowerCase();
       

        System.out.print("      P |    ");
        
        for(int i = 0; i < input.length(); i++){  
            System.out.printf("%-15s\t",input.charAt(i)) ;  }         


        String encryptStr = "";
        
        if(input==" "){
            encryptStr+=" ";
        }
        
        for(int i = 0;i<input.length();i++){
            int position = Alphabet.indexOf(input.charAt(i));
            int encryptPos = (shift+position)%26;
            char encryptChar = Alphabet.charAt(encryptPos);
            encryptStr += encryptChar;
            
        }
        System.out.println();
        // %32s%10d%16s"
        System.out.print("   V(P) |    ");
        for(int i = 0; i < encryptStr.length(); i++){  
            System.out.printf("%-15s\t",Alphabet.indexOf(input.charAt(i)) ); }

        System.out.println();
        System.out.print("    P+K |   ");
        for(int i = 0; i < encryptStr.length(); i++){  
            System.out.printf("%-15s\t",(shift+Alphabet.indexOf(input.charAt(i)) )); }

        System.out.println();
        System.out.print("   V(C) |   ");
        for(int i = 0; i < encryptStr.length(); i++){  
            System.out.printf("%-15s\t",(shift+Alphabet.indexOf(input.charAt(i)))%26 ); }    


        System.out.println();
        System.out.print("      C |     ");
        for(int i = 0; i < encryptStr.length(); i++){  
            System.out.printf("%-15s\t",encryptStr.charAt(i) ); }
            System.out.println();
        return encryptStr;
    }

    //                                  DECRYPTION 
    public static String decryptData(String input, int shift){
        input = input.toLowerCase();

        System.out.println();
        System.out.print("   C |   ");
        
        for(int i = 0; i < input.length(); i++){  
            System.out.printf("%-15s\t",input.charAt(i) ); }

            
       
        // HERE INPUT WILL BE THE ALREADY ENCRYPTED STRING
        String decryptStr = "";
        for(int i = 0;i<input.length();i++){
            int position = Alphabet.indexOf(input.charAt(i));
            int decryptPos = (position-shift)%26;
            if(decryptPos<0){
                decryptPos = Alphabet.length() + decryptPos;
            }
            char decryptChar = Alphabet.charAt(decryptPos);
            decryptStr += decryptChar;
        }
       

        System.out.println();
        System.out.print("V(C) |    ");
        for(int i = 0; i < decryptStr.length(); i++){  
            System.out.printf("%-15s\t",Alphabet.indexOf(input.charAt(i)) ); }

        System.out.println();
        System.out.print("C-K  |    ");
        for(int i = 0; i < decryptStr.length(); i++){  
            System.out.printf("%-15s\t",(Alphabet.indexOf(input.charAt(i))-shift) ); }   


        System.out.println();
        System.out.print("V(P) |    ");
        for(int i = 0; i < decryptStr.length(); i++){  
            System.out.printf("%-15s\t",(Alphabet.indexOf(input.charAt(i))-shift)%26 ); }
            
        

            System.out.println();
            System.out.print("P    |    ");
            for(int i = 0; i < decryptStr.length(); i++){  
                System.out.printf("%-15s\t",decryptStr.charAt(i) ); }
                System.out.println();
        return decryptStr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string for encryption using Caesar Cipher: ");
        String input = sc.nextLine();
        System.out.println("Enter shift: ");
        int shift = Integer.valueOf(sc.nextLine());
        System.out.println();
        System.out.println();
        System.out.println("Encrypted Data ===> "+encryptData(input, shift));   
        System.out.println();


        
        // System.out.println("Decrypted Data ===> "+decryptData(encryptData(input, shift), shift));
        System.out.println("Encrypted Data ===> "+decryptData(input, shift));   


        
        sc.close();
    }

}

