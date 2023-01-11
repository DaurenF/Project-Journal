let ask_button = document.getElementById("ask_permis_btn");
let current_date = new Date();
let expiring_date = current_date;
expiring_date.setDate(current_date.getDate() + 14);
console.log(expiring_date);
