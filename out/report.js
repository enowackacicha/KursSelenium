$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("google-textsearch.feature");
formatter.feature({
  "line": 1,
  "name": "Google search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "user can search any keyword",
  "description": "",
  "id": "google-search;user-can-search-any-keyword",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "an open browser with google.com",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a keyword selenium is entered in input field",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the first one should contain selenium",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSearch.openGoogleSearch()"
});
formatter.result({
  "duration": 9084186500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium",
      "offset": 10
    }
  ],
  "location": "GoogleSearch.enterKeyword(String)"
});
formatter.result({
  "duration": 2612761300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium",
      "offset": 29
    }
  ],
  "location": "GoogleSearch.theFirstOneShouldContainKeyword(String)"
});
formatter.result({
  "duration": 42726600,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.closeBrowser()"
});
formatter.result({
  "duration": 1228032600,
  "status": "passed"
});
});