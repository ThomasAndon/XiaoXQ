var thisstring = document.getElementById("texter").value;
var orderarray = JSON.parse(thisstring);



//下列为Test用途
// var testString = '[{"OrderID":1,"CustomerID":1,"Commodities":[{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":1,"Name":"Electronic organ1","Price":1400,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":1},{"CommodityId":5,"Name":"Electronic organ5","Price":1500,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":3},{"CommodityId":13,"Name":"Electronic organ13","Price":1300,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":3}],"TotalPrice":2900,"State":"completed","OrderTime":"7月 2, 2018"},{"OrderID":11,"CustomerID":1,"Commodities":[{"CommodityId":11,"Name":"Electronic organ1","Price":1300,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":3}],"TotalPrice":1300,"State":"completed","OrderTime":"5月 4, 2019"},{"OrderID":11,"CustomerID":1,"Commodities":[{"CommodityId":11,"Name":"Electronic organ1","Price":1300,"TheColor":"white","TheClass":"61 keys Electronic organ","Instructions":"One year warranty","UserId":3}],"TotalPrice":1300,"State":"completed","OrderTime":"5月 4, 2019"}]';
// var testorray = JSON.parse(testString);


var vue = new Vue({
    el: '#app',
    data:{
        msg: 'hello',
        orray: orderarray,
    }
});

