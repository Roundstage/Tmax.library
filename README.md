# Tmax.library

In order to make this project works properly, you will have to follow those steps.

# 1) Have MYSQL installed, you can configurate your DB connection on a .ENV file.
      You can also follow the default configuration that is.
      spring.datasource.url=${MYSQL_URL:jdbc:mysql://localhost:3306/library_api}
      spring.datasource.username=${MYSQL_USERNAME:root}
      spring.datasource.password=${MYSQL_PASSWORD:root}

# 2) Configurate the JWT_SECRET on your .env file if you must.

# 3) Execute the LibraryApplication file, that is the initializer of the project.
