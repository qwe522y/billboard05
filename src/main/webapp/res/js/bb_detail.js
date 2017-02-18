window.afterInitMap = function () {
    // установка карты так, чтобы в центре был маркер
    window.map.setCenter(new google.maps.LatLng(window.billboards[0].position[0], window.billboards[0].position[1]))
};