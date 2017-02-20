function refilter() {
    // Горячие предложения
    filtered_bb_list = filter_bb()
    for(i=0; i<5; i++) {
        if(filtered_bb_list.length == 0) break;

        bb = filtered_bb_list[i % filtered_bb_list.length];
        $("#price_" + i).html(bb.price + " p.");
        $("#city_" + i).html(bb.city);
        $("#type_" + i).html(bb.type);
        $("#details_" + i).attr("href", "bb/" + bb.id + "/");
        $("#photo_" + i).attr("src", window.myrespath + "photo/" + bb.id + "/0.png" )
        nameEl = $("#name_" + i);
        nameEl.html(bb.address);
        nameEl.attr("href", "bb/" + bb.id + "/");

        $("#side_price_" + i).html(bb.price + " p.");
        $("#side_city_" + i).html(bb.city);
        $("#height_" + i).html(bb.height);
        $("#width_" + i).html(bb.width);
        $("#side_details_" + i).attr("href", "bb/" + bb.id + "/");
        $("#side_photo_" + i).attr("src", window.myrespath + "photo/" + bb.id + "/0.png" )
        nameEl = $("#side_name_" + i);
        nameEl.html(bb.address);
        nameEl.attr("href", "bb/" + bb.id + "/")
    }
}

function filter_bb() {
    return billboards.filter(function(bb) {
        allWord = "Все";
        if(bb.city !=  $("#inputLocation").find("option:selected").text()) {
            return false;
        }

        type = $("#inputType").find("option:selected").text();
        if(type != allWord && type != bb.type) {
            return false;
        }

        format = $("#inputFormat").find("option:selected").text();
        if(format != allWord && format != bb.format) {
            return false;
        }

        if(bb.price < Number(window.inputPriceFrom_val) || bb.price > Number(window.inputPriceTo_val)) {
            return false;
        }
        return true;
    });
}

$(function () {
    $("#inputLocation").change(refilter);
    $("#inputType").change(refilter);
    $("#inputFormat").change(refilter);
    refilter();
    window.setInterval(function () {
        from = $("#inputPriceFrom").val();
        to = $("#inputPriceTo").val();
        if(window.inputPriceFrom_val != from || window.inputPriceTo_val != to) {
            window.inputPriceFrom_val = from;
            window.inputPriceTo_val = to;
            console.log("rent filter from",from, "to", to );
            refilter();
        }
    }, 500);refilter();
});