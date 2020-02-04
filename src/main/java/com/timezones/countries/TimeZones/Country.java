package com.timezones.countries.TimeZones;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
@Entity
@Table
public class Country {

	@Id
	@GeneratedValue
	private int _id;
	private String _countryName;
	@ElementCollection
	private List<TimeZoneEnum> _timeZones = new ArrayList<TimeZoneEnum>();
	private int _defaultTimeZone;
	//Constructor
	/**
	 * 
	 * @param countryName
	 * @param timeZones
	 */
	public Country( String countryName, List<TimeZoneEnum> timeZones)
	{
		super();
		setCountryName(countryName);
		setTimeZones(timeZones);
		setDefaultTimeZone(0);
	}
	//Constructor
	/**
	 * Default
	 */
	protected Country()
	{
		super();
	}

	//setId
	/**
	 * 
	 * @param int id
	 */
	public void setId(int id)
	{
		this._id = id;
	}
	
	//setCountryName
	/**
	 * 
	 * @param string countryName
	 */
	public void setCountryName(String countryName)
	{
		this._countryName = countryName;
	}
	//setTimeZones
	/**
	 * 
	 * @param List<TIME_ZONES> timeZones
	 */
	public void setTimeZones(List<TimeZoneEnum> timeZones)
	{
		this._timeZones = timeZones;
	}

	//setDefaultTimeZone
	/**
	 * 
	 * @param int index
	 */
	public void setDefaultTimeZone(int index)
	{
		if(index <= 0 || index > this._timeZones.size())
		{
			index = 0;
		}
		this._defaultTimeZone = index;
	}
	//GetId
	/**
	 * @return int - _id
	 */
	public int getId()
	{
		return this._id;
	}
	//getCountryName
	/**
	 * 
	 * @return String -countryName
	 */
	public String getCountryName()
	{
		return this._countryName;
	}
	//getTimeZones
	/**
	 * 
	 * @return List<TIME_ZONES> - timeZones
	 */
	public List<TimeZoneEnum> getTimeZones()
	{
		return this._timeZones;
	}

	//getDefaultTimeZoneIndex
	/**
	 * 
	 * @return int _defaultTimeZone
	 */
	public int getDefaultTimeZoneIndex()
	{
		return this._defaultTimeZone;
	}

	//getDefaultTimeZone
	/**
	 * 
	 * @return Country TimeZone[DefaultTimeZone]
	 */
	public TimeZoneEnum getDefaultTimeZone()
	{
		return this._timeZones.get(_defaultTimeZone);
	}
	
