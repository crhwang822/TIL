class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skillTree : skill_trees) {
            int learned = 0;
            boolean flag = true;
            for(char c : skillTree.toCharArray()) {
                if(skill.indexOf(c) > learned) {
                    flag = false;
                    break;
                }
                else if(skill.indexOf(c) == learned)
                    learned++;
            }
            if(flag)
                answer++;
        }
        
        return answer;
    }
}