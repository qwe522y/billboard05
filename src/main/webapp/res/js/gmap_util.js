function findLocation(address, f) {
    console.log("findLocation " + address);
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({'address': address}, function (response) {
        f(response[0].geometry.location);
    });
}

function changeZoomMode() {
    if (map.scrollWheelZoomEnabled()) {
        map.disableScrollWheelZoom();
    } else {
        map.enableScrollWheelZoom();
    }
}
