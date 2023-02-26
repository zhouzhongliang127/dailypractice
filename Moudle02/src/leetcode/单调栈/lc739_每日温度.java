package leetcode.单调栈;

import java.util.Deque;
import java.util.LinkedList;

public class lc739_每日温度 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        //单调栈 自底向上升序
        Deque<LinkedList<Integer>> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            if(stack.isEmpty()){
                //空或者满足规则，下标直接放入栈中
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
                continue;
            }

            //如果当前位置元素大于栈顶元素,不断处理，直到满足条件
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek().getLast()]){
                LinkedList<Integer> indexList = stack.poll();
                //栈顶列表中的下标对应元素右侧比自己大的元素就是当前元素
                for (int index : indexList) {
                    answer[index] = i - index;
                }
            }

            //上面处理完后优先考虑栈空，避免空指针，栈空或者满足大小要求直接入栈，否则就是相等，加入栈顶下标链表
            if(stack.size() == 0 || temperatures[i] < temperatures[stack.peek().getLast()]){
                //空或者满足规则，下标直接放入栈中
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }else if(temperatures[i] == temperatures[stack.peek().getLast()]){
                stack.peek().addLast(i);
            }
        }

        //最后栈中剩余元素右侧无大于它的元素
        for (LinkedList<Integer> list : stack) {
            for (Integer index : list) {
                answer[index] = 0;
            }
        }

        return answer;
    }

    public static int[] dailyTemperatures_up(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        //单调栈 自底向上升序
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {

            //如果当前位置元素大于栈顶元素,不断处理，直到满足条件
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index= stack.poll();
                //栈顶列表中的下标对应元素右侧比自己大的元素就是当前元素
                answer[index] = i - index;

            }

            stack.push(i);

        }

        //最后栈中剩余元素右侧无大于它的元素
        for (int index : stack) {
            answer[index] = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] answer = dailyTemperatures_up(temperatures);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
