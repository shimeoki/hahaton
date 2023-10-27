
$(".profile").on("click", function(){
    if($(".login-signup").hasClass("shown")) {
        $(".login-signup").removeClass("shown")
    } else {
        $(".login-signup").addClass("shown")
    }
})