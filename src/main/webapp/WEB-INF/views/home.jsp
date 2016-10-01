<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Billboard05</title>
    <script src="//api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script>
        ymaps.ready(init);

        function init () {
            var myMap = new ymaps.Map("map", {
                        center: [42.975182, 47.503995],
                        zoom: 14
                    }, {
                        searchControlProvider: 'yandex#search'
                    }),

                    // Создаем геообъект с типом геометрии "Точка".
                    myGeoObject = new ymaps.GeoObject({
                        // Описание геометрии.
                        geometry: {
                            type: "Point",
                            coordinates: [55.8, 37.8]
                        },
                        // Свойства.
                        properties: {
                            // Контент метки.
                            iconContent: 'Я тащусь',
                            hintContent: 'Ну давай уже тащи'
                        }
                    }, {
                        // Опции.
                        // Иконка метки будет растягиваться под размер ее содержимого.
                        preset: 'islands#blackStretchyIcon',
                        // Метку можно перемещать.
                        draggable: true
                    });

            myMap.geoObjects
                    .add(new ymaps.Placemark([42.975182, 47.503995], {
                        balloonContent: 'ЗЕЛЕНАЯ ТОЧКА'
                    }));
        }
    </script>
    <style>
        html, body, #map {
            width: 100%; height: 100%; padding: 0; margin: 0;
        }
    </style>
</head>
<body>
    <a href="agent/">Личный кабинет агента</a>
    <div id="map"></div>

</body>
</html>
