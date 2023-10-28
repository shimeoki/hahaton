

var map = L.map('map').setView([0, 90], 4); // Replace the coordinates and zoom level
  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);
  map.zoomControl.setPosition('bottomright');
var latitudeInput = document.getElementById("latitude");
var longitudeInput = document.getElementById("longitude");
var radiusInput = document.getElementById("radius");
var lastLatitudeValue = 0;
var lastLongitudeValue = 0;
var lastRadiusValue = 1;
map.setView([40, 50], 3);

var circle = L.circle([lastLatitudeValue, lastLongitudeValue], {
    color: 'red',    // Circle border color
    fillColor: 'blue', // Circle fill color
    fillOpacity: 0.3, // Opacity of the fill
    radius: 0      // Radius of the circle in meters
}).addTo(map);

// Add a popup to the circle
//circle.bindPopup("I am a circle!");

$("#latitude").on("change keyup paste click", function(){
    change()
})
$("#longitude").on("change keyup paste click", function(){
    change()
})
$("#radius").on("change keyup paste click", function(){
    change()
})


function change() {
        if (latitudeInput.value == "") {
            lastLatitudeValue = 0
        } else {
            lastLatitudeValue = parseFloat(latitudeInput.value);
        }

        if (longitudeInput.value == "") {
            lastLongitudeValue = 0
        } else {
            lastLongitudeValue = parseFloat(longitudeInput.value);
        }

        if (radiusInput.value == "") {
            lastRadiusValue = 0
        } else {
            lastRadiusValue = parseFloat(radiusInput.value);
        }
        
        if(lastRadiusValue == 0) {
            var zoom = 4
        } else {
            const earthRadius = 6378137; // Earth's radius in meters

            var pixelsRequired = (lastRadiusValue * 2) / (earthRadius * 2 * Math.PI) * window.innerWidth;
            var zoom = Math.log2(window.innerWidth / pixelsRequired);
        }
        map.setView([lastLatitudeValue, lastLongitudeValue], zoom);

    circle.setLatLng([lastLatitudeValue, lastLongitudeValue]);
    circle.setRadius(lastRadiusValue);
}
