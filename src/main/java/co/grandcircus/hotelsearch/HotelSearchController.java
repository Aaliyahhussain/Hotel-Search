package co.grandcircus.hotelsearch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.hotelsearch.dao.*;

@Controller
public class HotelSearchController {

	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	
	@RequestMapping("/results")
	public ModelAndView summary(@RequestParam(name="city") String city) {
		ModelAndView mv = new ModelAndView("results");
		mv.addObject("city", city);
		mv.addObject("hotelList", hotelDao.findByCity(city));
		return mv;
	}
	
	@RequestMapping("/name")
	public ModelAndView name(@RequestParam(name="name") String name) {
		ModelAndView mv = new ModelAndView("results");
		mv.addObject("hotelList", hotelDao.findByName(name));
		
		return mv;
	}
		
	@RequestMapping("/price")
	public ModelAndView price(@RequestParam(name="price", required=false) Integer pricePerNight) {
		ModelAndView mv = new ModelAndView("results");
		mv.addObject("hotelList", hotelDao.findByPriceMax(pricePerNight));
		return mv;	

	}
	
}

//@RequestMapping("/results")
//public ModelAndView showResults(@RequestParam("city") String city, @RequestParam("pricePerNight") Integer pricePerNight) {
//	ArrayList<Hotel> hotelList = (ArrayList<Hotel>) hotelDao.findByCity(city);
//	ModelAndView mv = new ModelAndView("results");
//	Collections.sort(hotelList, (h1, h2) -> h1.getPricePerNight().compareTo(h2.getPricePerNight()));
//	mv.addObject("city", city);
//	mv.addObject("pricePerNight", pricePerNight);
//	
//	if (pricePerNight!=null) {
//		Stream<Hotel> hotelsUnderBudget = hotelList.stream().filter(h -> h.getPricePerNight() <= pricePerNight);
//		 ArrayList<Hotel> hotelList2 = (ArrayList<Hotel>) hotelsUnderBudget.collect(Collectors.toList());
//		 mv.addObject("hotels", hotelList2);
//	}
//	else {
//	mv.addObject("hotels", hotelList );
//	}
//	
//	return mv;
//}