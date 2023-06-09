<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <!-- <meta charset="utf-8"> -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Ostphoto</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sitestyle.css">
    <script src="${pageContext.request.contextPath}/resources/js/vendor/modernizr-2.6.2.min.js"></script>
</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to
    improve your experience.</p>
<![endif]-->

<!-- CONTENT START -->

<div class="header-wrapper">
    <div class="header">
        <div class="logo"></div>
        <ul class="head_menu">
            <li class="current"><a href="#">Main</a></li>
            <li><a href="#">News</a></li>
            <li><a href="#">Portfolio</a></li>
            <li><a href="${pageContext.request.contextPath}/booking">Calendar</a></li>
            <li><a href="#">Contact us</a></li>
        </ul>
    </div>
</div>


<div class="slideshow">
    <div class="slideshow-inner">
        <div id="gallery" class="content-container">
            <div class="slideshow-container">
                <div id="loading" class="loader"></div>
                <div id="slideshow" class="slideshow-container"></div>
            </div>
        </div>
        <div id="thumbs" class="navigation">
            <ul class="thumbs">
                <c:forEach items="${photoList}" var="photo">      
					<li>
								<a class="thumb" name="leaf" title=""
									href="${pageContext.request.contextPath}/admin/photo/slider/${photo.update}/${photo.fileName}">
									<img 
									src="${pageContext.request.contextPath}/admin/photo/s/${photo.update}/${photo.fileName}"
									alt="Title #0" />
									</a>
						
						<div class="caption">
							<div class="image-title"></div>
							<div class="image-desc"></div>
						</div>
					</li>
			</c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="content-wrapper">
    <!-- TODO: fix buggy galleriffic CSS which declares plain .content styles  -->
    <div class="content-main">
        <div class="content-news">
            <h2>Our news</h2>
            <ul>
                <li>
                    <div class="content-news-date">
                        <span class="content-news-date-number">01</span>
                        Sep
                    </div>
                    <div class="content-news-text">
                        <h3><a href="#">News 1</a></h3>

                        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                            laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                            architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
                            aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione
                            voluptatem sequi nesciunt.</p>
                    </div>
                </li>
                <li>
                    <div class="content-news-date">
                        <span class="content-news-date-number">01</span>
                        Sep
                    </div>
                    <div class="content-news-text">
                        <h3><a href="#">News 1</a></h3>

                        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                            laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                            architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
                            aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione
                            voluptatem sequi nesciunt.</p>
                    </div>
                </li>
                <li>
                    <div class="content-news-text">
                        <h3><a href="#">Read more news...</a></h3>
                    </div>
                </li>
            </ul>
        </div>
        <div class="content-calendar">
            <h2>Calendar</h2>

            <div id="calendar"></div>
        </div>
    </div>
</div>

<div class="content-bottom-wrapper">
    <div class="content-bottom">
        <h2>Last added photos</h2>
        <ul class="recent-photos">
             <c:forEach items="${lastPhotos}" var="photo">    							
            <li>
                     <div class="recent-photos-image">
						<img 
							src="${pageContext.request.contextPath}/admin/photo/last/${photo.update}/${photo.fileName}"/>
					</div>
					<div class="recent-photos-caption"><a href="#">Wedding...</a></div>
                <div class="recent-photos-date">September 17, 2013</div>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="footer-wrapper">
    <div class="footer">
        <div class="footer-about">
            <h2>About us</h2>

            <p>Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.</p>

            <p class="footer-about-copyright">
                2013 All rights reserved.
            </p>
        </div>
        <div class="footer-social">
            <h2>Social media links</h2>
        </div>
    </div>
</div>

<!-- CONTENT END -->

<script type="text/javascript" src="../../resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../../resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<script type="text/javascript" src="../../resources/galleriffic/js/jquery.galleriffic.js"></script>
<script type="text/javascript" src="../../resources/galleriffic/js/jquery.opacityrollover.js"></script>

<script>
    jQuery(document).ready(function ($) {
        galleryInit($);
        calendarInit($);
    });

    calendarInit = function ($) {
        $("#calendar").datepicker();
    }

    galleryInit = function ($) {
        // We only want these styles applied when javascript is enabled
//         $('.slideshow .navigation').css({'width': '333px', 'float': 'right'});
//         $('.slideshow .content-container').css({'width': '480px', 'float': 'left'});

        // Initially set opacity on thumbs and add
        // additional styling for hover effect on thumbs
        var onMouseOutOpacity = 0.67;
        $('#thumbs ul.thumbs li').opacityrollover({
            mouseOutOpacity: onMouseOutOpacity,
            mouseOverOpacity: 1.0,
            fadeSpeed: 'fast',
            exemptionSelector: '.selected'
        });

        // Initialize Advanced Galleriffic Gallery
        var gallery = $('#thumbs').galleriffic({
            delay: 0,
            numThumbs: 6,
            preloadAhead: 10,
            enableTopPager: true,
            enableBottomPager: true,
            maxPagesToShow: 7,
            imageContainerSel: '#slideshow',
            controlsContainerSel: '#controls',
            captionContainerSel: '#caption',
            loadingContainerSel: '#loading',
            renderSSControls: false,
            renderNavControls: false,
            playLinkText: 'Play Slideshow',
            pauseLinkText: 'Pause Slideshow',
            prevLinkText: '&lsaquo; Previous Photo',
            nextLinkText: 'Next Photo &rsaquo;',
            nextPageLinkText: 'Next &rsaquo;',
            prevPageLinkText: '&lsaquo; Prev',
            enableHistory: false,
            autoStart: false,
            syncTransitions: true,
            defaultTransitionDuration: 900,
            onSlideChange: function (prevIndex, nextIndex) {
                // 'this' refers to the gallery, which is an extension of $('#thumbs')
                this.find('ul.thumbs').children()
                        .eq(prevIndex).fadeTo('fast', onMouseOutOpacity).end()
                        .eq(nextIndex).fadeTo('fast', 1.0);
            },
            onPageTransitionOut: function (callback) {
                this.fadeTo('fast', 0.0, callback);
            },
            onPageTransitionIn: function () {
                this.fadeTo('fast', 1.0);
            }
        });
    }
</script>
<!--
Google Analytics
<script>
     var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
     (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
     g.src='//www.google-analytics.com/ga.js';
     s.parentNode.insertBefore(g,s)}(document,'script'));
 </script> -->
</body>
</html>

