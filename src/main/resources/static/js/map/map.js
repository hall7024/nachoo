let map;

const baseLayer = {
    Base: 'png',
    Satellite: 'jpeg'
};

const vworldApiKey = '456C8BB8-D8DB-3131-B6BE-D6D8EA49A2EC';

const fnMap = {
    init: function () {
        map = new ol.Map({
            target: 'map',
            view: new ol.View({
                center: [14126669.41589247, 4493404.190498611],
                zoom: 12,
                minZoom: 9,
                maxZoom: 19
            }),
        });

        fnMap.setBackgroundLayer('Base');
        $('#map_switch input[name=switch_map]').change(function () {
            fnMap.switchBackgroundLayer($(this).val());
        });

        map.on('singleclick', function (evt) {
            fnMap.singleClick(evt);
        });
    },
    setBackgroundLayer: function (mapIdx) {
        map.addLayer(
            new ol.layer.Tile({
                source: new ol.source.XYZ({
                    url: 'http://xdworld.vworld.kr:8080/2d/' + mapIdx + '/service/{z}/{x}/{y}.' + baseLayer[mapIdx]
                })
            })
        );

        map.addLayer(
            new ol.layer.Tile({
                source: new ol.source.XYZ({
                    url: 'http://xdworld.vworld.kr:8080/2d/Hybrid/service/{z}/{x}/{y}.png'
                })
            })
        );
    },
    switchBackgroundLayer: function (layerName) {
        $('#map_switch label').removeClass('active');
        $(this).parent('label').addClass('active');

        fnMap.setBackgroundLayer(layerName);
    },
    singleClick: function (e) {
        console.log("getProjection: " + map.getView().getProjection().getCode());
        console.log(e.coordinate);

        const params = "key=" + vworldApiKey
                     + "&domain=http://localhost:8080/map"
                     + "&request=GetFeatueInfo"
                     + "&layers=lp_pa_cbnd_bubun"
                     + "&styles=lp_pa_cbnd_bubun"
                     + "&crs=EPSG:3857"
                     + "&width=256"
                     + "&height=256"
                     + "&info_format=application/json"
                     + "&i=" + e.coordinate[0]
                     + "&j=" + e.coordinate[1];
                     /*+ "&exceptions=application/json";*/

        $.ajax({
            type: 'GET',
            url: "http://api.vworld.kr/req/wms?" + params,
            dataType: "jsonp",
            success: function (data) {
                console.log(data);
            },
            error: function (xhr, status, error) {
                console.log(xhr);
                console.log(status);
                console.log(error);
            }
        });
    },
    setLocation: function (x, y) {
        alert("x: " + x + ", y: " + y);
    }
}

fnMap.init();
