class Solution
{
    public String FirstNonRepeating(String A)
    {
        Queue<Character> q=new LinkedList<>();
        int n=A.length();
        int[] freq=new int[26];
        StringBuilder ans=new StringBuilder();
        
        for(int i=0;i<n;i++){
            char ch=A.charAt(i);
            
            freq[ch-'a']++;
            
            q.offer(ch); 
            
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.poll(); 
            }
            
            if(q.isEmpty()){
                ans.append('#');
            }
            else {
                ans.append(q.peek());
            }
            
        }
        return ans.toString();
        
    }
}