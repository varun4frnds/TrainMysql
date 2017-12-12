package web.com.ibm.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import web.com.ibm.bean.Passenger;
import web.com.ibm.bean.Train;
import web.com.ibm.controller.TrainController;
import web.com.ibm.dao.TrainDAO;

public class Ticket {
	
	static int counter=100;
	
	public TreeMap<Passenger,Double> CalcFare(String[] name, String[] age, String[] gender, double price2) {
		Ticket tk=new Ticket();
		TrainController td;
		
		Passenger p=new Passenger();
		String name1;
		String age1 ;
		char gender1 ;
		int agee;
		double totalfare=0;
		TreeMap<Passenger, Double> tm=new TreeMap<>();
		Set<Double> s = null;
		Iterator<Double> itr = null;
		double y=0;
		for(int i=0;i<name.length;i++)
		{
	    p=new Passenger();
		name1=name[i];
		p.setName(name1);
		System.out.println(name1);
		age1=age[i];
	    agee=Integer.parseInt(age1);
	    p.setAge(agee);
		System.out.println(agee);
		gender1=gender[i].charAt(0);
		p.setGender(gender1);
		System.out.println(gender1);
		double mapfare= tk.calcPassengerFare(agee, gender1, price2);
		/*totalfare=totalfare+mapfare;*/
		tm.put(p,mapfare);
		}
				return tm;
	}
	

public double calcPassengerFare(int age2, char gender2, double ticketPrice2) {
	double price=ticketPrice2;
    double fare;
	if(age2<=12)
	{
		fare = (price/100)*50;
	}
	else if(age2>=60)
	{
	   fare = (price/100)*60;

	}
	else if(gender2=='f')
	{
		fare = (price/100)*75;

	}
	else
	{
		fare = price;
	}
	
return fare;
}



public  String generatePNR(String source, String destination, Date date) throws ClassNotFoundException
{
	counter++;
	 char first=source.charAt(0);
	 char second=destination.charAt(0);
	   	Date date1=date;
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date1);
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    
	    String pnr=""+first+second+"_"+year+month+day+"_"+counter;
	    return pnr;
}

}