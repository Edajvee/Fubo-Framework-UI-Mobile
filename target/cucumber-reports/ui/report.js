$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/ui/FuboHomePage.feature");
formatter.feature({
  "name": "",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on \"https://www.fubo.tv/welcome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "FuboLoginSteps.user_is_on(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test Login functionality",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.step({
  "name": "user clicks \"sign in\" button",
  "keyword": "Given "
});
formatter.match({
  "location": "FuboLoginSteps.user_clicks_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters correct credentials",
  "keyword": "When "
});
formatter.match({
  "location": "FuboLoginSteps.user_enters_correct_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "if needed user chooses a profile under \"https://www.fubo.tv/profiles\"",
  "keyword": "And "
});
formatter.match({
  "location": "FuboLoginSteps.if_needed_user_chooses_a_profile_under(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be logged into their account under \"https://www.fubo.tv/home\"",
  "keyword": "Then "
});
formatter.match({
  "location": "FuboLoginSteps.user_should_be_logged_into_their_account_under(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat ui.steps.FuboLoginSteps.user_should_be_logged_into_their_account_under(FuboLoginSteps.java:58)\n\tat ✽.user should be logged into their account under \"https://www.fubo.tv/home\"(src/test/resources/ui/FuboHomePage.feature:9)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});