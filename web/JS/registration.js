/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validator(field, errfield) {
    var a = document.getElementById(field);
    var b = document.getElementById(errfield);
    if (a.value == "") {
        b.innerHTML = "<html><h style='color:red;'>filled should not be empty</h></html>";
    } else {
        b.innerHTML = "";
    }
}
function  aCaller(id, sid) {
    var data = document.getElementById(id).value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                document.getElementById(sid).innerHTML = xhr.responseText;
            }
        }
    }
    xhr.open("get", "/E-Commerce/fc/?page=AvailabilityCheck&type=model&email=" + data, true);
    xhr.send(null);
}


