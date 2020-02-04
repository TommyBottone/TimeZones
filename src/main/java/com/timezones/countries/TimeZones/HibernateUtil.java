package com.timezones.countries.TimeZones;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
	private static SessionFactory _sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		SessionFactory retVal = null;
		try
		{
			if(_sessionFactory == null)
			{
				Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
				StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
				standardServiceRegistryBuilder.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
				retVal = configuration.buildSessionFactory(serviceRegistry);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			retVal = null;
		}
		
		return retVal;
	}
	
	public static SessionFactory getSessionFactory()
	{
		return _sessionFactory;
	}
	
	public static void shutdown()
	{
		getSessionFactory().close();
	}
}
