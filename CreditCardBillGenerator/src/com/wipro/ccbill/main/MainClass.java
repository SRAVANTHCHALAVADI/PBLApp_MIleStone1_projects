package com.wipro.ccbill.main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

import com.wipro.ccbill.entity.CreditCardBill;
import com.wipro.ccbill.entity.Transaction;

public class MainClass {
	public static void main(String[] args) {
		try{
		      Transaction monthsTransaction[] = new Transaction[15];
		      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		     /*
		      monthsTransaction[0]=new Transaction("1111222233334444",formatter.parse("01/02/2016"),"household",8000.0,"DB");
		      monthsTransaction[1]=new Transaction("1111222233334444",formatter.parse("05/02/2016"),"Textile",12000.0,"EMI");
		      monthsTransaction[2]=new Transaction("1111222233334444",formatter.parse("12/02/2016"),"movie",2700.0,"EMI");
		      monthsTransaction[3]=new Transaction("1111222233334444",formatter.parse("16/02/2016"),"paid",19000.0,"CR");
		      monthsTransaction[4]=new Transaction("1111222233334444",formatter.parse("19/02/2016"),"household",4500.0,"DB");
		     */
		     
		      
		      FileReader fr =new FileReader("D:\\eclipse workspace\\CreditCardBillGenerator\\src\\TransactionDetails.txt");
		      BufferedReader br=new BufferedReader(fr);
		      
		      for(int i=0;i<15;i++)
		      {
		      String str=br.readLine();
		      String []str1=str.split(",");
		      monthsTransaction[i].setCreditCardNo(str1[0]);
		      monthsTransaction[i].setDateOfTransaction(formatter.parse(str1[1]));
		      monthsTransaction[i].setTransactionDesc(str1[2]);
		      monthsTransaction[i].setTransactionAmount(Double.parseDouble(str1[3]));
		      monthsTransaction[i].setTransactionType(str1[4]);
		      

		      }
		      fr.close();
		      br.close();


		      
		      
		      CreditCardBill ccbill = new CreditCardBill("1111222233334444","ABC123","PREMIUM",formatter.parse("02/03/2016"),monthsTransaction);
		      
		      System.out.println("Total to be paid : "+ccbill.calculateBillAmount());
		      ccbill = new CreditCardBill("1111111111111111","ABC123","PREMIUM",formatter.parse("02/03/2016"),monthsTransaction);
		      
		      System.out.println("Total to be paid : "+ccbill.calculateBillAmount());
		      ccbill = new CreditCardBill("2222222222222222","ABC123","PREMIUM",formatter.parse("02/03/2016"),monthsTransaction);
		      
		      System.out.println("Total to be paid : "+ccbill.calculateBillAmount());
		      }
		catch(Exception e){}
	}

}

