function gcd(x, y) {
    while (x != 0 && y != 0) {
        x > y ? x = x % y : y = y % x;
    }
   return x != 0 ? x : y; 
}

gcd(2154, 458);