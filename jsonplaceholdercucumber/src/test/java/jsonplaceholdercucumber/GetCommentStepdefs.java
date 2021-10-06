package jsonplaceholdercucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

/**
 * @author sercansensulun on 6.10.2021.
 */
public class GetCommentStepdefs extends StepDefinitions{


    public GetCommentStepdefs(StepData stepData) throws IOException {
        super(stepData);
    }

    @Then("e-mail formats are correct in the comments")
    public void eMailFormatsAreCorrectInTheComments() {
    }

    @When("all comments are retrieved for each post")
    public void allCommentsAreRetrievedForEachPost() {

    }

    @Given("there is an user has {string} username")
    public void thereIsAnUserHasUsername(String arg0) {
    }

    @And("there are posts written by test user")
    public void thereArePostsWrittenByTestUser() {
    }

    @Then("e-mail values are matched with the users in the comments")
    public void eMailValuesAreMatchedWithTheUsersInTheComments() {
    }

    @Then("name values are not empty in the comments")
    public void nameValuesAreNotEmptyInTheComments() {
    }

    @Then("all id values are different from each other in the comments")
    public void allIdValuesAreDifferentFromEachOtherInTheComments() {
    }

    @Then("all postId values are same and matched with the post in the comments")
    public void allPostIdValuesAreSameAndMatchedWithThePostInTheComments() {
    }
}