	//ToString
	@Override
	public String toString()
	{
		String str = "Country Name: " + _countryName + "\n";
		int iter = 0;
		if(_timeZones == null)
		{
			return str;
		}
		try
		{
			for(TimeZoneEnum timeZone : this._timeZones)
			{
				if(iter == this._defaultTimeZone)
				{
					str += "*"; 
				}
				str += "TimeZone: " + TimeZoneToString(timeZone) + "\n"; 
				iter++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}

	public static TimeZoneEnum StringToTimeZone(String str)
	{
		TimeZoneEnum retVal = null;
		if     (str.compareToIgnoreCase("UTC+01:00") == 0) {retVal = TimeZoneEnum.UTC_P01;}  
		else if(str.compareToIgnoreCase("UTC+02:00") == 0) {retVal = TimeZoneEnum.UTC_P02;}
		else if(str.compareToIgnoreCase("UTC+03:00") == 0) {retVal = TimeZoneEnum.UTC_P03;}
		else if(str.compareToIgnoreCase("UTC+03:30") == 0) {retVal = TimeZoneEnum.UTC_P0330;}
		else if(str.compareToIgnoreCase("UTC+04:00") == 0) {retVal = TimeZoneEnum.UTC_P04;}
		else if(str.compareToIgnoreCase("UTC+04:30") == 0) {retVal = TimeZoneEnum.UTC_P0430;}
		else if(str.compareToIgnoreCase("UTC+05:00") == 0) {retVal = TimeZoneEnum.UTC_P05;}
		else if(str.compareToIgnoreCase("UTC+05:30") == 0) {retVal = TimeZoneEnum.UTC_P0530;}
		else if(str.compareToIgnoreCase("UTC+05:45") == 0) {retVal = TimeZoneEnum.UTC_P0545;}
		else if(str.compareToIgnoreCase("UTC+06:00") == 0) {retVal = TimeZoneEnum.UTC_P06;}
		else if(str.compareToIgnoreCase("UTC+06:30") == 0) {retVal = TimeZoneEnum.UTC_P0630;}
		else if(str.compareToIgnoreCase("UTC+07:00") == 0) {retVal = TimeZoneEnum.UTC_P07;}
		else if(str.compareToIgnoreCase("UTC+08:00") == 0) {retVal = TimeZoneEnum.UTC_P08;}
		else if(str.compareToIgnoreCase("UTC+08:45") == 0) {retVal = TimeZoneEnum.UTC_P0845;}
		else if(str.compareToIgnoreCase("UTC+09:00") == 0) {retVal = TimeZoneEnum.UTC_P09;}
		else if(str.compareToIgnoreCase("UTC+09:30") == 0) {retVal = TimeZoneEnum.UTC_P0930;}
		else if(str.compareToIgnoreCase("UTC+10:00") == 0) {retVal = TimeZoneEnum.UTC_P10;}
		else if(str.compareToIgnoreCase("UTC+10:30") == 0) {retVal = TimeZoneEnum.UTC_P1030;}
		else if(str.compareToIgnoreCase("UTC+11:00") == 0) {retVal = TimeZoneEnum.UTC_P11;}
		else if(str.compareToIgnoreCase("UTC+12:00") == 0) {retVal = TimeZoneEnum.UTC_P12;}
		else if(str.compareToIgnoreCase("UTC+12:45") == 0) {retVal = TimeZoneEnum.UTC_P1245;}
		else if(str.compareToIgnoreCase("UTC+13:00") == 0) {retVal = TimeZoneEnum.UTC_P13;}
		else if(str.compareToIgnoreCase("UTC+13:45") == 0) {retVal = TimeZoneEnum.UTC_P1345;}
		else if(str.compareToIgnoreCase("UTC+14:00") == 0) {retVal = TimeZoneEnum.UTC_P14;}
		else if(str.compareToIgnoreCase("UTC+00:00") == 0) {retVal = TimeZoneEnum.UTC_P00;}  
		else if(str.compareToIgnoreCase("UTC-01:00") == 0) {retVal = TimeZoneEnum.UTC_M01;}
		else if(str.compareToIgnoreCase("UTC-02:00") == 0) {retVal = TimeZoneEnum.UTC_M02;}
		else if(str.compareToIgnoreCase("UTC-02:30") == 0) {retVal = TimeZoneEnum.UTC_M0230;}
		else if(str.compareToIgnoreCase("UTC-03:00") == 0) {retVal = TimeZoneEnum.UTC_M03;}
		else if(str.compareToIgnoreCase("UTC-03:30") == 0) {retVal = TimeZoneEnum.UTC_M0330;}
		else if(str.compareToIgnoreCase("UTC-04:00") == 0) {retVal = TimeZoneEnum.UTC_M04;}
		else if(str.compareToIgnoreCase("UTC-05:00") == 0) {retVal = TimeZoneEnum.UTC_M05;}
		else if(str.compareToIgnoreCase("UTC-06:00") == 0) {retVal = TimeZoneEnum.UTC_M06;}
		else if(str.compareToIgnoreCase("UTC-07:00") == 0) {retVal = TimeZoneEnum.UTC_M07;}
		else if(str.compareToIgnoreCase("UTC-08:00") == 0) {retVal = TimeZoneEnum.UTC_M08;}
		else if(str.compareToIgnoreCase("UTC-09:00") == 0) {retVal = TimeZoneEnum.UTC_M09;}
		else if(str.compareToIgnoreCase("UTC-09:30") == 0) {retVal = TimeZoneEnum.UTC_M0930;}
		else if(str.compareToIgnoreCase("UTC-10:00") == 0) {retVal = TimeZoneEnum.UTC_M10;}
		else if(str.compareToIgnoreCase("UTC-11:00") == 0) {retVal = TimeZoneEnum.UTC_M11;}
		else if(str.compareToIgnoreCase("UTC-12:00") == 0) {retVal = TimeZoneEnum.UTC_M12;}
		return retVal;
	}
	public static String TimeZoneToString(TimeZoneEnum tz)
	{
		String retVal = "";
		switch(tz)
		{
		case UTC_P01  :{ retVal = "UTC +01"; break;}
		case UTC_P02  :{ retVal = "UTC +02"; break;}
		case UTC_P03  :{ retVal = "UTC +03"; break;}
		case UTC_P0330:{ retVal = "UTC +0330"; break;}
		case UTC_P04  :{ retVal = "UTC +04"; break;}
		case UTC_P0430:{ retVal = "UTC +0430"; break;}
		case UTC_P05  :{ retVal = "UTC +05"; break;}
		case UTC_P0530:{ retVal = "UTC +0530"; break;}
		case UTC_P0545:{ retVal = "UTC +0545"; break;}
		case UTC_P06  :{ retVal = "UTC +06"; break;}
		case UTC_P0630:{ retVal = "UTC +0630"; break;}
		case UTC_P07  :{ retVal = "UTC +07"; break;}
		case UTC_P08  :{ retVal = "UTC +08"; break;}
		case UTC_P0845:{ retVal = "UTC +0845"; break;}
		case UTC_P09  :{ retVal = "UTC +09"; break;}
		case UTC_P0930:{ retVal = "UTC +0930"; break;}
		case UTC_P10  :{ retVal = "UTC +10"; break;}
		case UTC_P1030:{ retVal = "UTC +1030"; break;}
		case UTC_P11  :{ retVal = "UTC +11"; break;}
		case UTC_P12  :{ retVal = "UTC +12"; break;}
		case UTC_P1245:{ retVal = "UTC +1245"; break;}
		case UTC_P13  :{ retVal = "UTC +13"; break;}
		case UTC_P1345:{ retVal = "UTC +1345"; break;}
		case UTC_P14  :{ retVal = "UTC +14"; break;}
		case UTC_P00  :{ retVal = "UTC 00"; break;}
		case UTC_M01  :{ retVal = "UTC -01"; break;}
		case UTC_M02  :{ retVal = "UTC -02"; break;}
		case UTC_M0230:{ retVal = "UTC -0230"; break;}
		case UTC_M03  :{ retVal = "UTC -03"; break;}
		case UTC_M0330:{ retVal = "UTC -0330"; break;}
		case UTC_M04  :{ retVal = "UTC -04"; break;}
		case UTC_M05  :{ retVal = "UTC -05"; break;}
		case UTC_M06  :{ retVal = "UTC -06"; break;}
		case UTC_M07  :{ retVal = "UTC -07"; break;}
		case UTC_M08  :{ retVal = "UTC -08"; break;}
		case UTC_M09  :{ retVal = "UTC -09"; break;}
		case UTC_M0930:{ retVal = "UTC -0930"; break;}
		case UTC_M10  :{ retVal = "UTC -10"; break;}
		case UTC_M11  :{ retVal = "UTC -11"; break;}
		case UTC_M12  :{ retVal = "UTC -12"; break;}
		default:
			retVal = "broken";
			break;
		}
		
		return retVal;
	}
}

