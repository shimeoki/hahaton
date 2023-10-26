var map = L.map('map').setView([0, 90], 4); // Replace the coordinates and zoom level
  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(map);
var latitudeInput = document.getElementById("latitude");
var longitudeInput = document.getElementById("longitude");
var radiusInput = document.getElementById("radius");
var lastLatitudeValue = 0;
var lastLongitudeValue = 0;
var lastRadiusValue = 0;

var circle = L.circle([lastLatitudeValue, lastLongitudeValue], {
    color: 'red',    // Circle border color
    fillColor: 'blue', // Circle fill color
    fillOpacity: 0.5, // Opacity of the fill
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


    map.setView([lastLatitudeValue, lastLongitudeValue], 4);

    circle.setLatLng([lastLatitudeValue, lastLongitudeValue]);
    circle.setRadius(lastRadiusValue);
}
