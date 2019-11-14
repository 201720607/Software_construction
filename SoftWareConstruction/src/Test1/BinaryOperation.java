package Test1;
import java.util.Random;
public class BinaryOperation {
	static int left_op[]=new int[50];
	static int center_op[]=new int[50];
	static int right_op[]=new int[50];
	static int ans[]=new int[50];
	static int l=50;
	
	public static boolean judge(int a,int b,int c,int d) {
		for(int i=0;i<l;i++) 
		{
		  if(d<0||d>100)    return false;//判断和小于100，差大于零
		  if(a==left_op[i]&&b==center_op[i]&&c==right_op[i])   return false;//判断重复
		  if(a==right_op[i]&&b==center_op[i]&&c==left_op[i])   return false;
	    }
		return true;
	}
	public static void generateEquations() { //生成算式
		int left_operand=0;
		int right_operand=0;
		int operation=0;
		int answer=0;
		Random random=new Random();
		int sum=0;
		while(sum<50)
		{
			left_operand=random.nextInt(101);  //生成随机数
			operation=random.nextInt(2);    //生成随机数
			right_operand=random.nextInt(101);    //生成随机数
			if(operation==1)
			{
			    answer=left_operand+right_operand;
			   
			}
			else	
			{
			    answer=left_operand-right_operand;
			}
				if(judge(left_operand,operation,right_operand,answer))
				{
					left_op[sum]=left_operand;
					center_op[sum]=operation;
					right_op[sum]=right_operand;
					ans[sum++]=answer;
				}
			}	
		for(int i=0;i<l;i++)//打印算式
		{
			System.out.print("("+(i+1)+")"+left_op[i]);
			if(center_op[i]==1)
			{
			    System.out.print("+");
			}
			else	
			{
				System.out.print("-");
			}
			System.out.print(right_op[i]+"\t");
			if((i+1)%5==0)  System.out.println();
		}
	}

	public static void generateAnswers() {//生成答案
		for(int i=0;i<l;i++)
		{
			System.out.print("("+(i+1)+")"+ans[i]+"\t");
			if((i+1)%5==0)    
			System.out.println();			
		}	

	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("------------------------------------------");
		System.out.println("---程序输出50道100以内的加减法算式的习题---");
		System.out.println("---每次运行程序可以得到一套50道题的习题---");
		System.out.println("------------------------------------------");
		generateEquations();
	    System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("---下面是习题的参考答案---");
		System.out.println("------------------------------------------");
		generateAnswers();
	}
}