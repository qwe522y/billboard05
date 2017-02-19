window.afterInitMap = function () {
    // установка карты так, чтобы в центре был маркер
    window.map.setCenter(new google.maps.LatLng(window.billboards[0].position[0], window.billboards[0].position[1]))
};

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