<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Ostrovsky photography</title>
    <script type="text/javascript" src="/resources/galleriffic/js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="/resources/galleriffic/js/jquery.galleriffic.js"></script>
    <script type="text/javascript" src="/resources/galleriffic/js/jquery.history.js"></script>
    <script type="text/javascript" src="/resources/galleriffic/js/jquery.opacityrollover.js"></script>
    <link href="/resources/sitestyle.css" rel="stylesheet" type="text/css">
    </style>
  </head>
  <body>
    <div id="header" >
      <div id="logo" > </div>
      <div class="head_menu" > <a href="#" id="cur_head_menu">Main</a> <a href="#">News</a> <a href="#">Portfolio</a> <a href="#">Calendar</a> <a href="#">Contact us</a> </div>
    </div>
    <div id="slider" >
      <div class="slideshow-container">
        <div id="loading" class="loader"></div>
        <div id="slideshow" class="slideshow"></div>
      </div>
      <div id="thumbs">
        <ul class="thumbs noscript">
          <li> 
             <a class="thumb" name="optionalCustomIdentifier" 
              href = "http://farm4.static.flickr.com/3261/2538183196_8baf9a8015_s.jpg"
              title="title1" >
                 <img src="http://farm4.static.flickr.com/3261/2538183196_8baf9a8015_s.jpg"/>
              </a>
             <div class="caption"> descr 1 </div>
          </li>
          <li> 
             <a class="thumb" name="optionalCustomIdentifier" 
                href="http://farm3.static.flickr.com/2093/2538168854_f75e408156_s.jpg" title="title2"> 
                <img src="http://farm3.static.flickr.com/2093/2538168854_f75e408156_s.jpg"  /> 
             </a>
             <div class="caption"> descr 2 </div>
          </li>
        </ul>
      </div>
    </div>
  </body>
</html>
