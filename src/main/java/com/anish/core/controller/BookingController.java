package com.anish.core.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anish.core.model.BookingModel;
import com.anish.core.statePattern.PaymentContext;
import com.anish.core.statePattern.Paypal;

@Controller
public class BookingController {
	
	private static Logger log=Logger.getLogger(BookingController.class);
	@RequestMapping("booking")
	public String movieName(){
		
		
		return "Booking";
	}
	
	@RequestMapping(value="display", method=RequestMethod.POST)
	public ModelAndView display(@RequestParam  Map<String,String> values) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		int screenNo= Integer.parseInt(values.get("screenId"));
		log.info("ScreenId : "+screenNo);
		
		ModelAndView view=new ModelAndView("SelectSeat");
		BookingModel model=new BookingModel();
		Map<String, Boolean> rowsAndSeats= model.getRowsAndSeats(screenNo);
		view.addObject("rowsAndSeats",rowsAndSeats);
		view.addObject("screen", screenNo);
		log.info(rowsAndSeats.get("A1"));
		
		return view;
	}
	
	@RequestMapping(value="bookSeats", method=RequestMethod.POST)
	public ModelAndView bookSeat(@RequestParam("seatNo") String rowAndSeat, 
								@RequestParam("screenId") String screenId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		List<String> seatlist=new ArrayList<String>();
		BookingModel model=new BookingModel();
		ModelAndView view=null;
		int screenNo=Integer.parseInt(screenId);
		log.info("rowAndSeat"+rowAndSeat);
		String[] split=rowAndSeat.split(",");
		int len=split.length;
		int price=10 * len;
		for(int i=0;i<=split.length-1;i++){
			
			seatlist.add(split[i]);
			
		}
		log.info("Total price for tickets : $"+price+"/-");
		
		boolean bookSeat=model.bookSeats(split,screenNo);	
		
		if(bookSeat){
			
			view=new ModelAndView("Payment");
			view.addObject("bookedSeats",seatlist);
			view.addObject("price", price);
			view.addObject("screenId", screenNo);
		}else{
			
			view=new ModelAndView("Error");
			view.addObject("bookingSeats", "reserve seats error");
		}
		return view;
	}
	
	@RequestMapping(value="payment",method=RequestMethod.POST)
	public synchronized ModelAndView paymentMethod(@RequestParam("acc_no") String acc_no,
											 @RequestParam("password") String password,
											 @RequestParam("screenId") String screenId,
											 @RequestParam("SeatNo") String bookedSeats,
											 @RequestParam("totalPrice") int totalPrice) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		
		ModelAndView view=null;
		String confirmationNo= screenId+acc_no;
		/*int price=Integer.parseInt(totalPrice);*/
		int screenNo=Integer.parseInt(screenId);
		BookingModel bookTickets= new BookingModel();
		PaymentContext context=new PaymentContext();
		context.setAcc_no(acc_no);
		context.setPassword(password);
		context.setAmount(totalPrice);
		Paypal paypal=new Paypal();
		log.info("account no : "+context.getAcc_no());
		
		
		boolean paymentResult=paypal.update(context);
		
		if(paymentResult){
			boolean isBooked=bookTickets.bookTickets(screenNo, confirmationNo, totalPrice, bookedSeats);
				if(isBooked){
					view=new ModelAndView("Confirmation");
					view.addObject("accNo", acc_no);
					view.addObject("paymentResult", paymentResult);
					view.addObject("confirmationNumber", confirmationNo);
				}else{
					view=new ModelAndView("Error");
					view.addObject("ticketBooking", "ticketBooking Error");
				}
		}else{
			view=new ModelAndView("Error");
			view.addObject("error", "payment not succes");
		}
		
		return view;
	}
}
