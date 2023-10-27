
$(".profile").on("click", function(){
    if($(".login-signup").hasClass("shown")) {
        $(".login-signup").removeClass("shown")
    } else {
        $(".login-signup").addClass("shown")
    }
})

$(".selection span").on("click", function(){
    if(!$(this).hasClass("selected")) {
        $(".selection span").removeClass("selected")
        $(this).addClass("selected")
    }
})