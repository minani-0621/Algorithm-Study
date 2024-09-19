let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split("\n");

if(input[0] === "SONGDO") {
    console.log("HIGHSCHOOL");
}else if(input[0] === "CODE") {
    console.log("MASTER");
}else if(input[0] === "2023") {
    console.log("0611");
}else if("ALGORITHM") {
    console.log("CONTEST");
}