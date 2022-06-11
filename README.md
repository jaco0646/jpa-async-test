# jpa-async-test

1. execute `gradle bootRun`
2. invoke `curl -X GET -H "authorization: foo" "http://localhost:8080/async"`
3. observe the application logs
  * >>> authToken before Repo call: foo
  * >>> authToken after Repo call: No Authorization Token in this Context!
