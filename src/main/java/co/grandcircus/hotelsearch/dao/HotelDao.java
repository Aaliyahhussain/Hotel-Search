package co.grandcircus.hotelsearch.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.hotelsearch.entity.Hotel;



@Repository
@Transactional
public class HotelDao {
	
	@PersistenceContext
	EntityManager em;

	public Set<String> findAllCities() {
		List<String> cityList = em.createQuery("SELECT DISTINCT city FROM Hotel", String.class)
				.getResultList();
		return new TreeSet<>(cityList);
	}
	
	public List<Hotel> findByCity(String city) {
		try {
			return em.createQuery("FROM Hotel WHERE city = :city", Hotel.class)
					.setParameter("city", city)
					.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
		
		
	}
	
	public List<Hotel> findByName(String name) {
		try {
			return em.createQuery("FROM Hotel WHERE name = :name", Hotel.class)
					.setParameter("name", name)
					.getResultList();
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public List<Hotel> findByPriceMax(Integer pricePerNight) {
		return em.createQuery("FROM Hotel WHERE pricePerNight >= :price", Hotel.class)
				.setParameter("price", pricePerNight)
				.getResultList();
		
	}
	
	

}


