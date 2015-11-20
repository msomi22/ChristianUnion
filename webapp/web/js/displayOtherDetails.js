/*
 All rights reserved.
  Licensed under the OSL-3.0 License:
  http://opensource.org/licenses/OSL-3.0

  Author: Migwi Ndung'u  <migwindungu0@gmail.com>
*/
//$(document).ready(function(){  

  var $image=$('<div id="loading"><img src="../images/loader.gif" alter="Loading Details.."></img></div>');
  var $table=$('.Zlinkk');
  
  var $scroll=$('#scroll21');


       //responds if element 'a' in class 'alink' is clicked
  //$('a.Zlink').click(function(){ 
    function TableGet(tableValue){

   var uuid = $(tableValue).attr('name');
   var admiss = $(tableValue).text();         
    
   //$scroll.hide();
    $scroll.append($image);   

     
  var data = "Uuid=" + escape(uuid);
  var adm = "Admiss="+ escape(admiss);
     //console.log(data+"  ******  "+adm);
     //console.log(adm);

     //depending on a users browser a request object is created
     function getRequestObject() {
          if (window.XMLHttpRequest) {
             return(new XMLHttpRequest());//for modern browsers, i.e. Opera,Mozilla, chrome e.t.c.
             } 

             else if (window.ActiveXObject) {
               return(new ActiveXObject("Microsoft.XMLHTTP")); //for internet explorer
             } 
             else if(window.createRequest){             
              return(window.createRequest());// for crystal browser
             }
             else {
              alert("Your current browser failed, try Mozilla or chrome browsers");
             return(null); 
             
             }
           }
    
      var request=getRequestObject();
      request.onreadystatechange =function() { handleResponse(request); };
       request.open("get", "../admin/displayOtherDetails.jsp?"+data+"&"+adm, true);
       request.send(); 
 }
 // });
//end of click function



function handleResponse(request) {
      if ((request.readyState == 4) && (request.status == 200)) {    
                //gets responseText
                 response=request.responseText;                
               // console.log(response.length);
                 $('#Ztable').remove();
                $image.remove();
                $scroll.append(response);
               
          }


      //if it fails do this....
          else if((request.readyState==0)&&(request.status=404)){              
                $image.remove();
                $('#Ztable').remove();
                 $scroll.html('could not load details ');
                 $scroll.html('<p class="par"><font color="red"> Sorry. An Error has occurred!!</font></p>');          
          }
       }

//});