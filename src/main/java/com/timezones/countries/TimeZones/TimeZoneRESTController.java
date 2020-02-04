package com.timezones.countries.TimeZones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "TimeZoneManager", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TimeZoneRESTController 
{
	@Autowired
	private TimeZoneDBService dbService;
	
	@GetMapping(value = "/countries")
	public List<Country> getAllCountries()
	{
		return dbService.findAll();
	}
	@GetMapping(value = "/countries/{id}")
	public Country getCountryById(@PathVariable int id)
	{
		return dbService.findById(id);
	}
	@PostMapping(value="/countries")
	public Country createCountry(@RequestBody Country newCountry)
	{
		return dbService.save(newCountry);
	}
	@DeleteMapping(value = "/countries/{id}")
	public void deleteCountry(@PathVariable int id)
	{
		dbService.deleteById(id);
	}

    @PutMapping("/countries/{id}")
    public Country updateCountries(@RequestBody Country newCountry, @PathVariable int id)
    {
 
    	dbService.updateCountryById(newCountry, id);
    	return newCountry;
    }

    @PutMapping("/countries/{countryId}/{timezoneId}")
    public Country updateCountryTimeZoneId(@PathVariable int countryId,@PathVariable int timezoneId) 
    {
    	Country country = dbService.findById(countryId);
    	country.setDefaultTimeZone(timezoneId);
    	dbService.updateCountryById(country, countryId);
    	return country;
    }
}
