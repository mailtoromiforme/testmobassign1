package com.jsonplaceholder.testing;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("FreeNowApiChallenge")
public class FreeNowApiChallengeTest extends BaseTest{
	
protected static Logger LOG = Logger.getLogger(FreeNowApiChallengeTest.class);
	
	@Test
	@DisplayName("Validate the format of Emails in comments section for all posts of a user")
	public void testValidateFormatOfEmailsInCommentsSectionForAllPostsOfAUser() {
		users.getResponseByUserName("Samantha");
		List<Integer> userIdList= users.getListOfValuesOfIDInResponse();
		for(Integer userId: userIdList) {
			posts.getResponseByUserID(userId.toString());
			List<Integer> postIdList = posts.getListOfValuesOfUserIDInResponse();
			
			for(Integer PostId: postIdList) {
				comments.getResponseByPostID(PostId.toString());
				List<String> emails= comments.getListOfValuesOfEmailsInResponse();
				emails.stream().forEach(email->softAssert.assertThat(comments.isValid(email)).isTrue());
				softAssert.assertAll();
			}
		}
		
	}

}
