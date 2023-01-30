let send = document.getElementById("send");
let username = document.getElementById("username");
let password = document.getElementById("password");
let token = "";

send.addEventListener('click', pressSendAndFetchLogin);

async function login(username, password) {
    const response = await fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password }),
    });
    const data = await response.json();
    if (!response.ok) {
        throw new Error(data.message);
    }
    return data['jwt-token'];
}

function pressSendAndFetchLogin(){
    var temp = login(username.value,password.value);
    temp.then((data) => token = data, sout);
}

function sout(){
    console.log(token)
}

