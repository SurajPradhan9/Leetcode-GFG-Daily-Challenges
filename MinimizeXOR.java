class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits=Integer.bitCount(num2);//O(logn)
        int ans=0;
        int bit=31;
        while(bit>=0 && setBits>0){ //O(32)
            if((num1 & (1<<bit))!=0){
                ans=ans|(1<<bit);
                setBits--;
            }
            bit--;
        }
        bit=0;
        while(bit<=31 && setBits>0){  //O(32)
            if((num1 & (1<<bit))==0){
                ans=ans|(1<<bit);
                setBits--;
            }
            bit++;
        }
        return ans;
    }
}