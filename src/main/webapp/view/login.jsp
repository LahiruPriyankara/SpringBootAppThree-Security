<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
  
</head>    
<body>    
    <form action="login" method="post">  
   <h3> ${SPRING_SECURITY_LAST_EXCEPTION.message}</h3>
    <br> <br> <br>
        <label>Username : </label>  
        <input type="text" name="username" required>  <br><br>
            
        <label>Password : </label>   
        <input type="password"  name="password" required>  <br><br>
            
        <button type="submit">Login</button>   
    </form>     
</body>     
</html>  