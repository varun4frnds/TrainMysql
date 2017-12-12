<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Trains DashBoard</title>
<jsp:include page="Home.jsp" />
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 50%;
		width: 100%;
		display: block;
        margin: auto;
        width: 80%;
		
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #floating-panel {
        position: absolute;
        top: 10px;
        left: 25%;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
      #select {
      
       position: absolute;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
 }
</style>
</head>
<body bgcolor="#d3d3d3"><br><br>

<%
        String name=(String)session.getAttribute("logname");
        
        
        if(name==null){
            response.sendRedirect("Login.jsp");
        }
        %>
        

<center>
<pre>
<form method="post" action="TrainController">
Enter Train No:    <input type="text" name="trainNo" placeholder="Ex:1001" /><br>
                   <span style="color:red">${error1}</span>
                   <input type="submit" name="s1" value="FindTrain"/><br>
                   
Enter Source:      <select id="start" name="source" style="width: 150px; padding: 2px" >
                   <c:forEach items="${sourcers}" var="item">  
                   <option value="${item.source}">${item.source}</option>
                   </c:forEach>
                   </select>
<br>
Enter Destination: <select id="end" name="destination" style="width: 150px; padding: 2px">
                   <c:forEach items="${destinationrs}" var="item12">  
                   <option value="${item12.destination}">${item12.destination}</option>
                   </c:forEach>
                   </select>
                   <span style="color:red">${error2}</span>
                   <input type="submit" name="s1" value="Find" style="width: 80px"/><br>
</form>
<h2>The selected route would be</h2>
</pre>
</center>
<div id="map" ></div>

    <script>
      function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 6,
          center: {lat: 17.38, lng: 78.49}
        });
        directionsDisplay.setMap(map);

        var onChangeHandler = function() {
          calculateAndDisplayRoute(directionsService, directionsDisplay);
        };
        document.getElementById('start').addEventListener('change', onChangeHandler);
        document.getElementById('end').addEventListener('change', onChangeHandler);
      }

      function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        directionsService.route({
          origin: document.getElementById('start').value,
          destination: document.getElementById('end').value,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBmb-clEu2xVCYdLE3HkWQfX90p5jjXfz4&callback=initMap">
    </script>
    <br><br><br>
</body>
</html>