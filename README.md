# SpringBootAppThree-Security

Java version – 1.8


-In here I have implemented spring security configuration with spring security dependency. 


-I have used external SQL data base base and JPA.
 
 
-Project is built in STS.

-How to solve 'No projects are found to import' in eclipse  - https://www.youtube.com/watch?v=GcnMb3kmGGc


-CREATE SCHEMA `springbootjpajwtsecuritydb`;

-DataBase which i have used also have given.

----------------------------------------------------------------------

http://localhost:8080/login

-Username and password which i have used.

daoAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder());

user name : lahiru | password : lahiru

----------------------------------------------------------------------

//daoAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder());

user name : lahiru123 | password : lahiru123
