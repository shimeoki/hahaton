console.log("working")

var satelites = document.querySelector(".satelites")
var button = document.getElementById("add")

var view_icon = `
<div style = "width: 75px; height: 75px;">
<?xml version="1.0" encoding="utf-8"?>
<!-- Generator: Adobe Illustrator 26.4.1, SVG Export Plug-In . SVG Version: 6.00 Build 0)  -->
<svg version="1.1" id="Eye_Icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
     viewBox="0 0 1000 1000" style="enable-background:new 0 0 1000 1000;" xml:space="preserve">
<style type="text/css">
    .st0{fill:#191923;}
</style>
<path class="st0" d="M500,255C200,255,80,500,80,500s120,245,420,245s420-245,420-245S800,255,500,255z M500,696.88
    c-108.73,0-196.88-88.14-196.88-196.88S391.27,303.12,500,303.12S696.88,391.27,696.88,500S608.73,696.88,500,696.88z"/>
<circle class="st0" cx="500" cy="500" r="121.25"/>
</svg>
</div>
`
var view_text = "Просмотр"

var order_icon = `
<div style = "width: 50px; height: 50px;">
<?xml version="1.0" encoding="UTF-8"?>
<svg id="Order_Icon_New" data-name="Order Icon New" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 821 813.33">
  <defs>
    <style>
      .cls-1 {
        fill: #191923;
      }
    </style>
  </defs>
  <path class="cls-1" d="M134.39,17.42C60.17,17.42,0,80.44,0,158.19V795.92H686.61c74.22,0,134.39-63.02,134.39-140.77V17.42H134.39Zm395.8,692.98h-248.81c-11.85,0-21.46-10.83-21.46-24.19s9.61-24.19,21.46-24.19h248.81c11.85,0,21.46,10.83,21.46,24.19s-9.61,24.19-21.46,24.19Zm64.91-139.77H216.47c-11.85,0-21.46-10.83-21.46-24.19s9.61-24.19,21.46-24.19h378.63c11.85,0,21.46,10.83,21.46,24.19s-9.61,24.19-21.46,24.19Zm32.45-139.77H184.01c-11.85,0-21.46-10.83-21.46-24.19s9.61-24.19,21.46-24.19h443.53c11.85,0,21.46,10.83,21.46,24.19s-9.61,24.19-21.46,24.19Zm32.45-139.77H151.56c-11.85,0-21.46-10.83-21.46-24.19s9.61-24.19,21.46-24.19h508.44c11.85,0,21.46,10.83,21.46,24.19s-9.61,24.19-21.46,24.19Zm42.58-139.77H118.42c-11.85,0-21.46-10.83-21.46-24.19s9.61-24.19,21.46-24.19H702.58c11.85,0,21.46,10.83,21.46,24.19s-9.61,24.19-21.46,24.19Z"/>
</svg>
</div>
`

var order_text = "Заказ"

var order_selected = true

$(".view,.order").on("click", function(){
    var text = $(this).html()
    console.log(123)
    if (text.length > 20) {
        if(order_selected){
            $(this).html(view_text)
            $(".order").html(order_icon)
            $(".order").removeClass("order").addClass("view")
            $(this).removeClass("view").addClass("order")
        } else {
            $(this).html(order_text)
            $(".order").html(view_icon)
            $(".order").removeClass("order").addClass("view")
            $(this).removeClass("view").addClass("order")
        }
        $(".satelites").toggleClass("hidden")
        order_selected = !order_selected
    };
})


$(".login").on("click", function(){
    $(".user").toggleClass("hidden")
    $(".login").toggleClass("active")
    if($(".login-signup").hasClass("shown")) {
        $(".login-signup").removeClass("shown")
    } else {
        $(".login-signup").addClass("shown")
    }
})


var login_selected = true;

$(".selection span").on("click", function(){
    
    if(!$(this).hasClass("selected")) {
        $(".selection span").removeClass("selected")
        $(this).addClass("selected")
        $(".login-signup form").removeClass("hidden")
        if(login_selected) {
            $(".login-signup form:nth-child(2)").addClass("hidden")
        } else {
            $(".login-signup form:nth-child(3)").addClass("hidden")
        }
        login_selected = !login_selected
        console.log(login_selected)
    }
})



$("#add").on("click", ()=>{
    var satelite = document.createElement("div")
    satelite.classList.add("satelite");
    satelite.innerHTML = `
        <div class="field">
            <label for="name">Название</label>
            <input type="text" name="angle1" id="angle2" value = "" placeholder="Спутник V">
        </div>
        <div class="field">
            <label for="angle1">Угол 1</label>
            <input type="number" name="angle1" id="angle2" value = "" placeholder="40">
        </div>

        <div class="field">
            <label for="longitude">Угол 2</label>
            <input type="number" name="angle2" id="angle2" value = "" placeholder="70">
        </div>

        <div class="field">
            <label for="latitude">Полуось a</label>
            <input type="number" name="latitude" id="latitude" value = "" placeholder="2">
        </div>

        <div class="field">
            <label for="longitude">Полуось b</label>
            <input type="number" name="longitude" id="longitude" value = "" placeholder="3">
        </div>
        <input type="button" value="Удалить">
    `
    button.after(satelite)
    
})
