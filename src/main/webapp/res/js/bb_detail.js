$(function () {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: window.billboards[0].position[0], lng: window.billboards[0].position[1]},
        zoom: 14
    });
    var marker = new google.maps.Marker({
        position: {lat: window.billboards[0].position[0], lng: window.billboards[0].position[1]},
        map: map,
        icon: window.myrespath + '/meforest/img/marker.png'
    });
});

$(function () { //карусель
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
});