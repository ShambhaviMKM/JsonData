package service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import model.Laureates;
import model.NoblePrize;
import model.Prize;

@Service
public class UserService {

	//By name
		public Prize SearchUserByName(String firstname) throws IOException{
			Prize prize = null;
			Gson gson = new Gson();
			ObjectMapper objectmapper = new ObjectMapper();
			NoblePrize noblePrize = objectmapper.readValue(new File("Json.txt"), NoblePrize.class);
			List<Prize> prizes = noblePrize.getPrizes();
			for(Prize user1 : prizes) {
				for(Laureates laureates : user1.getLaureates()) {
					if(firstname.equalsIgnoreCase(laureates.getFirstname())) {
						prize = user1;
						System.out.println(gson.toJson(prize));
					}
				}
			}
			return prize;
			
		}
			//by year
			public List<Prize> SearchByYear(int year) throws IOException{
			List<Prize> prizesList = new ArrayList<>();
			Gson gson = new Gson();
			ObjectMapper objectmapper = new ObjectMapper();
			NoblePrize noblePrize = objectmapper.readValue(new File("Json.txt"), NoblePrize.class);
			List<Prize> prizes = noblePrize.getPrizes();
			for(Prize user1 : prizes) {
				if(String.valueOf(user1.getYear()).equalsIgnoreCase(String.valueOf(year))) {
					prizesList.add(user1);
					System.out.println(gson.toJson(prizesList));
				}
			}
			return prizesList;
			
		}
			
			
			//retrieves user based on year and category
			public Prize SearchUserByYearAndCategory(@PathVariable int year, @PathVariable String category) throws IOException, ParseException{
				Prize finalUser = null;
				ObjectMapper objectmapper = new ObjectMapper();
				NoblePrize noblePrize = objectmapper.readValue(new File("Json.txt"), NoblePrize.class);
				Gson gson = new Gson();
				List<Prize> prizes = noblePrize.getPrizes();
				for(Prize user1 : prizes) {
					if(user1.getCategory().equalsIgnoreCase(category) && String.valueOf(user1.getYear()).equalsIgnoreCase(String.valueOf(year))) {
						finalUser = user1;
						System.out.println(gson.toJson(finalUser));
					}
				}
				return finalUser;
			}
			
			public void ShowListInAlphabeticalOrder(int year, String category) throws IOException{
				Prize prize = null;
				ObjectMapper objectmapper = new ObjectMapper();
				NoblePrize noblePrize = objectmapper.readValue(new File("Json.txt"), NoblePrize.class);
				List<Prize> prizes = noblePrize.getPrizes();
				List<String> laureatesPersonList = new ArrayList<>();
				for(Prize user1 : prizes) {
					if(user1.getCategory().equalsIgnoreCase(category) && String.valueOf(user1.getYear()).equalsIgnoreCase(String.valueOf(year))) {
						prize = user1;
					}
				}
				for(Laureates p : prize.getLaureates()) {
					laureatesPersonList.add(p.getFirstname());
				}
				Collections.sort(laureatesPersonList);	
				System.out.println(laureatesPersonList);
			}


}
