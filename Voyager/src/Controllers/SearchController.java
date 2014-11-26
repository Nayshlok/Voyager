package Controllers;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LocationModel;
import models.ModelAndView;
import services.DataService;
import services.DatabaseAccess;


public class SearchController {
	
	private DataService dataService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String filePath;
	
	public SearchController(HttpServletRequest request, HttpServletResponse response, DataService dataService, String filePath) {
		this.request = request;
		this.response = response;
		this.dataService = dataService;
		this.filePath = filePath;
	}
	
	public ModelAndView Search(){
		ModelAndView model;
		LocationModel loc= dataService.retrieveLocation(request.getParameter("search"));
		if(loc==null){
			model= new ModelAndView(loc, request.getContextPath()+ "idex");
		}
		model= new ModelAndView(loc, request.getContextPath()+"loc/"+loc.getID());
		return model;
	}

	public LocationModel DatabaseSearch(String search){
		search = search.toUpperCase();
		
		String[] arr = search.split(" ");    
		LocationModel loc;
		if(arr.length==1){
			loc = StateSearch(search);
		}else if(arr.length<5){
			 loc = NonAddressSearch(search);
		 }
		 else{
			 loc = AddressSearch(search);			 
		 }
		return loc;
	}
	
	private LocationModel StateSearch(String search) {
		LocationModel loc;
		search.trim();
		if(search.length()<2){
			Map<String,String> states = new HashMap<String,String>();
			states.put("AL", "ALABAMA");
			states.put("AK", "ALASKA");
			states.put("AZ", "ARIZONA");
			states.put("AR", "ARKANSAS");
			states.put("CA", "CALIFORNIA");
			states.put("CO", "COLORADO");
			states.put("CT", "CONNECTICUT");
			states.put("DE", "DELAWARE");
			states.put("FL", "FLORIDA");
			states.put("GA", "GEORGIA");
			states.put("HI", "HAWAII");
			states.put("ID", "IDAHO");
			states.put("IL", "ILLINOIS");
			states.put("IN", "INDIANA");
			states.put("IA", "IOWA");
			states.put("KS", "KANSAS");
			states.put("KY", "KENTUCKY");
			states.put("LA", "LOUISIANA");
			states.put("ME", "MAINE");
			states.put("MD", "MARYLAND");
			states.put("MA", "MASSACHUSETTS");
			states.put("MI", "MICHIGAN");
			states.put("MN", "MINNESOTA");
			states.put("MS", "MISSISSIPPI");
			states.put("MO", "MISSOURI");
			states.put("MT", "MONTANA");
			states.put("NE", "NEBRASKA");
			states.put("NV", "NEVADA");
			states.put("NH", "NEW HAMPSHIRE");
			states.put("NJ", "NEW JERSEY");
			states.put("NM", "NEW MEXICO");
			states.put("NY", "NEW YORK");
			states.put("NC", "NORTH CAROLINA");
			states.put("ND", "NORTH DAKOTA");
			states.put("OH", "OHIO");
			states.put("OK", "OKLAHOMA");
			states.put("OR", "OREGON");
			states.put("PA", "PENNSYLVANIA");
			states.put("RI", "RHODE ISLAND");
			states.put("SC", "SOUTH CAROLINA");
			states.put("SD", "SOUTH DAKOTA");
			states.put("TN", "TENNESSEE");
			states.put("TX", "TEXAS");
			states.put("UT", "UTAH");
			states.put("VT", "VERMONT");
			states.put("VA", "VIRGINIA");
			states.put("WA", "WASHINGTON");
			states.put("WV", "WEST VIRGINIA");
			states.put("WI", "WISCONSIN");
			states.put("WY", "WYOMING");
			search = states.get(search);
			loc = dataService.retrieveLocation(search);
		}
		else{
			loc = dataService.retrieveLocation(search);
		}
		
		
		return loc;
	}
	private LocationModel AddressSearch(String search) {
		int index = search.indexOf("-");
		if(index>0){
			search = search.substring(0, index);
		}
		LocationModel loc = dataService.retrieveLocation(search);
		return loc;
		
	}
	private LocationModel NonAddressSearch(String arr) {
		return dataService.retrieveLocation(arr);
		
	}
}
