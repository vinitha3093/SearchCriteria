package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class csvSearchCriteria {
	public static void main(String args[]) {
		String line = "";  
		String splitBy = ",";  
		try {
			File resourceFile = new File("./ProgrammingAssignment.csv");
			List<SearchCriteriaNEW> objList = new ArrayList<SearchCriteriaNEW>();
			BufferedReader br = new BufferedReader(new FileReader(resourceFile));  
			while ((line = br.readLine())!=null) {  
				   String[] eachObj = line.split(splitBy);
				   SearchCriteriaNEW csvObject = new SearchCriteriaNEW();
				   csvObject.setId(eachObj[0]);
				   csvObject.setBankName(eachObj[1]);
				   csvObject.setType(eachObj[2]);
				   csvObject.setCity(eachObj[3]);
				   csvObject.setState(eachObj[4]);
				   csvObject.setZipCode(eachObj[5]);
				   objList.add(csvObject);
			}
			Map<String, String> paramsMap = new HashMap<>();
			if(args.length>0) {
				for(String header:args) {
					paramsMap.put(header.split("=")[0], header.split("=")[1]);
				}
			}
			List<SearchCriteriaNEW> matchedData = objList.stream()
		            .filter(paramsMap.get("Bank Name")!=null ? c -> c.getBankName().equalsIgnoreCase(paramsMap.get("Bank Name")): c-> true)
		            .filter(paramsMap.get("Type")!=null ? c -> c.getType().equalsIgnoreCase(paramsMap.get("Type")): c-> true)
		            .filter(paramsMap.get("City")!=null ? c -> c.getCity().equalsIgnoreCase(paramsMap.get("City")): c-> true)
		            .filter(paramsMap.get("State")!=null ? c -> c.getState().equalsIgnoreCase(paramsMap.get("State")): c-> true)
		            .filter(paramsMap.get("Zip code")!=null ? c -> c.getZipCode().equalsIgnoreCase(paramsMap.get("Zip code")): c-> true)
		            .collect(Collectors.toList());
			if(matchedData.size()>0) {
				System.out.println("Bank Name, Type, City, State, Zip code");
				for(SearchCriteriaNEW eachObj: matchedData) {
					System.out.println(eachObj.getBankName()+","+eachObj.getType()+","+eachObj.getCity()+","+eachObj.getState()+","+eachObj.getZipCode());
				}
			} else {
				System.out.println("No search criteria found");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
       
	}

}
 class SearchCriteriaNEW {
	String Id;
	String BankName;
	String Type;
	String City;
	String State;
	String ZipCode;

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
}