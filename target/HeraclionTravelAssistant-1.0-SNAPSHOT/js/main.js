var map;
let points=[]
var barLayer;
var sightLayer;
var hotelLayer;
var foodLayer;
var pharmaLayer;
var beachLayer;
var random;
var markerVectorLayer1;
window.addEventListener('load', (event) => {
    //console.log('The page has fully loaded');

     map = new ol.Map({
        target: 'map',
        layers: [
          new ol.layer.Tile({
            source: new ol.source.OSM()
          }),
        ],
        view: new ol.View({
            center: [2800518.7510531046, 4207705.424763296],
            zoom: 13,
            //maxZoom : 16,
            //minZoom : 14
        })
    });


    random = new ol.style.Style({
        image: new ol.style.Icon({
          anchor: [0.5, 1],
          anchorXUnits: 'fraction',
          anchorYUnits: 'fraction',
          src: '//www.gstatic.com/images/icons/material/system_gm/1x/place_gm_blue_24dp.png',
        })
      });

      const fillstyle = new ol.style.Fill({
        color: [0, 0, 0, 1]
      });

      const strokeStyle = new ol.style.Stroke({
        color: [0, 0, 0, 1],
        width: 1
      });

      const foodStyle = new ol.style.Circle({
        fill : new ol.style.Fill({
          color: [243, 114, 44, 1]
        }),
        radius : 7,
        stroke : strokeStyle
      });

      const sightStyle = new ol.style.Circle({
        fill : new ol.style.Fill({
          color: [38, 70, 83, 1]
        }),
        radius : 7,
        stroke : strokeStyle
      });

      const hotelStyle = new ol.style.Circle({
        fill : new ol.style.Fill({
          color: [249, 65, 68, 1]
        }),
        radius : 7,
        stroke : strokeStyle
      });

      const barStyle = new ol.style.Circle({
        fill : new ol.style.Fill({
          color: [229, 229, 229, 1]
        }),
        radius : 7,
        stroke : strokeStyle
      });

      const pharmaStyle = new ol.style.Circle({
        fill : new ol.style.Fill({
          color: [42, 157, 143,1]
        }),
        radius : 7,
        stroke : strokeStyle
      });

      const beachStyle = new ol.style.Circle({
        fill : new ol.style.Fill({
          color: [0, 150, 199,1]
        }),
        radius : 7,
        stroke : strokeStyle
      });


      var sightVect = new ol.source.Vector({});
       sightLayer = new ol.layer.Vector({
        style : new ol.style.Style({
          fill : fillstyle,
          stroke : strokeStyle,
          image : sightStyle
        })
      });

      var foodVect = new ol.source.Vector({});
       foodLayer = new ol.layer.Vector({
        style: new ol.style.Style({
          fill : fillstyle,
          stroke : strokeStyle,
          image : foodStyle
        })
      });

      var hotelVect = new ol.source.Vector({});
       hotelLayer = new ol.layer.Vector({
        style: new ol.style.Style({
          fill : fillstyle,
          stroke : strokeStyle,
          image : hotelStyle
        })
      });

      var barVect = new ol.source.Vector({});
         barLayer = new ol.layer.Vector({
        style: new ol.style.Style({
          fill : fillstyle,
          stroke : strokeStyle,
          image : barStyle
        })
      });

      var pharmaVect = new ol.source.Vector({});
       pharmaLayer = new ol.layer.Vector({
        style: new ol.style.Style({
          fill : fillstyle,
          stroke : strokeStyle,
          image : pharmaStyle
        })
      });

      var beachVect = new ol.source.Vector({});
       beachLayer = new ol.layer.Vector({
        style: new ol.style.Style({
          fill : fillstyle,
          stroke : strokeStyle,
          image : beachStyle
        })
      });

      const feat = [];
      var length;

      var xhr = new XMLHttpRequest();
      xhr.onload = function () {
          if (xhr.readyState === 4 && xhr.status === 200) {
            resp = xhr.responseText;
            json = JSON.parse(resp);
            length = json.length;
            //console.log(json);

            for(var i=0; i<json.length; i++){
              
                feat[i] = new ol.Feature({
                geometry: new ol.geom.Point([json[i].x, json[i].y]),
                name: json[i].name,
                type: json[i].type
              });

              //console.log(feat[i]);

              if(json[i].type == "Sight"){
                sightVect.addFeature(feat[i]);
              }
              else if(json[i].type == "Hotel"){
                hotelVect.addFeature(feat[i]);
              }
              else if(json[i].type == "food"){
                foodVect.addFeature(feat[i]);
              }
              else if(json[i].type == "Cafe"){
                barVect.addFeature(feat[i]);
              }
              else if(json[i].type == "Pharma"){
                pharmaVect.addFeature(feat[i]);
              }
              else if(json[i].type == "Beach"){
                beachVect.addFeature(feat[i]);
              }
              //console.log(json[i].type);
            }

            sightLayer.setSource(sightVect);
            map.addLayer(sightLayer);

            hotelLayer.setSource(hotelVect);
            map.addLayer(hotelLayer);

            foodLayer.setSource(foodVect);
            map.addLayer(foodLayer);

            barLayer.setSource(barVect);
            map.addLayer(barLayer);

            pharmaLayer.setSource(pharmaVect);
            map.addLayer(pharmaLayer);

            beachLayer.setSource(beachVect);
            map.addLayer(beachLayer);

          } else if (xhr.status != 200) {
              alert('Request failed. Returned status of ' + xhr.status);
          }
      };
      xhr.open('GET', 'init');
      xhr.send();

      
    var container = document.getElementById('popup');
    var content = document.getElementById('popup-content');
    var closer = document.getElementById('popup-closer');

    var more = document.getElementById('more');
    var sidenav = document.getElementById('side');
    var sideCloser= document.getElementById('side-closer');
    var sidenavcont = document.getElementById('sidecont')
    //sidenav.style.display="none";
    var opener = document.getElementById("opener");

    more.addEventListener("click", function(){
        map.removeLayer(markerVectorLayer1);  
        var name = document.getElementById("popup-content").innerText;
        //console.log(name);
        var xhr = new XMLHttpRequest();
        xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
          sidenavcont.innerHTML=xhr.responseText;
        } 
        else if (xhr.status != 200) {
          alert('Request failed. Returned status of ' + xhr.status);
        }
        };
        xhr.open('POST', 'MoreInfo');
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.send("pointname="+name);
  
        //sidenav.style.height="100%";
        //sidenav.style.width="20%";
        sidenav.style.display="block";
        overlay.setPosition(undefined);
        closer.blur();
        return false;
      });
  
      sideCloser.addEventListener("click", function sidecloser(){
          sidenavcont.innerHTML='';
          sidenav.style.display="none";
      });

      opener.addEventListener("click", function sideopener(){
        sidenav.style.display="block";
      });
  
      var overlay = new ol.Overlay({
          element: container,
          autoPan: true,
          autoPanAnimation: {
              duration: 250
          }
      });
      map.addOverlay(overlay);
      
      closer.onclick = function() {
          overlay.setPosition(undefined);
          closer.blur();
          return false;
       };
       
       map.on('click', function(e){
  
        console.log(e.coordinate);
        
        
        map.forEachFeatureAtPixel(e.pixel, function(feature, layer){
          //console.log(feature);
          var name = feature.get('name');
          var coordinate = e.coordinate;
          content.innerHTML = `<b id="name123">${name}</b>`;
          overlay.setPosition(coordinate);
        })
      })

    

      morebtn.addEventListener("click", function(){
        //document.getElementById("morebtn").style.display="none";
        //document.getElementById("lessbtn").style.display="block";
        document.getElementById("morebtns").style.display="block";
      });

      document.getElementById("lessbtn").addEventListener("click", function(){
        //document.getElementById("lessbtn").style.display="none";
        //document.getElementById("morebtn").style.display="block";
        document.getElementById("morebtns").style.display="none";
      });

      var flag = 0;

      document.getElementById("weatheropener").addEventListener("click", function(){

          weatherwidget=document.getElementById("weatherwidget");

          if(flag == 0){
            weatherwidget.style.display="block";
            flag=1;
          }
          else{
            weatherwidget.style.display="none";
            flag=0;
          }
      })


    document.getElementById("sights").addEventListener("click" ,function(){
        map.removeLayer(foodLayer);
        map.removeLayer(hotelLayer);
        map.removeLayer(sightLayer);
        map.removeLayer(barLayer);
        map.removeLayer(pharmaLayer);
        map.removeLayer(beachLayer);
        map.removeLayer(markerVectorLayer1);

        map.addLayer(sightLayer);

      var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        sidenavcont.innerHTML=xhr.responseText;
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'Filter');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("type=Sight");
    });

    document.getElementById("hotels").addEventListener("click" ,function(){
        map.removeLayer(foodLayer);
        map.removeLayer(hotelLayer);
        map.removeLayer(sightLayer);
        map.removeLayer(barLayer);
        map.removeLayer(pharmaLayer);
        map.removeLayer(beachLayer);
        map.removeLayer(markerVectorLayer1);

        map.addLayer(hotelLayer);

      var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        sidenavcont.innerHTML=xhr.responseText;
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'Filter');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("type=Hotel");
    });

    document.getElementById("restaurants").addEventListener("click" ,function(){
        map.removeLayer(foodLayer);
        map.removeLayer(hotelLayer);
        map.removeLayer(sightLayer);
        map.removeLayer(barLayer);
        map.removeLayer(pharmaLayer);
        map.removeLayer(beachLayer);
        map.removeLayer(markerVectorLayer1);

        map.addLayer(foodLayer);

      var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        sidenavcont.innerHTML=xhr.responseText;
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'Filter');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("type=food");

    });

    document.getElementById("bars").addEventListener("click" ,function(){
      map.removeLayer(barLayer);
      map.removeLayer(foodLayer);
      map.removeLayer(hotelLayer);
      map.removeLayer(sightLayer);
      map.removeLayer(pharmaLayer);
      map.removeLayer(beachLayer);
      map.removeLayer(markerVectorLayer1);
    
      map.addLayer(barLayer);
      
      var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        sidenavcont.innerHTML=xhr.responseText;
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
      xhr.open('POST', 'Filter');
      xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      xhr.send("type=Cafe");

  });

  document.getElementById("pharma").addEventListener("click" ,function(){
    map.removeLayer(barLayer);
    map.removeLayer(foodLayer);
    map.removeLayer(hotelLayer);
    map.removeLayer(sightLayer);
    map.removeLayer(pharmaLayer);
    map.removeLayer(beachLayer);
    map.removeLayer(markerVectorLayer1);
   
    map.addLayer(pharmaLayer);
    
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      sidenavcont.innerHTML=xhr.responseText;
    } 
    else if (xhr.status != 200) {
      alert('Request failed. Returned status of ' + xhr.status);
    }
    };
    xhr.open('POST', 'Filter');
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("type=Pharma");

});

