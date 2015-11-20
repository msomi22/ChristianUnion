<!--
/******************************************************************************
 * ****************************************************************************
 ************* MAASAI MARA UNIVERITY CHRISTIAN UNION MANAGEMENT SYSTEM*********
 *************THIS SYSTEM IS BASED ON JAVAEE, USING MVC MODEL******************
 *************THE SYSTEM IS USED FOR STUDEN REGISTRATION TO THE UNION**********
 *************STUDENT REGISTRATION MODULE WILL BE ACCESSIBLE REMOTELY**********
 *************VIA USE OF PUBLIC IP ADDRESS OR A DOMAIN NAME********************
 *THE STUDENT WILL ALSO BE ABLE TO CHECK THEIR REGISTERD DETAILS FOR VERIFICATION
 *WHEREBY, THEY ARE ALLOWED TO MODIGY THEIR DETAILS WITHIN ONE WEEK AFTER REGISTRATION DATE
 *****************************************************************************************
 *****************************************************************************************
 *THE OTHER MODULES OR ONLY FOR ADMIN, THE ADMIN WILL APPROVE STUDEDNTS AFTER THEY REGISTER
 *THE REGISTRATION WILL REQURED RE-ACTIVATION AFTER A PERIOD OF ONE YEAR(12 MONTHS) THIS WILL
 *HAPPEN AUTOMATICALLY WITH THE HELP OF QUARTZ SCHEDULAR, FOR EFFICIENCY AND KEEPING THE SYSTEM
 *AT HIGH PERFORMANCE, SOME DATA ARE CACHED USING EHCHACE.
 **********************************************************************************************
 **********************************************************************************************
 *COPYRIGHT REMAINS TO SOFTECH SOLUTIONS, A FAST GROWING IT COMPANY
 *CONTSCTS: WWW.FASTECCHSOLUTIONS.CO.KE
 *          WWW.FACEBOOK.COM/FASTECH.CO.KE
 *
 * @author peter<a href="mailto:mwendapeter72@gmail.com">Peter mwenda</a>
 */
  
-->





<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    
    
    <link rel="stylesheet" href="css/reset.css">


<!DOCTYPE html>
<html>
<head>
    <title>login</title>

 <script src="js/prefixfree.min.js"></script>
 <link href="../css/adminlogin.css" rel="stylesheet"/>
</head>
<body>

    <div id="login">
    <form id="login_form" action="../adminLogin" method="POST">
    <div class="field_container">
      <input type="text" placeholder="Username" name="Username">
    </div>
    
    <div class="field_container">
      <input type="Password" placeholder="Password" name="Password">
      <button id="sign_in_button">
        <span class="button_text">Sign In</span>
      </button>
    </div>
   
    </form>

</div>
    
    
  </body>
</html>
