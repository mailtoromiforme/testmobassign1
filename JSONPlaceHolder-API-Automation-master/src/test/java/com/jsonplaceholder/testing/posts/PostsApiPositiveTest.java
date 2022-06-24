package com.jsonplaceholder.testing.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.jsonplaceholder.testing.BaseTest;

import net.minidev.json.JSONObject;
@Tag("Posts")
@Tag("Positive")
public class PostsApiPositiveTest extends BaseTest{
	
	@Test
	public void testGetByUserIDFunctionalityOfPostsAPI() {
		posts.getResponseByUserID("3").then().assertThat().statusCode(200);
		List<Integer> userIdList =posts.getListOfValuesOfUserIDInResponse();
		userIdList.stream().forEach(userId -> assertEquals(userId,3));
	}
	
	@Test
	public void testGetByPostIDReturnsUniqueRecordOfPostsAPI() {
		posts.getResponseByPostID("1").then().assertThat().statusCode(200);
		List<Integer> userIdList =posts.getListOfValuesOfPostIDInResponse();
		assertEquals(1,userIdList.size());
	}
	
	@Test
	public void testPostFunctionalityOfPostsAPI() {
		JSONObject request= jsonReader.parseJson("posts");
		posts.postRequest(request).then().assertThat().statusCode(201);
	}

}
