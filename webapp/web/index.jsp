




<div id="tooplate_wrapper">

  <jsp:include page="header.jsp" />
    
 
  <div id="container" class="clear"> 
   
    <div id="homepage" class="clear">  
     <h3><i class="icon-edit"></i> Student Registration Form: Basic Details</h3>            
      <P> <b>Please NOTE that fields maked with(*) are required/mandatory </b></P>
        
         <div class="box-content">
            <form  class="form-horizontal"   action="addStudent" method="POST" >
                <fieldset>
                    <div class="control-group">
                        <label class="control-label" for="name">Admission Nummber*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="AdmNo" required="true"  value="" >

                        </div>


                    </div>  
                    <div class="control-group">
                        <label class="control-label" for="name">Firt Name*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="FirtName" required="true" value="" >                                    
                        </div>
                    </div> 


                    <div class="control-group">
                        <label class="control-label" for="name">SurName:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="SurName" value="" >
                        </div>
                    </div> 


                     <div class="control-group">
                        <label class="control-label" for="name">Last Name:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="LastName" value="" >
                        </div>
                    </div> 
                    

                    <div class="control-group">
                        <label class="control-label" for="name">Email:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="Email" value="" >
                        </div>
                    </div> 





                    <div class="control-group">
                        <label class="control-label" for="name">Phone*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="Phone" required="true" value="">
                        </div>
                    </div> 

                           
                            
                      
                      <div class="control-group">
                        <label class="control-label" for="name">Guardian Contact:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="GuardianContact"  value="">
                        </div>
                    </div> 


                    <div class="control-group">
                        <label class="control-label" for="name">DOB*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="DOB" required="true" value="">
                        </div>
                    </div> 

                           


                   
                     <div class="control-group">
                        <label class="control-label" for="name">Gender*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="radio" name="studentgender" value="MALE" >Male 
                            <input class="input-xlarge focused" id="receiver" type="radio" name="studentgender" value="FEMALE">Female 
                        </div>
                    </div> 



                       <h3><i class="icon-edit"></i> Education Details:</h3>      


                    <div class="control-group">
                        <label class="control-label" for="name">Program/Major*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="Program" required="true" value="">

                        </div>
                    </div> 



                    <div class="control-group">
                        <label class="control-label" for="name">Academic Year*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="AcademicYear" required="true" value="">
                        </div>
                    </div> 



                     
                    <div class="control-group">
                        <label class="control-label" for="name">Year Of Study*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="YearOfStudy" required="true" value="">
                        </div>
                    </div> 
                    
                       <h3><i class="icon-edit"></i> Other Details:</h3> 

                    <div class="control-group">
                        <label class="control-label" for="name">Home Town*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="HomeTown" required="true" value="">
                        </div>
                    </div> 


                    <div class="control-group">
                        <label class="control-label" for="name">County*:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="County" required="true" value="">
                        </div>
                    </div> 


                      <h3><i class="icon-edit"></i> Your Christian Life:</h3> 

                    
                   <div class="control-group">
                        <label class="control-label" for="name"> Area You A Christian?*:</label>
                        <div class="controls">
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Christian" value="YES">Yes 
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Christian" value="NO">No 
                        </div>

                    </div> 
                   

                   <div class="control-group">
                        <label class="control-label" for="name">If Yes Approximately For How long Have You Been In Christianity:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="Duration" placeholder="e.g(5 years)" value="">
                        </div>
                    </div> 


                     <div class="control-group">
                        <label class="control-label" for="name"> Have you ever served in any ministry?:</label>
                        <div class="controls">
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Ministry" value="YES">Yes
                             <input class="input-xlarge focused" id="receiver" type="radio" name="Ministry" value="NO">No 
                        </div>
                    </div> 


                   <div class="control-group">
                        <label class="control-label" for="name">If Yes which Ministry(s):</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="MinistryName"   value="">
                        </div>
                    </div> 


                     <div class="control-group">
                        <label class="control-label" for="name">Which ministry would you like to serve in the Maasai Mara University Christian Union?:</label>
                        <div class="controls">
                            <input class="input-xlarge focused" id="receiver" type="text" name="DesiredMinistry"    value="">
                        </div>
                    </div> 



                     <div class="control-group">
                        <label class="control-label" for="name">What is your vision for the Ministry you desire Serve in?:</label>
                        <div class="controls">
                            <textarea  type="textarea" name="Vision" rows="5" cols ="90" >
                            </textarea>
                        </div>
                    </div> 
                   



                     <h3><i class="icon-edit"></i> Student Declaration:</h3>        
                    <p>According to <b>MMCU(MU)</b> Constitution <i>Article 6(A) (1)</i>.Full membership shall be open to all bonafide 
                       registered undergeaduate students of <u>Maasai Mara University</u> Christan Union(Main campus) 
                       who ascribe to the doctrinal basis in <i>article (5)</i> and soberly sign/accept the following declaration.</p>
                    <p>"In Joining <b>MMUCU(MU),</b> <strong>I declare</strong> my Faith in Jesus as my Savior and Lord, and it is my desire by the Grace of God to
                    live a life consistent with this Declaration.I am also determined to give active support to the <b>MMUCU(MU)</b> as it seeks
                    to fullfill it aims"</p>   
                    <input type="checkbox" name="Declaration" id="Declaration" required="true">
                    I Declare  <a href=#">


                    <div class="form-actions">
                        <button type="submit" name="Send" value="Send"   class="btn btn-primary">Submit</button>
                    </div>
                            
                   </fieldset>
                   </form>


       
                   </div><!--/span-->








    
             
         
    </div>
        <div class="cleaner"></div>
    </div> <!-- end of main -->
    
   <jsp:include page="footer.jsp" />


















