package org.sid.Application.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.sid.Application.Interfaces.ShipmentInterface;

public class ShipmentModel implements ShipmentInterface{
	
	private final int RandomStarter = 100000;
	private int counter = 1;
	
	public ShipmentModel() {}
	
	@Override
	public double capAmountCalculator(double declaredValue, double capRate) {
		return  declaredValue*capRate;
	}
	@Override
	public String ourTrackingNumberGenerator() {
		
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyyMM");  
        String today = dateFormat.format(date);  
		String enterpriseName = "OH";
		String randomNumber = String.valueOf(RandomStarter+counter);
		counter = counter+1;
		String ourTrackingNumber = enterpriseName + today + randomNumber;
	    
	    return ourTrackingNumber;

	}

}
