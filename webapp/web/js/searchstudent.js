
/*
    Author: Migwi Ndung'u  <migwi@tawi.mobi>
*/
	function displaystudents(AdmissNo){
  
    var data = "admissNo=" + escape(AdmissNo);
   // console.log("Search:"+data);

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
             return(null); 
             //alert("Your current browser failed, try Mozilla or chrome browsers");
             }
           }
    
      var Request=getRequestObject();
      Request.onreadystatechange =function() { Response(Request);};
       Request.open("get", "../admin/studentsearch.jsp?"+data, true);
       Request.send(); 
  }
//end of onKeyup function



function Response(request) {
	//alert(request.responseText);
        if((request.readyState == 4) && (request.status == 200)) {
             $('.tabledit').remove();
             $('#pagination').hide();   
                 response=request.responseText;
                // console.log(response.length);
              $('.tablebody').append(response);                               
        }
}
