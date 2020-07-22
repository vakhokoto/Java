// Initialisation of strings algorithm Z function
// here is what algorithm does:
//   The method getArray() returns the array z of length string.length() where each element
//   z[i] is the maximum number of characters for which string[0..z[i]-1] is the same as string[i..i+z[i]-1]
//
// example:
//      for string="abcaabc" the z would be [7, 0, 0, 1, 3, 0, 0]
//
// Detailed review and more examples can be seen on the link below.
//
// Link of algorithm review: https://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
package Strings;

public class ZFunction {
    private String string;

    public ZFunction(String string){
        this.string = string;
    }

    public int[] getArray(){
        int length = string.length();
        int[] z = new int[length];
        int l = 0, r = 0;
        for (int i=0; i<length; i++){
            if (i > l && i <= r){
                z[i] = Math.min(z[i - l], r - i + 1);
            }
            while (i + z[i] < length && string.charAt(z[i]) == string.charAt(i + z[i])){
                z[i]++;
            }
            if (i + z[i] > r){
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}