document.getElementById("beaches").addEventListener("click" ,function(){
  map.removeLayer(barLayer);
  map.removeLayer(foodLayer);
  map.removeLayer(hotelLayer);
  map.removeLayer(sightLayer);
  map.removeLayer(pharmaLayer);
  map.removeLayer(beachLayer);
  map.removeLayer(markerVectorLayer1);
 
  map.addLayer(beachLayer);
  
  var xhr = new XMLHttpRequest();
  xhr.onload = function () {
  if (xhr.readyState === 4 && xhr.status === 200) {
    sidenavcont.innerHTML=xhr.responseText;
  } 
  else if (xhr.status != 200) {
    alert('Request failed. Returned status of ' + xhr.status);
  }
  };
  xhr.open('POST', 'Filter');
  xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
  xhr.send("type=Beach");

});

    document.getElementById("xs").addEventListener("click" ,function(){


      map.removeLayer(foodLayer);
      map.removeLayer(hotelLayer);
      map.removeLayer(sightLayer);
      map.removeLayer(barLayer);
      map.removeLayer(pharmaLayer);
      map.removeLayer(beachLayer);
      map.removeLayer(markerVectorLayer1);

      map.addLayer(sightLayer);
      map.addLayer(hotelLayer);
      map.addLayer(foodLayer);
      map.addLayer(barLayer);
      map.addLayer(pharmaLayer);
      map.addLayer(beachLayer);


      document.getElementById("sidecont").innerHTML = "";


  });



  document.getElementById('myloc').addEventListener('click', function(){
		
		var lon1;
		var lat1;
		if (navigator.geolocation){
			navigator.geolocation.getCurrentPosition(function(position){
				
				    lon1 = position.coords.longitude;
        		lat1 = position.coords.latitude;
        		map.getView().setCenter(ol.proj.transform([lon1,lat1], 'EPSG:4326', 'EPSG:3857'));
        		map.getView().setZoom(16);
        		addMarker(lon1, lat1);
			})
		}	
  })
  

  function addMarker(lon, lat){
    var marker = new ol.Feature({
   geometry: new ol.geom.Point(
    ol.proj.fromLonLat([lon,lat])),  
   });

   var vectorSource = new ol.source.Vector({
      features: [marker]
  });

  var markerVectorLayer = new ol.layer.Vector({
      source: vectorSource,
  });
  map.addLayer(markerVectorLayer);

  }

});
function filterBtn(name){
    var pname=name;
    //alert(pname);
    var xhr = new XMLHttpRequest();
      xhr.onload = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("sidecont").innerHTML=xhr.responseText;
      } 
      else if (xhr.status != 200) {
        alert('Request failed. Returned status of ' + xhr.status);
      }
      };
    xhr.open('POST', 'MoreInfo');
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send("pointname="+pname);


    var xhr2 = new XMLHttpRequest();
      xhr2.onload = function () {
      if (xhr2.readyState === 4 && xhr2.status === 200) {
            resp1 = xhr2.responseText;
            json1 = JSON.parse(resp1);
            //console.log(json1);
            map.getView().setCenter([json1.x,json1.y]);
            map.getView().setZoom(16);
            addMarker1(json1.x,json1.y,json1.name);
      } 
      else if (xhr2.status != 200) {
        alert('Request failed. Returned status of ' + xhr2.status);
      }
      };
    xhr2.open('POST', 'locate');
    xhr2.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr2.send("pointname="+pname);

    function addMarker1(lon, lat, name){
      var marker1 = new ol.Feature({
     geometry: new ol.geom.Point(
      [lon, lat]),  
      name: name
     });
  
     var vectorSource1 = new ol.source.Vector({
        features: [marker1]
    });
  
    markerVectorLayer1 = new ol.layer.Vector({
        source: vectorSource1,
        style: random
    });
    map.addLayer(markerVectorLayer1);
  }
}


function showMap(){
  document.getElementById("side").style.display = "none";
}