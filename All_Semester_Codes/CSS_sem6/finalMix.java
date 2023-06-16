import java.util.*;
class temp{
 int depth;

 public static final String Alphabet = "abcdefghijklmnopqrstuvwxyz";
// EncryptData : Additive Encryption
// Encryption : Rail Fence Encryption

    public static String encryptData(String input, int shift){
        input = input.toLowerCase();
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
        return encryptStr;
    }

    //                                  DECRYPTION 
    public static String decryptData(String input, int shift){
        input = input.toLowerCase();
            
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
        return decryptStr;
    }

 String Encryption(String plainText,int depth)throws Exception
 {

    
  int r=depth,len=plainText.length();
  int c=len/depth;
  char mat[][]=new char[r][c];
  int k=0;
 
  String cipherText="";
 
  for(int i=0;i< c;i++)
  {
   for(int j=0;j< r;j++)
   {
    if(k!=len)
     mat[j][i]=plainText.charAt(k++);
    else
     mat[j][i]='X';
   }
  }
  for(int i=0;i< r;i++)
  {
   for(int j=0;j< c;j++)
   {
    cipherText+=mat[i][j];
   }
  }
  return cipherText;
 }
 
 
 String Decryption(String cipherText,int depth)throws Exception
 {
  int r=depth,len=cipherText.length();
  int c=len/depth;
  char mat[][]=new char[r][c];
  int k=0;
 
  String plainText="";
 
 
  for(int i=0;i< r;i++)
  {
   for(int j=0;j< c;j++)
   {
    mat[i][j]=cipherText.charAt(k++);
   }
  }
  for(int i=0;i< c;i++)
  {
   for(int j=0;j< r;j++)
   {
    plainText+=mat[j][i];
   }
  }
 
  return plainText;
 }
}

class finalMix{
 public static void main(String args[])throws Exception
 {
  temp rf=new temp();
                Scanner scn=new Scanner(System.in);
                int depth;
 
                String plainText,cipherText,decryptedText;
                
                System.out.println("\n\nENCRYPTION \n\n");

                System.out.println("Enter P : ");
                plainText=scn.nextLine();
               
                System.out.println("Enter depth for Encryption using railfence: ");
                depth=scn.nextInt();
               


  cipherText=rf.Encryption(plainText,depth);
  System.out.println("Encrypted text using Railfence is:\n"+cipherText);


  System.out.println("Enter shift For Additive Cipher: ");
  int shift = scn.nextInt();

  cipherText=rf.encryptData(cipherText,shift);
  System.out.println("final Encrypted Data using Additive ===> "+cipherText);   


  System.out.println("\n\nDECRYPTION \n\n");

  decryptedText=rf.decryptData(cipherText,shift);
  System.out.println(" cipher text after decryption of additive ===> "+decryptedText);   

  decryptedText=rf.Decryption(decryptedText, depth);
  System.out.println(" final cipher text after decryption of railfence ===> "+decryptedText+"\n\n");         

 
 }
}
