var login_selected = true;

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