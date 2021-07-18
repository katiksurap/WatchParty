<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css/" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js/" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){

    $.get("getData", function(data, status){
      alert("Data: " + data + "\nStatus: " + status);
      var data = data;
      var yourhtmlpage = '<div class="container"><div class="row">';
      debugger;
   //test url :https://www.youtube.com/embed/Ac993M2VimM?rel=1&autoplay=1&mute=1
      var counter = 0;
      for(var counter = 0 ; counter < data.length ; counter++){
    	  var wpd  = data[counter]
          debugger;
          console.log("wpd", wpd.userName);
          var userDataUrl = wpd.liveVideoUrl;
          if(userDataUrl != null && userDataUrl.length > 0) {
              counter ++;
              yourhtmlpage += 
                      '<div class="col-sm-3" style="width:140px;margin-left;10px"><iframe src="https://www.youtube.com/embed/'+userDataUrl+'?mute=1&vq=tiny&rel=1&version=3&autoplay=1" width="150"' +
                      ' height="135" allow="autoplay; encrypted-media" frameborder="0"></iframe></div>&nbsp;&nbsp;';
          }

      }
      if (counter == 0 ) {
          yourhtmlpage = "<span><center><b>No One Online , Come back in Short time</b></center></span>";
      }
      yourhtmlpage += "</div></div>";
      $('#data').html(yourhtmlpage);
      debugger;
    });

    
});
</script>
</head>
<body>
<div id="data">
</div>
</body>
</html>
