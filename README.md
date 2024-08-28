
#GitHub User Info - Spring Boot Application

##Description
This is a simple Spring Boot application that interacts with the GitHub REST API to fetch and display basic information about a specified GitHub user. The application provides a web interface where users can input a GitHub username and retrieve details such as the user's name, company, location, public repositories, followers, and following count.

##Features
Fetches and displays basic GitHub user information.
Handles invalid usernames gracefully.
Allows users to quit the application by entering specific commands (quit, exit).
Simple and clean web interface.
Technologies Used
Java: Programming language used for development.
Spring Boot: Framework used to create the application.
Thymeleaf: Template engine used for rendering the web interface.
GitHub REST API: External API used to fetch user data.
Maven: Dependency management and build tool.

##Setup and Installation
Prerequisites
Java 17 or higher
Maven (for dependency management)
Git (for version control)
Steps

1.Clone the Repository
```bash
git clone https://github.com/yourusername/github-user-info.git
cd github-user-info
```
2.Build the Project
Navigate to the project directory and run the following command to build the project:
```bash
mvn clean install
```
3.Run the Application
Start the application using the following command:
```bash
mvn spring-boot:run
```
4.Access the Application
Open your web browser and go to:
http://localhost:8080/

##Usage
1.On the home page, enter a GitHub username in the input field.
2.Click the "Submit" button to retrieve the user's information.
3.The details of the user will be displayed on the same page.
4.To exit the application, enter quit or exit as the username and press the submit button.

##Example
Username: potuu
Name: adil
Company: null
Location: Location
Public Repositories: 13
Followers: 5
Following: 5
Output:
![image](https://github.com/user-attachments/assets/bac9ec7a-ae8a-43a3-ad9d-96e2cf934411)



##Error Handling
If the username is not found, an appropriate error message will be displayed.
The application handles network errors and invalid inputs gracefully.
