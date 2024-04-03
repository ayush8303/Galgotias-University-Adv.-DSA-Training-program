class Solution {
	public:
		string FirstNonRepeating(string A){
		    queue<char> q;
		    int freq[26]={0};
		    string ans="";
		    for(char ch:A){
		        freq[ch-'a']++;
		        q.push(ch);
		        while(!q.empty() && freq[q.front()-'a']>1){
		            q.pop();
		        }
		        if(q.empty()){
		            ans+='#';
		        }
		        else {
		            ans+=q.front();
		        }
		    }
		    return ans;
		}
};