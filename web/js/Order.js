var thisstring = document.getElementById("text").value;
var orderarray = JSON.parse(thisstring);

var vue = new Vue({
    el: '#app',
    data:{
        msg: 'hello',
        orray: orderarray,
    }
});

