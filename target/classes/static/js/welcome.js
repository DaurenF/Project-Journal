let current_date = new Date();
let expiring_date=new Date();
expiring_date.setDate(current_date.getDate() - 10);
let user_info;
const getInfo = async () => {
    const response = await fetch("/api/get_info_after_perm");
    const data = await response.json();
    user_info = data;
    return data;
};

const getData = async () => {
    const response = await fetch("/api/get_exp_date");
    const data = await response.json();
    expiring_date.setDate(new Date(data['year'], data['month'], data['day']).getDate());
    return data;
};

(async () => {
    await getData();
    let ask_button = document.getElementById("ask_permis_btn");
    let wrapper_info = document.getElementById("wrapper_info");
    let weather = document.getElementById("weather");
    let localDate = document.getElementById("date");
    let loc = document.getElementById("location");
    console.log('exp:' + expiring_date);
    console.log('curr:' + current_date);

    if(expiring_date<current_date){
        console.log('da');
        ask_button.addEventListener("click", myFunction);
        async function myFunction() {
            await getInfo();
            setTimeout( saveInfo(),300)

        }
        function saveInfo(){
            console.log('ba');
            weather.style.display = 'block';
            ask_button.style.display = 'hidden';
            console.log('user_info: ' + user_info['weather']);
            weather.innerHTML = user_info['weather'];
            loc.innerHTML = user_info['location'];
            localDate.innerHTML = user_info['date'];
        }
    }
    if(expiring_date>current_date){
        weather.style.display='block';
        ask_button.style.display='hidden';
    }


})();
ask_button.style.display = 'hidden';




