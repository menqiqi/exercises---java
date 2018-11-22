

class Solution {
    public boolean isPalindrome(int x) {
        String str = ""+x;
        char[] data = str.toCharArray();
        char[] arr = new char[data.length];
        for(int i = 0; i < data.length; i++){
            arr[data.length-1-i] = data[i];
        }
        String str2 = new String(arr);
        if(str.equals(str2)){
            return true;
        }else{
            return false;
        }
    }
}


