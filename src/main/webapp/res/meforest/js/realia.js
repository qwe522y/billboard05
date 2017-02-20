$(document).ready(function() {
	//InitCarousel();
    InitPropertyCarousel();
	InitOffCanvasNavigation();
	InitMap();
	InitChosen();
	InitEzmark();
	InitPriceSlider();
	InitImageSlider();
	InitAccordion();
	InitTabs();
    InitPalette();
});

function InitPalette() {
    if ($.cookie('palette') == 'true') {
        $('.palette').addClass('open');
    }

    $('.palette .toggle a').on({
        click: function(e) {
            e.preventDefault();
            var palette = $(this).closest('.palette');

            if (palette.hasClass('open')) {
                palette.animate({'left': '-195'}, 500, function() {
                    palette.removeClass('open');
                });
                $.cookie('palette', false)
            } else {
                palette.animate({'left': '0'}, 500, function() {
                    palette.addClass('open');
                    $.cookie('palette', true);
                });
            }
        }
    });

    if ($.cookie('color-variant')) {
        var link = $('.palette').find('a.'+ $.cookie('color-variant'));
        var file = link.attr('href');
        var klass = link.attr('class');

        $('#color-variant').attr('href', file);
        $('body').addClass(klass);
    }

    if ($.cookie('pattern')) {
        $('body').addClass($.cookie('pattern'));
    }

    if ($.cookie('header')) {
        $('body').addClass($.cookie('header'));
    }

    $('.palette a').on({
        click: function(e) {
            e.preventDefault();

            // Colors
            if ($(this).closest('div').hasClass('colors')) {
                var file = $(this).attr('href');
                var klass = $(this).attr('class');
                $('#color-variant').attr('href', file);

                if (!$('body').hasClass(klass)) {
                    $('body').removeClass($.cookie('color-variant'));
                    $('body').addClass(klass);
                }
                $.cookie('color-variant', klass)
            }
            // Patterns
            else if ($(this).closest('div').hasClass('patterns')) {
                var klass = $(this).attr('class');

                if (!$('body').hasClass(klass)) {
                    $('body').removeClass($.cookie('pattern'));
                    $('body').addClass(klass);
                    $.cookie('pattern', klass);
                }
            }
            // Headers
            else if ($(this).closest('div').hasClass('headers')) {
                var klass = $(this).attr('class');

                if (!$('body').hasClass(klass)) {
                    $('body').removeClass($.cookie('header'));
                    $('body').addClass(klass);
                    $.cookie('header', klass);
                }
            }
        }
    });
    $('.palette .reset').on({
        click: function() {
            $('body').removeClass($.cookie('color-variant'));
            $('#color-variant').attr('href', null);
            $.removeCookie('color-variant');

            $('body').removeClass($.cookie('pattern'));
            $.removeCookie('pattern');

            $('body').removeClass($.cookie('header'));
            $.removeCookie('header');
        }
    })
}

function InitPropertyCarousel() {
    $('.carousel.property .content li img').on({
        click: function(e) {
            var src = $(this).attr('src');
            var img = $(this).closest('.carousel.property').find('.preview img');
            img.attr('src', src);
            $('.carousel.property .content li').each(function() {
                $(this).removeClass('active');
            });
            $(this).closest('li').addClass('active');
        }
    })
}

function InitTabs() {
	$('.tabs a').click(function (e) {
  		e.preventDefault();
  		$(this).tab('show');
	});
}

function InitImageSlider() {
	$('.iosSlider').iosSlider({
		desktopClickDrag: true,
		snapToChildren: true,
		infiniteSlider: true,
		navSlideSelector: '.slider .navigation li',
		onSlideComplete: function(args) {
			if(!args.slideChanged) return false;

			$(args.sliderObject).find('.slider-info').attr('style', '');

			$(args.currentSlideObject).find('.slider-info').animate({
				left: '15px',
				opacity: '.9'
			}, 'easeOutQuint');
		},
		onSliderLoaded: function(args) {
			$(args.sliderObject).find('.slider-info').attr('style', '');

			$(args.currentSlideObject).find('.slider-info').animate({
				left: '15px',
				opacity: '.9'
			}, 'easeOutQuint');
		},
		onSlideChange: function(args) {
			$('.slider .navigation li').removeClass('active');
			$('.slider .navigation li:eq(' + (args.currentSlideNumber - 1) + ')').addClass('active');
		},
		autoSlide: true,
		scrollbar: true,
		scrollbarContainer: '.sliderContainer .scrollbarContainer',
		scrollbarMargin: '0',
		scrollbarBorderRadius: '0',
		keyboardControls: true
	});
}

