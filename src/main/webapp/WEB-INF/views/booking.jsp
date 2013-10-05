<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Booking meeting date</title>
	<link rel='stylesheet' type='text/css' href='resources/js/fullcalendar.css' />
	<link rel='stylesheet' type='text/css' href='resources/js/fullcalendar.print.css' media='print' />
	<script type='text/javascript' src="<c:url value="resources/js/jquery.min.js" />"></script>
	<script type='text/javascript' src="<c:url value="resources/js/jquery-ui.custom.min.js" />"></script>
	<script type='text/javascript' src="<c:url value="resources/js/fullcalendar.min.js" />"></script>
	<script type='text/javascript'>
		$(document).ready(function() {
			var date = new Date();
			var d = date.getDate();
			var m = date.getMonth();
			var y = date.getFullYear();
			$.getJSON('http://localhost:8080/OstPhoto/admin/calendar/getApprovedDates', function (data) {
	            var calendar = $('#calendar').fullCalendar({
	                header: {
	                    left: 'prev,next today',
	                    center: 'title',
	                    right: 'month,agendaWeek,agendaDay'
	                },
	                selectable: true,
	                selectHelper: true,
	                select: function(start, end, allDay) {
	                    var title = prompt('Event Title:');
	                    if (title) {
	                        calendar.fullCalendar('renderEvent',
		                        {
		                            title: title,
		                            start: start,
		                            end: end,
		                            allDay: allDay
		                        },
	                            true // make the event "stick"
	                        );
	                    }
	                    
	                    /* var a = [];
	                    a[0] = title;
	                    a[1] = start;
	                    a[2] = end; */
	                    
	                    $.ajax({
	                        type : "POST",
	                        url : "http://localhost:8080/OstPhoto/admin/calendar/setNewDate",
	                        /* dataType:'json', */
	                        data : title + ";" + start + ";" + end,
	                        success : function(response) {
	                           alert('success'); 
	                        },
	                        error : function(e) {
	                           alert('Error: ' + e);
	                        }
	                    }); 
	                    calendar.fullCalendar('unselect');
	                },
	                editable: true,
	                events:[data]
	            });
	         });
	        });
	
	</script>
	<style type='text/css'>
	
		body {
			margin-top: 40px;
			text-align: center;
			font-size: 14px;
			font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
			}
	
		#calendar {
			width: 900px;
			margin: 0 auto;
			}
	
	</style>
</head>
<body>
<h1>Booking calendar</h1>
<div id='calendar'></div>

</body>
</html>