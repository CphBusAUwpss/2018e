// @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 24, 2016 
//This is NOT RELEVANT to the httpdemo project (used for security slides)
var form = document.getElementById("form");
form.onsubmit = function(){
    var email = document.getElementById("email").value;
    if(validateEmail(email))
        return true;
    else return false;
};
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}