function InitAccordion() {
    $('.accordion').on('show', function (e) {
        $(e.target).prev('.accordion-heading').find('.accordion-toggle').addClass('active');
    });

    $('.accordion').on('hide', function (e) {
        $(this).find('.accordion-toggle').not($(e.target)).removeClass('active');
    });
}

function InitPriceSlider() {
    jQuery('.price-value .from').text( window.absoluteMinRent);
    jQuery('.price-value .from').currency({ region: 'RUB', thousands: ' ', decimal: ',', decimals: 0 });

    jQuery('.price-value .to').text(window.absoluteMaxRent);
    jQuery('.price-value .to').currency({ region: 'RUB', thousands: ' ', decimal: ',', decimals: 0 });

    $('.property-filter .price-slider').slider({
        range: true,
        min: window.absoluteMinRent,
        max: window.absoluteMaxRent,
        values: [window.absoluteMinRent, window.absoluteMaxRent],
        slide: function(event, ui) {
            jQuery('.property-filter .price-from input').attr('value', ui.values[0]);
            jQuery('.property-filter .price-to input').attr('value', ui.values[1]);

            jQuery('.price-value .from').text(ui.values[0]);
            jQuery('.price-value .from').currency({ region: 'RUB', thousands: ' ', decimal: ',', decimals: 0 });

            jQuery('.price-value .to').text(ui.values[1]);
            jQuery('.price-value .to').currency({ region: 'RUB', thousands: ' ', decimal: ',', decimals: 0 });
        }
    });
}

function InitEzmark() {
	$('input[type="checkbox"]').ezMark();
	$('input[type="radio"]').ezMark();
}

function InitChosen() {
	$('select').chosen({
		disable_search_threshold: 10
	});
}

function InitOffCanvasNavigation() {
	$('#btn-nav').on({
		click: function() {
			$('body').toggleClass('nav-open');
		}
	})
}

