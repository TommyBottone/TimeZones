package com.timezones.countries.TimeZones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TimeZoneDBService
{
	@PersistenceContext
	private EntityManager entityManager;

	public int insert(Country country)
	{
		entityManager.persist(country);
		return country.getId();
	}

	public Country save(Country country)
	{
		entityManager.persist(country);
		return country;
	}
	
	public List<Country> findAll() 
	{
		List<Country> countries = new ArrayList<Country>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Country> cq = cb.createQuery(Country.class);
		Root<Country> rootEntry = cq.from(Country.class);
		CriteriaQuery<Country> all = cq.select(rootEntry);
		TypedQuery<Country> allQuery = entityManager.createQuery(all);
		countries = allQuery.getResultList();
		
		/*
		 * I really don't know why this needs to be here
		 */
		try
		{
			for(Country c : countries)
			{
				System.out.println(c.toString());
			}
		}
		catch(Exception e)
		{
		}
		return countries;
	}

	public Country findById(int id)
	{
		return entityManager.find(Country.class, id);
	}

	public void deleteById(int id)
	{
		Country c = findById(id);
		entityManager.remove(c);
	}
	
	public void updateCountryById(Country newCountry, int id)
	{
		Country country = findById(id);
		if(country == null)
		{
			save(newCountry);
		}
		else
		{
			entityManager.remove(country);
			newCountry.setId(id);
			entityManager.persist(newCountry);
		}
	}
}
