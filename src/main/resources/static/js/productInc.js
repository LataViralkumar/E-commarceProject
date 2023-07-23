const totalAmount = 0;
var gt =0;




function GTotal(iprice , mtotal,atotal ,finalprice){
        var ipric = document.getElementsByClassName(iprice);
        var mt = document.getElementById(mtotal);
        var at = document.getElementById(atotal);
        var fp = document.getElementById(finalprice);
        // alert("hello");
        gt=0;
        for(i=0;i<ipric.length;i++){
        // alert( ipric[i].innerText);
        gt=gt+ parseInt(ipric[i].innerText);
        }
    at.innerHTML=gt
    mt.innerHTML=parseInt(gt)+50;
    fp.value = mt.innerHTML;
        
}


const item_incriment = (pid,quntity,productp,itemprice ,iprice,mtotal,atotal , finalprice)=>{
    var interval = document.getElementById(quntity);
    var productprice= document.getElementById(itemprice);
 
    if(interval.value<5){
        var value = interval.value++;
        value = value+1;
        var xhttp=new XMLHttpRequest();
        xhttp.open("GET", "http://127.0.0.1:8080/userpage/productQtyInc/"+pid+"/"+ value +"", true);
    
        xhttp.onload=()=>{
          if(xhttp.status === 200){
            // alert("hello   india");
          }else{
            // alert(xhttp.status);
          }
        }
    xhttp.send();


    }else{
        interval.value=5;
    }

    if(interval.value>0){
        productprice.innerHTML = interval.value*productp;
        // totalAmount =  totalAmount + parseInt(productprice.innerHTML);
       
    }

    GTotal(iprice,mtotal,atotal,finalprice);
    
}

const item_decriment= (pid,quntity,productp,itemprice,iprice,mtotal,atotal,finalprice)=>{

    var interval = document.getElementById(quntity);
    var productprice = document.getElementById(itemprice);

    if(interval.value<=1){
        interval.value=1;
    }else{



        var value = interval.value--;
        value = value-1;

        var xhttp=new XMLHttpRequest();
        xhttp.open("GET", "http://127.0.0.1:8080/userpage/productQtyDec/"+pid+"/"+ value +"", true);
    
        xhttp.onload=()=>{
          if(xhttp.status === 200){
            alert("hello  india");
          }else{
            // alert(xhttp.status);
          }
        }
    xhttp.send();



        productprice.innerHTML = parseInt(productprice.innerHTML)-productp;
    }

    GTotal(iprice,mtotal,atotal,finalprice);
    
}

function deleteItemInDB(productid ){

    let pid = productid;

    var xhttp=new XMLHttpRequest();
    xhttp.open("GET", "http://127.0.0.1:8080/userpage/cart_item/"+pid+"", true);

    xhttp.onload=()=>{
      if(xhttp.status === 200){
        // alert("hello");
      }else{
        // alert(xhttp.status);
      }
    }
xhttp.send();
}

const remove_item = (itemx,iprice,mtotal,atotal,finalprice)=>{
    
    const item = document.getElementById(itemx);
    deleteItemInDB(itemx);
    alert("item removed");
    item.remove();
    GTotal(iprice,mtotal,atotal,finalprice);
}


