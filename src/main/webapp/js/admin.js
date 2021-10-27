window.addEventListener('load', (event) => {
  var container2 = document.getElementById('popup2');
    var content2 = document.getElementById('popup-content2');
    var closer2 = document.getElementById('popup-closer2');

    var overlay2 = new ol.Overlay({
        element: container2,
        autoPan: true,
        autoPanAnimation: {
            duration: 250
        }
    });
    map.addOverlay(overlay2);
    
    closer2.onclick = function() {
        overlay2.setPosition(undefined);
        closer2.blur();
        return false;
     };

      map.on('click', function(e){

        var coordinate = e.coordinate;
        content2.innerHTML = `<b id="cx">${coordinate[0]}</b><br>`;
        content2.innerHTML += `<b id="cy">${coordinate[1]}</b>`;
        overlay2.setPosition(coordinate);
        map.forEachFeatureAtPixel(e.pixel, function(){
          overlay2.setPosition(undefined);
        })
      })
})


function showData(){
    var cont = document.getElementById("admincontainer");
    var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        cont.innerHTML=xhr.responseText;
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'PointList');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send();
    
}

function editbtn(){
    var name=document.getElementById("name123").innerHTML;
    //alert(name);
    var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        //alert("done");
        document.getElementById("editCont").innerHTML = xhr.responseText;
        document.getElementById("Edit").style.display = "block";
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'findEdit');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("name="+name);
}

function delbtn(){
    var name=document.getElementById("name123").innerHTML;
    //alert(name);
    var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        //alert("done");
        location.reload();
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'deletePoint');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("name="+name);
}

function edit1(name){
    //alert(name);
    var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        //alert("done");
        document.getElementById("editCont").innerHTML = xhr.responseText;
        document.getElementById("Edit").style.display = "block";
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'findEdit');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("name="+name);
}

function del1(name){
    //alert(name);
    var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        //alert("done");
        location.reload();
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'deletePoint');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("name="+name);
}

function editclose(){
    document.getElementById("Add").style.display = "none";
    document.getElementById("Edit").style.display = "none";
    document.getElementById("editCont").innerHTML = "";
}

function addopen(){
    document.getElementById("Add").style.display = "block";
}

function addPoint(){
    var cont = document.getElementById("admincontainer2");

    var name = document.getElementById("pname").value;
    //alert(name);
    var type = document.getElementById("ptype").value;
    var x = document.getElementById("px").value;
    var y= document.getElementById("py").value;
    var addr = document.getElementById("padd").value; 
    var hours= document.getElementById("phours").value; 
    var phone= document.getElementById("ptel").value; 
    var site = document.getElementById("psite").value; 
    var img = document.getElementById("pimg").value; 
    var info = document.getElementById("pinfo").value; 

    var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        document.getElementById("Add").style.display = "none";
        cont.innerHTML=xhr.responseText;
        location.reload();
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'addPoint');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("name="+name+"&type="+type+"&x="+x+"&y="+y+"&addr="+addr+"&hours="+hours+"&phone="+phone+"&site="+site+"&img="+img+"&info="+info);
}

function updatePoint(name1){

  var cont = document.getElementById("admincontainer2");

  var name = document.getElementById("pname1").value;
  var type = document.getElementById("ptype1").value;
  var x = document.getElementById("px1").value;
  var y= document.getElementById("py1").value;
  var addr = document.getElementById("padd1").value; 
  var hours= document.getElementById("phours1").value; 
  var phone= document.getElementById("ptel1").value; 
  var site = document.getElementById("psite1").value; 
  var img = document.getElementById("pimg1").value; 
  var info = document.getElementById("pinfo1").value; 

  var xhr = new XMLHttpRequest();
    xhr.onload = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      document.getElementById("Edit").style.display = "none";
      //cont.innerHTML=xhr.responseText;
      location.reload();
    } 
    else if (xhr.status != 200) {
      alert('Request failed. Returned status of ' + xhr.status);
    }
    };
    xhr.open('POST', 'updatePoint');
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("name1="+name1+"&name="+name+"&type="+type+"&x="+x+"&y="+y+"&addr="+addr+"&hours="+hours+"&phone="+phone+"&site="+site+"&img="+img+"&info="+info);
}


function addPointHere(){
    var x = document.getElementById("cx").innerText;
    var y = document.getElementById("cy").innerText;

    //alert(x);
    //alert(y);
    document.getElementById("Add").style.display = "block";

    document.getElementById("px").value = x;
    document.getElementById("py").value = y;
}
