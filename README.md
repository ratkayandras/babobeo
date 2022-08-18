# babobeo api

Just a pet project of mine, working on it when I have the time.

Eventually it should be a worktime scheduler.
- Organisations should be added
- Teams could be added to organisations
- Employees to teams
- And based on several criteria the api will be able to create time schedules for teams that can be sent out to employees and managers as a plan

## To run locally

1. cd etc
2. run `docker build -t babobeo-test-db ./`
3. run `docker run -d --name babobeo-test-db-container -p 5432:5432 babobeo-test-db`
4. run the application itself