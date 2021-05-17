const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

function sendId(){
	var message = $('#idUser').val();
	$.ajax({
		url:'/users/vacunacion/'+message,
		type:'GET',
		contentType: 'application/json',
		dataType:'json',
		success: function(response){
			console.log(JSON.stringify(response));
		},
		error: function(response){
			console.log(JSON.stringify(response));
		}
	});
}


function sendUserData(){
	let dni = $('#DNI').val();
	let names = $('#names').val();
	let apellidoP = $('#apellidoPaterno').val();
	let apellidoM = $('#apellidoMaterno').val();
	let mail = $('#mail').val();
	let phone = $('#phone').val();
	let birthday = $('#birthday').val();
	var data = JSON.stringify({
		"dni": dni,
		"nombres": names,
		"apellidoP":apellidoP,
		"apellidoM":apellidoM,
		"fechaNacimiento": birthday,
		"telefono": phone,
		"correoElectronico": mail		
		});

	$.ajax({
		url:'/users/',
		type:'POST',
		contentType: 'application/json',
		data : data,
		dataType:'json',
		success: function(response){
		   console.log(JSON.stringify(response));
		},
		error: function(response){
		   console.log(JSON.stringify(response));
		}
	});
}