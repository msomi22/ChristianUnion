<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    
    <link href="../css/admin/login.css" rel="stylesheet">
    <link rel="stylesheet" href="css/reset.css">

        <script src="js/prefixfree.min.js"></script>

    
  </head>

  <body>

    <div id="login">
  <form id="login_form" method="POST" action="AdminLogin">
    <div class="field_container">
      <input type="text" placeholder="UserName" name="username">
    </div>
    
    <div class="field_container">
      <input type="Password" placeholder="Password" name="password">
      <button id="sign_in_button">
        <span class="button_text">Sign In</span>
      </button>
    </div>
    
    <div id="sign_in_options" class="field_container">
        
        <div id="remember_me_container">
          <input name="user[remember_me]" type="hidden" value="0"><input id="user_remember_me" name="user[remember_me]" type="checkbox" value="1">
          <label class="login_link" for="user_remember_me" id="remember_me_label">stay signed in</label>
        </div>
        <div class="clearfix"></div>
      </div>
    </form>

</div>
    
    
    
    
    
  </body>
</html>
