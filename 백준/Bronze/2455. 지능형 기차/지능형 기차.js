let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

let passenger = 0;
let maxPassenger = 0;

for(let i = 0; i < 4; i++) {
    let [rideOff, rideOn] = input[i].split(" ");
    
    passenger -= Number(rideOff);
    passenger += Number(rideOn);
    
    if(passenger > maxPassenger) {
        maxPassenger = passenger;
    }
}

console.log(maxPassenger);