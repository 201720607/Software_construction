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
		  if(d<0||d>100)    return false;//�жϺ�С��100���������
		  if(a==left_op[i]&&b==center_op[i]&&c==right_op[i])   return false;//�ж��ظ�
		  if(a==right_op[i]&&b==center_op[i]&&c==left_op[i])   return false;
	    }
		return true;
	}
	public static void generateEquations() { //������ʽ
		int left_operand=0;
		int right_operand=0;
		int operation=0;
		int answer=0;
		Random random=new Random();
		int sum=0;
		while(sum<50)
		{
			left_operand=random.nextInt(101);  //���������
			operation=random.nextInt(2);    //���������
			right_operand=random.nextInt(101);    //���������
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
		for(int i=0;i<l;i++)//��ӡ��ʽ
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

	public static void generateAnswers() {//���ɴ�
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
		System.out.println("---�������50��100���ڵļӼ�����ʽ��ϰ��---");
		System.out.println("---ÿ�����г�����Եõ�һ��50�����ϰ��---");
		System.out.println("------------------------------------------");
		generateEquations();
	    System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("---������ϰ��Ĳο���---");
		System.out.println("------------------------------------------");
		generateAnswers();
	}
}