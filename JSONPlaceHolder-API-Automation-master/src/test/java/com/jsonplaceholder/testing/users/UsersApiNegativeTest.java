package com.jsonplaceholder.testing.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.jsonplaceholder.testing.BaseTest;

@Tag("Users")
@Tag("Negative")
public class UsersApiNegativeTest extends BaseTest{
	
	@Test
	public void testNoRecordPresentForGivenUserName() {
		users.getResponseByUserName("samantha").then().assertThat().statusCode(200);
		List<Integer> userIdList =users.getListOfValuesOfIDInResponse();
		assertEquals(0,userIdList.size());
	}
}
