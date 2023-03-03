class Solution {
    
    int answer = 0;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, this.numbers[0]);
        dfs(0, this.numbers[0] * -1);
        
        return answer;
    }
    
    private void dfs(int index, int sum)
    {
        if(index >= this.numbers.length-1)
        {
            if(sum == this.target)
            {
                this.answer++;
            }
            return;
        }
        
        dfs(index+1,sum + (this.numbers[index+1]));
        dfs(index+1,sum + (this.numbers[index+1] * -1));
        
        
    }
}