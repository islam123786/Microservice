package com.islam.MovieCatalogservice.resources;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.islam.MovieCatalogservice.models.CatelogItem;
import com.islam.MovieCatalogservice.models.Rating;
import com.islam.MovieCatalogservice.service.MovieInfo;
import com.islam.MovieCatalogservice.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {	
	@Autowired
	WebClient.Builder builder;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo ratingInfo;
	
    @RequestMapping("/{userId}")
    public List<CatelogItem> getCatelog(String userId){
    	List<CatelogItem> list = new ArrayList<>();
    	List<Rating> ratings = ratingInfo.getUserRating(userId);    	
    	for (int i = 0; i < ratings.size(); i++) {
    		//Mono - reactive way of saying that you will get an object in future
    		//Movie movie = builder.build().get().uri("http://localhost:8082/movies/"+ratings.get(i).getMovieId()).retrieve().bodyToMono(Movie.class).block();    		
    		list.add(movieInfo.getCatelogItem(ratings.get(i)));
		}
    	return list;
    }    
    
}
