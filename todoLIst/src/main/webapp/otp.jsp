<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>





   
    <style>
   body {
    background-color: #15202B
}

.height-100 {
    height: 100vh
}

.card {
    width: 400px;
    border: none;
    height: 300px;
    box-shadow: 0px 5px 20px 0px #d2dae3;
    z-index: 1;
    display: flex;
    justify-content: center;
    align-items: center
}

.card h6 {
    color: red;
    font-size: 20px
}

.inputs input {
    width: 40px;
    height: 40px
}

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0
}

.card-2 {
    background-color: #fff;
    padding: 10px;
    width: 350px;
    height: 100px;
    bottom: -50px;
    left: 20px;
    position: absolute;
    border-radius: 5px
}

.card-2 .content {
    margin-top: 50px
}

.card-2 .content a {
    color: red
}

.form-control:focus {
    box-shadow: none;
    border: 2px solid red
}

.validate {
    border-radius: 20px;
    height: 40px;
    background-color: red;
    border: 1px solid red;
    width: 140px
}
    </style>
</head>
<body>

<form action="Otp" method="post">
<div class="container height-100 d-flex justify-content-center align-items-center">
    <div class="position-relative">
        <div class="card p-2 text-center">
            <h6>Please enter the one time password <br> to verify your account</h6>
            <div> <span>A code has been sent to</span> <small>your gmail account</small> </div>
            <div id="otp" class="inputs d-flex flex-row justify-content-center mt-2"> 
                <input value=0 class="m-2 text-center form-control rounded" type="text" id="first" maxlength="1" name="first"/> 
                <input value=0 class="m-2 text-center form-control rounded" type="text" id="second" maxlength="1" name="second" /> 
                <input value=0 class="m-2 text-center form-control rounded" type="text" id="third" maxlength="1" name="third" /> 
                <input value=0 class="m-2 text-center form-control rounded" type="text" id="fourth" maxlength="1" name="fourth" /> 
                <input value=0 class="m-2 text-center form-control rounded" type="text" id="fifth" maxlength="1" name="fifth" /> 
                <input  class="m-2 text-center form-control rounded" type="text" id="sixth" maxlength="1" name="sixth" /> </div>
            <div class="mt-4"> <button onclick="fun()" class="btn btn-danger px-4 validate">Validate</button> </div>
        </div>
        <div class="card-2">
            <div class="content d-flex justify-content-center align-items-center"> <span>Didn't get the code</span> <a href="#" class="text-decoration-none ms-3">Go back</a> </div>
        </div>
    </div>
</div>
</form>
<script>
document.addEventListener("DOMContentLoaded", function(event) {
	function OTPInput() {
		const inputs = document.querySelectorAll('#otp > *[id]');
		for (let i = 0; i < inputs.length; i++) { inputs[i].addEventListener('keydown', function(event) { if (event.key==="Backspace" ) { inputs[i].value='' ; if (i !==0) inputs[i - 1].focus(); } else { if (i===inputs.length - 1 && inputs[i].value !=='' ) { return true; } else if (event.keyCode> 47 && event.keyCode < 58) { inputs[i].value=event.key; if (i !==inputs.length - 1) inputs[i + 1].focus(); event.preventDefault(); } else if (event.keyCode> 64 && event.keyCode < 91) { inputs[i].value=String.fromCharCode(event.keyCode); if (i !==inputs.length - 1) inputs[i + 1].focus(); event.preventDefault(); } } }); } } OTPInput(); });
function fun(){
var otp = (document.getElementById("first").value+document.getElementById("second").value+document.getElementById("third").value+document.getElementById("fourth").value+document.getElementById("fifth").value+document.getElementById("sixth").value);

 
}


</script>

</body>
</html>