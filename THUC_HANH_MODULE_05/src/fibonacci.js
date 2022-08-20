var x;
var y;
var z;
var sum;
x = 0;
y = 1;
sum = 0;
for (var i = 1; i <= 18; i++) {
    z = x + y;
    x = y;
    y = z;
    console.log(z);
    sum = sum + z;
}
console.log("Sum =" + sum);
