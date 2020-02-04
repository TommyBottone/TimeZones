package com.timezones.countries.TimeZones;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TimeZoneCommandLineRunner implements CommandLineRunner
{	
	private static final Logger log = 
			LoggerFactory.getLogger(TimeZoneCommandLineRunner.class);
	@Autowired
	private TimeZoneDBService dbService;
	
	
	@Override
	public void run(String... arg0) throws Exception
	{
		log.info("Start TimeZoneCommandLineRunner");
		List<Country> countries = CreateCountryData();
		if(countries != null)
		{
			for(Country country : countries)
			{
				dbService.insert(country);
				
			}
		}
		List<Country> c = dbService.findAll();
		if(!countries.isEmpty())
		{
			for(Country country : c)
			{
				System.out.println(country.toString());
			}
		}
	}
	
	//Create country data from data file
	public static List<Country> CreateCountryData()
	{
		List<Country> countries = new ArrayList<Country>();
		
		String fileName = "data/countryList.txt";
		
		File file = new File(fileName);
		try
		{
			if(!file.exists())
			{
				return null;
			}
			
			Scanner reader = new Scanner(file);
			while(reader.hasNext())
			{
				String line = reader.nextLine();
				//We know... okay we're pretty sure the first line will be a country and the number of how many timezones
				//using the delim of = we expect our first line to be country=#
				String[] splitLine = line.split("=");
				String countryName = "temp";
				if(splitLine.length == 2)
				{
					List<TimeZoneEnum> timeZones = new ArrayList<TimeZoneEnum>();
					countryName = splitLine[0];
					int numOfTimeZones = Integer.parseInt(splitLine[1].trim());
					if(numOfTimeZones < 0)
					{
						continue;
					}
					else
					{
						for(int i = 0 ; i  < numOfTimeZones; i++)
						{
							if(reader.hasNext())
							{
								String utc = reader.nextLine().trim();
								
								TimeZoneEnum tz = Country.StringToTimeZone(utc);
								if(tz == null)
								{
									continue;
								}
								else
								{
									timeZones.add(tz);
								}
							}
						}
						Country country = new Country();
						country.setCountryName(countryName);
						country.setTimeZones(timeZones);
						countries.add(country);
					}
				}
				else
				{
					continue;
				}				
			}
			reader.close();
		}
		catch(Exception x)
		{
			x.printStackTrace();
		}
		finally
		{
		}
		return countries;
	}
	
}
