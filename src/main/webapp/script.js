'use strict';

// Setters for document elements
//-----------------------------------------------------------------

let cityName = "";
let cityTitle = document.getElementById("card-title-chosen");
let cityImage = document.getElementById("card-title-standard-one");
let cityDesc = document.getElementById("card-title-standard-one");
let cityPrecip = document.getElementById("card-title-standard-one");
let cityWind = document.getElementById("card-title-standard-one");
let cityCloud = document.getElementById("card-title-standard-one");

let cityTitle1 = document.getElementById("card-title-standard-one");
let cityTitle2 = document.getElementById("card-title-standard-two");
let cityTitle3 = document.getElementById("card-title-standard-three");

let cityImage1 = document.getElementById("card-img-standard-one");
let cityImage2 = document.getElementById("card-img-standard-two");
let cityImage3 = document.getElementById("card-img-standard-three");

let cityDesc1 = document.getElementById("card-desc-standard-one");
let cityDesc2 = document.getElementById("card-desc-standard-two");
let cityDesc3 = document.getElementById("card-desc-standard-three");

let cityTemp1 = document.getElementById("card-temp-standard-one");
let cityTemp2 = document.getElementById("card-temp-standard-two");
let cityTemp3 = document.getElementById("card-temp-standard-three");

let cityPrecip1 = document.getElementById("card-precip-standard-one");
let cityPrecip2 = document.getElementById("card-precip-standard-two");
let cityPrecip3 = document.getElementById("card-precip-standard-three");

let cityWind1 = document.getElementById("card-wind-standard-one");
let cityWind2 = document.getElementById("card-wind-standard-two");
let cityWind3 = document.getElementById("card-wind-standard-three");

let cityCloud1 = document.getElementById("card-cloud-standard-one");
let cityCloud2 = document.getElementById("card-cloud-standard-two");
let cityCloud3 = document.getElementById("card-cloud-standard-three");





// Listening for city input
//-----------------------------------------------------------------
document.getElementById('form-inline my-2 my-lg-0').addEventListener('submit', function (e) {
    e.preventDefault();
    cityName = inputValues[i].value;
    if (cityName) {
        // TODO
    } else {
        // TODO
    }
})

// Refresh => fetching new values for card weather
//-----------------------------------------------------------------
document.getElementById("btn btn-primary refresh").addEventListener("click", function() {
    location.reload();
});

// Setting values for elements
//-----------------------------------------------------------------

