package com.islam.RatingDataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.islam.RatingDataservice.models.Rating;
import com.islam.RatingDataservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("500", 4),
				new Rating("501", 5)
				);
		UserRating userRating = new UserRating(); 
		userRating.setUserRating(ratings);
		return userRating;
	}

}
