
function sendAjaxGet(url, func){
    //step 1 obtain xhr
    var xhr = new XMLHttpRequest() || ActiveXObject("Microsoft.HTTPRequest");
    //step2: define onReadyStateChange
    xhr.onreadystatechange = function(){
        //console.log(this.readyState);
        if(this.readyState == 4 && this.status == 200){
          func(this);
        }
    };
    //step 3: prepare request with open()
    xhr.open("GET",url,true);
    //finally, send()
    xhr.send();
};


var hero = [];
function displayHero(xhr){
  var res = JSON.parse(xhr.responseText);
  if(res.biography.publisher === "DC Comics"){
  hero[hero.length] = res;
  }
};
window.onload = function(){
        var count = 1;
       do {
        sendAjaxGet("http://superheroapi.com/api.php/10217498067713652/" + count,displayHero);
        count++;
        }while((hero[hero.length-1] == undefined || hero[hero.length-1].response != "error") && count < 100);
};
