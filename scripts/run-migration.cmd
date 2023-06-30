docker run --rm `
  -v "${PWD}/db/users:/flyway/sql"`
  --network "book-store" `
  flyway/flyway `
  -url=jdbc:postgresql://book-store-postgres:5432/users `
  -user=postgres `
  -password=postgres `
  migrate