function InitCarousel() {
	$('#main .carousel .content ul').carouFredSel({
		scroll: {
			items: 1
		},
		auto: false,
		next: {
    		button: '#main .carousel-next',
    		key: 'right'
		},
		prev: {
    		button: '#main .carousel-prev',
    		key: 'left'
		}
	});

	$('.carousel-wrapper .content ul').carouFredSel({
		scroll: {
			items: 1
		},
		auto: false,
		next: {
    		button: '.carousel-wrapper .carousel-next',
    		key: 'right'
		},
		prev: {
    		button: '.carousel-wrapper .carousel-prev',
    		key: 'left'
		}
	});
}
/*
function LoadMapProperty() {
    var locations = new Array(
        [34.01312,-118.496808]
    );
    var markers = new Array();
    var mapOptions = {
        center: new google.maps.LatLng(34.012044, -118.494458),
        zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        scrollwheel: false
    };

    var map = new google.maps.Map(document.getElementById('property-map'), mapOptions);

    $.each(locations, function(index, location) {
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(location[0], location[1]),
            map: map,
            icon: 'http://html.realia.byaviators.com/assets/img/marker-transparent.png'
        });

        var myOptions = {
            content: '<div class="infobox"><div class="image"><img src="http://html.realia.byaviators.com/assets/img/tmp/property-tiny-1.png" alt=""></div><div class="title"><a href="detail.html">1041 Fife Ave</a></div><div class="area"><span class="key">Area:</span><span class="value">200m<sup>2</sup></span></div><div class="price">€450 000.00</div><div class="link"><a href="detail.html">View more</a></div></div>',
            disableAutoPan: false,
            maxWidth: 0,
            pixelOffset: new google.maps.Size(-146, -190),
            zIndex: null,
            closeBoxURL: "",
            infoBoxClearance: new google.maps.Size(1, 1),
            position: new google.maps.LatLng(location[0], location[1]),
            isHidden: false,
            pane: "floatPane",
            enableEventPropagation: false
        };
        marker.infobox = new InfoBox(myOptions);
        marker.infobox.isOpen = false;

        var myOptions = {
            draggable: true,
            content: '<div class="marker"><div class="marker-inner"></div></div>',
            disableAutoPan: true,
            pixelOffset: new google.maps.Size(-21, -58),
            position: new google.maps.LatLng(location[0], location[1]),
            closeBoxURL: "",
            isHidden: false,
            // pane: "mapPane",
            enableEventPropagation: true
        };
        marker.marker = new InfoBox(myOptions);
        marker.marker.open(map, marker);
        markers.push(marker);

        google.maps.event.addListener(marker, "click", function (e) {
            var curMarker = this;

            $.each(markers, function (index, marker) {
                // if marker is not the clicked marker, close the marker
                if (marker !== curMarker) {
                    marker.infobox.close();
                    marker.infobox.isOpen = false;
                }
            });


            if(curMarker.infobox.isOpen === false) {
                curMarker.infobox.open(map, this);
                curMarker.infobox.isOpen = true;
                map.panTo(curMarker.getPosition());
            } else {
                curMarker.infobox.close();
                curMarker.infobox.isOpen = false;
            }

        });
    });
}
*/
function LoadMap() {
    console.log("init map");
	var mapOptions = {
		center: new google.maps.LatLng(42.975182, 47.503995),
		zoom: 14,
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		scrollwheel: false
    };
    var markers = [];
    var map = new google.maps.Map(document.getElementById('map'), mapOptions);
    window.map = map;

    $.each(window.billboards, function(index, bb) {
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(bb.position[0], bb.position[1]),
            map: map,
            icon: window.myrespath+'/meforest/img/marker-transparent.png',
            index: index,
            draggable:false
        });

	    var myOptions = {
	        content: '<div class="infobox"><div class="image"><img src="' + window.myrespath + '/photo/' + bb.id + '/0.png" alt="" height="100" width="74"></div><div class="title"><a href="detail.html">' + //100 74
            bb.address + '</a></div>' +
            '<div class="area"><span class="key">Тип:</span><span class="value">&nbsp;' + bb.type.toLowerCase() + '</span></div>' +
            '<div class="area"><span class="key">Формат:</span><span class="value">&nbsp;' + bb.format.toLowerCase() + '</span></div>' + '' +
            '<div class="price">' + bb.price +' руб.</div><div class="link"><a href="bb/' + bb.id +'">Подробнее...</a></div></div>',

	        disableAutoPan: false,
	        maxWidth: 0,
	        pixelOffset: new google.maps.Size(-146, -190),
	        zIndex: null,
	        closeBoxURL: "",
	        infoBoxClearance: new google.maps.Size(1, 1),
	        position: new google.maps.LatLng(location[0], location[1]),
	        isHidden: false,
	        pane: "floatPane",
	        enableEventPropagation: false
	    };
	    marker.infobox = new InfoBox(myOptions);
		marker.infobox.isOpen = false;

	    var myOptions = {
	        draggable: true,
			content: '<div class="marker"><div class="marker-inner"></div></div>',
			disableAutoPan: true,
			pixelOffset: new google.maps.Size(-21, -58),
			position: new google.maps.LatLng(location[0], location[1]),
			closeBoxURL: "",
			isHidden: false,
			// pane: "mapPane",
			enableEventPropagation: true
	    };
	    marker.marker = new InfoBox(myOptions);
		marker.marker.open(map, marker);
		markers.push(marker);

        google.maps.event.addListener(marker, "click", function (e) {
            var curMarker = this;
            $.each(markers, function (index, marker) {
                // if marker is not the clicked marker, close the marker
                if (marker !== curMarker) {
                    marker.infobox.close();
                    marker.infobox.isOpen = false;
                }
            });
            if(curMarker.infobox.isOpen === false) {
                curMarker.infobox.open(map, this);
                curMarker.infobox.isOpen = true;
                map.panTo(curMarker.getPosition());
            } else {
                curMarker.infobox.close();
                curMarker.infobox.isOpen = false;
            }
        });
        bb.marker = marker;
    });
    if(window.afterInitMap) {
        window.afterInitMap();
    }
}

function InitMap() {
    if($("#map").length > 0) {
	    google.maps.event.addDomListener(window, 'load', LoadMap);
    } else {
        console.log("no map")
    }
}