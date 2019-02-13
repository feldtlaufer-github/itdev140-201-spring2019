/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhichweek1fun;

/**
 * 
 * @author plain
 */
public class Practice {
    int answer;
    int first = 4;
    int second = 11;
    
    public Practice(){
        takeIt(first, second);
        doIt();
    }
    public void doIt(){
        if(answer > 10){
            System.out.println("Here is your answer: " + answer);
        }else{
            System.out.println("too low!");
        }
    }
    public int takeIt(int a, int b){
        answer = a + b;
        return answer;
    }
}
