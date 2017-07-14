package com.anish.core.controller;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anish.core.entity.Screen;
import com.anish.core.entity.Theater;
import com.anish.core.model.ConfigureModel;

@Controller
public class ConfigureController {
	private static Logger log=Logger.getLogger(ConfigureController.class);
	@RequestMapping("ConfigureTheater")
	public String configure(){
		
		return "ConfigureTheater";
	}
	
	@RequestMapping(value="configure", method=RequestMethod.POST)
	public ModelAndView configure(@RequestParam("theaterName") String theaterName,
							@RequestParam("screens") String screens,
							@RequestParam("rows") String rows,
							@RequestParam("seats") String seats) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Map<String, Integer> numbers=new LinkedHashMap<String,Integer>();
		ModelAndView view=null;
		int rowint=Integer.parseInt(rows);
		int seatint=Integer.parseInt(seats);
		int screenint=Integer.parseInt(screens);
		boolean modelResult=false;
		log.info("theatername : "+theaterName);
		log.info("screens : "+screenint);
		log.info("row : "+rowint);
		log.info("seat : "+seatint);
		
			
			ConfigureModel model=new ConfigureModel();
			
			Theater theater=new Theater();
			
			Screen screen=new Screen();
			screen.setNoOfRows(rowint);
			screen.setNoOfSeats(seatint);
			
			theater.setTheaterName(theaterName);
			theater.setNoOfScreens(screenint);
			theater.setScreen(screen);
			
			try{
				modelResult=model.addTheater(theater);
				log.info("modelResult in configController : "+modelResult);
			}catch(Exception e){e.printStackTrace();}
			if(modelResult){
				
				view = new ModelAndView("Booking");
				numbers.put("rows", rowint);
				view.addObject("theaterName",theaterName);
				view.addObject("rows",rowint);
				view.addObject("seats",seatint);
				view.addObject("screens",screenint);	
			
			}else{
				
				view = new ModelAndView("Error");
				view.addObject("AddTheaterResult", modelResult);
			}	
		
		
		return view;
	}
	
	public ModelAndView booking(){
		
		ModelAndView view=new ModelAndView("Booking");
		/*ConfigureModel model=new ConfigureModel();*/
		
		return view;
	}
}
 