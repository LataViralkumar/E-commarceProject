function test(productid) {
    
 // alert(productid);

    // let pid=productid;
    // alert(pid);
    var xhttp=new XMLHttpRequest();
    xhttp.open("GET", "http://127.0.0.1:8080/userpage/AddCartItems/"+productid +"", true);

    xhttp.onload=()=>{
      if(xhttp.status === 200){
        // alert(xhttp.status);
      }else{
        // alert(xhttp.status);
      }
    }

xhttp.send(); 
}

function ProductDscription(productid) {
    
    //  let pid=productid;

     var xhttp=new XMLHttpRequest();
     xhttp.open("GET", "http://127.0.0.1:8080/userpage/ItemDescription/"+productid +"", true);
 
     xhttp.onload=()=>{
       if(xhttp.status === 200){
        alert(xhttp.status)
       }else{
        //  alert(xhttp.status);
       }
     }
      xhttp.send(); 
 }
 




