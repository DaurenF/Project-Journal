let current_date = new Date();
let expiring_date=new Date();
expiring_date.setDate(current_date.getDate() - 10);
let user_info;
let ask_button = document.getElementById("ask_permis_btn");
ask_button.addEventListener("click", getMe);
function getMe(){
    console.log("getme");
}
ask_button.style.display = 'hidden';






