let current_date = new Date();

let user_info='user info';
let ask_button = document.getElementById("ask_permis_btn");
let wrapper_info = document.getElementById("wrapper_info");
let weather = document.getElementById("weather");
let localDate = document.getElementById("date");
let loc = document.getElementById("location");
ask_button.addEventListener('click', doGetRequestAndCallPutData);
function doGetRequestAndCallPutData(){
    fetch("/api/get_info_after_perm")
        .then(response => response.json())
        .then(data => {
            putData(data);
        });
}
function putData(data){
    ask_button.style.display = 'none';
    wrapper_info.style.visibility = 'visible';
    console.log(data['date']);
    console.log(data['location']);
    localDate.textContent ='LocalDate: '+data['date'];
    loc.textContent= 'City: '+data['location'];
    weather.textContent ='Current temperature: '+data['weather']+'C  ';


}





/*let ask_button = document.getElementById("ask_permis_btn");

    console.log('exp:' + expiring_date);
    console.log('curr:' + current_date);

    function saveInfo(){
            console.log('ba');
            weather.style.display = 'block';
            ask_button.style.display = 'hidden';
            console.log('user_info: ' + user_info['weather']);
            weather.innerHTML = user_info['weather'];
            loc.innerHTML = user_info['location'];
            localDate.innerHTML = user_info['date'];
        }

           if(expiring_date<current_date){
        console.log('da');
        ask_button.addEventListener("click", myFunction);


    }
    if(expiring_date>current_date){
        weather.style.display='block';
        ask_button.style.display='hidden';
    }
    */