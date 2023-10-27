
$(".profile").on("click", function(){
    if($(".login-signup").hasClass("shown")) {
        console.log("wtf")
        $(".login-signup").removeClass("shown")
    } else {
        $(".login-signup").addClass("shown")
    }
})