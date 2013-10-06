
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Ostrovsky photography</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/galleriffic/js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/galleriffic/js/jquery.galleriffic.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/galleriffic/js/jquery.history.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/galleriffic/js/jquery.opacityrollover.js"></script>
    <link href="${pageContext.request.contextPath}/resources/sitestyle.css" rel="stylesheet" type="text/css">
    <link href="/resources/sitestyle.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/resources/galleriffic/css/basic.css" type="text/css" />
    <link rel="stylesheet" href="/resources/galleriffic/css/galleriffic-2.css" type="text/css" />
    </style>
  </head>
  <body>
    <div id="header" >
      <div id="logo" > </div>
      <div class="head_menu" > <a href="#" id="cur_head_menu">Main</a><a href="#">News</a><a href="#">Portfolio</a> <a href="${pageContext.request.contextPath}/booking">Calendar</a> <a href="#">Contact us</a> </div>
    </div>
    <div id="slider" >
          <div id="gallery" class="content">

        <div class="slideshow-container">
          <div id="loading" class="loader"></div>
          <div id="slideshow" class="slideshow"></div>
        </div>
        <div id="caption" class="caption-container"></div>
      </div>
      <div id="thumbs" class="navigation">
        <ul class="thumbs noscript">
          <li> <a class="thumb" name="leaf" href="http://farm4.static.flickr.com/3261/2538183196_8baf9a8015.jpg" title="Title #0"> <img src="http://farm4.static.flickr.com/3261/2538183196_8baf9a8015_s.jpg" alt="Title #0" /> </a>
            <div class="caption">
                <div class="image-title">Title #0</div>
              <div class="image-desc">Description</div>
            </div>
          </li>
          <li> <a class="thumb" name="drop" href="http://farm3.static.flickr.com/2404/2538171134_2f77bc00d9.jpg" title="Title #1"> <img src="http://farm3.static.flickr.com/2404/2538171134_2f77bc00d9_s.jpg" alt="Title #1" /> </a>
            <div class="caption"> Any html can be placed here ... </div>
          </li>
          <li> <a class="thumb" name="bigleaf" href="http://farm3.static.flickr.com/2093/2538168854_f75e408156.jpg" title="Title #2"> <img src="http://farm3.static.flickr.com/2093/2538168854_f75e408156_s.jpg" alt="Title #2" /> </a>
            <div class="caption">
              <div class="image-title">Title #2</div>
              <div class="image-desc">Description</div>
            </div>
          </li>
          <li> <a class="thumb" name="lizard" href="http://farm4.static.flickr.com/3153/2538167690_c812461b7b.jpg" title="Title #3"> <img src="http://farm4.static.flickr.com/3153/2538167690_c812461b7b_s.jpg" alt="Title #3" /> </a>
            <div class="caption">
              <div class="image-title">Title #3</div>
              <div class="image-desc">Description</div>
            </div>
          </li>
          <li> <a class="thumb" href="http://farm4.static.flickr.com/3150/2538167224_0a6075dd18.jpg" title="Title #4"> <img src="http://farm4.static.flickr.com/3150/2538167224_0a6075dd18_s.jpg" alt="Title #4" /> </a>
            <div class="caption">
              <div class="image-title">Title #4</div>
              <div class="image-desc">Description</div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <br>

<script type="text/javascript">

			jQuery(document).ready(function($) {
				// We only want these styles applied when javascript is enabled
				$('div.navigation').css({'width' : '200px', 'float' : 'right'});
				$('div.content').css('display', 'block');

				// Initially set opacity on thumbs and add
				// additional styling for hover effect on thumbs
				var onMouseOutOpacity = 0.67;
				$('#thumbs ul.thumbs li').opacityrollover({
					mouseOutOpacity:   onMouseOutOpacity,
					mouseOverOpacity:  1.0,
					fadeSpeed:         'fast',
					exemptionSelector: '.selected'
				});
				
				// Initialize Advanced Galleriffic Gallery
				var gallery = $('#thumbs').galleriffic({
					delay:                     2500,
					numThumbs:                 15,
					preloadAhead:              10,
					enableTopPager:            true,
					enableBottomPager:         true,
					maxPagesToShow:            7,
					imageContainerSel:         '#slideshow',
					controlsContainerSel:      '#controls',
					captionContainerSel:       '#caption',
					loadingContainerSel:       '#loading',
					renderSSControls:          true,
					renderNavControls:         true,
					playLinkText:              'Play Slideshow',
					pauseLinkText:             'Pause Slideshow',
					prevLinkText:              '&lsaquo; Previous Photo',
					nextLinkText:              'Next Photo &rsaquo;',
					nextPageLinkText:          'Next &rsaquo;',
					prevPageLinkText:          '&lsaquo; Prev',
					enableHistory:             false,
					autoStart:                 false,
					syncTransitions:           true,
					defaultTransitionDuration: 900,
					onSlideChange:             function(prevIndex, nextIndex) {
						// 'this' refers to the gallery, which is an extension of $('#thumbs')
						this.find('ul.thumbs').children()
							.eq(prevIndex).fadeTo('fast', onMouseOutOpacity).end()
							.eq(nextIndex).fadeTo('fast', 1.0);
					},
					onPageTransitionOut:       function(callback) {
						this.fadeTo('fast', 0.0, callback);
					},
					onPageTransitionIn:        function() {
						this.fadeTo('fast', 1.0);
					}
				});
			});
		
		</script>
    
  </body>
</html>

