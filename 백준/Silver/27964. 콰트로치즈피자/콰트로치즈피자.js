let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let count = input[0];

const toppings = input[1].split(" ");

let set = new Set();

for (let i = 0; i < toppings.length; i++) {
  if (!set.has(toppings[i]) && toppings[i].endsWith("Cheese")) {
    set.add(toppings[i])
  }
}

const cheeseCount = set.size;

if(cheeseCount >= 4) {
    console.log("yummy");
}else {
    console.log("sad");
}