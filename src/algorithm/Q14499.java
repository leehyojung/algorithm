package algorithm;
import java.util.Scanner;

public class Q14499 {
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();   //지도의 세로
   int m = sc.nextInt();   //지도의 가로
   int x = sc.nextInt();   //주사위를 놓은 좌표 x
   int y = sc.nextInt();   //주사위를 놓은 좌표 y
   int order = sc.nextInt();   //명령의 갯수
   //bottom = dice[2]
   //top = dice[4];
   int dice[] = new int[7];
   int map[][] = new int[n][m];
   
   void init(){
      for(int i=0; i<n; i++){
         for(int j=0; j<m; j++){
            map[i][j] = sc.nextInt();
         }
      }
      
      //order입력받고, 1:맵에서 벗어나면 무시, 2:벗어나지 않으면 정상작동
      for(int i=1; i<=order; i++){
         int orderNum = sc.nextInt();
         if(mapCheck(orderNum)){
            changeDice(orderNum);
            copyMapToDice();
            System.out.printf(dice[4]+" ");
         }
      }
   }

   // orderNum과 주사위의 현재위치 x, y
   //1오 2왼 3위 4아래
   boolean mapCheck(int orderNum) {
      int a = x;
      int b = y;
      switch(orderNum){
      case 1   : b+=1;
      break;
      case 2   : b-=1;
      break;
      case 3   : a-=1;
      break;
      case 4   : a+=1;
      break;
      }
      if(0<=a && a<n && 0<=b && b<m)
         return true;
      return false;
   }
   void changeDice(int orderNum){
      switch(orderNum){
      case 1   : y+=1;   right();
      break;
      case 2   : y-=1;   left();
      break;
      case 3   : x-=1;   up();
      break;
      case 4   : x+=1;   down();
      break;
      }
   }
   void right(){
      int temp = dice[2];
      dice[2] = dice[6];
      dice[6] = dice[4];
      dice[4] = dice[5];
      dice[5] = temp;
   }
   void left(){
      int temp = dice[2];
      dice[2] = dice[5];
      dice[5] = dice[4];
      dice[4] = dice[6];
      dice[6] = temp;
   }
   void up(){
      int temp = dice[1];
      dice[1] = dice[4];
      dice[4] = dice[3];
      dice[3] = dice[2];
      dice[2] = temp;
   }
   void down(){
      int temp = dice[1];
      dice[1] = dice[2];
      dice[2] = dice[3];
      dice[3] = dice[4];
      dice[4] = temp;
   }
   
   void copyMapToDice() {
      if(map[x][y]==0)
         map[x][y]=dice[2];
      else{
         dice[2] = map[x][y];
         map[x][y] = 0;
      }
   }
   public static void main(String[] args) {
      new Q14499().init();
   }
   
}