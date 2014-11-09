import java.util.Scanner;


public class ProbB {

	long[] b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProbB b = new ProbB();
		b.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		b = new long[1000];
		int count = 0;
		int caseNum = 1;
		while( scan.hasNextLong() ){
			long num = scan.nextLong();
			if( num < 0){
				 if(check(b[0],1,count-1) == 0){
					System.out.println("Case "+caseNum+": yes");
				}
				
				else{
					System.out.println("Case "+caseNum+": no");
				}
				count = 0;
				caseNum++;
			}
			else{
				b[count] = num;
				count++;
			}
		}
	}
	
	private int check( long num, int s, int e ){
		if(s >= e){
			return 0;
		}
		int total = 0;
		int s2 = s;
		while( s2 <= e && b[s2] < num ){
			s2++;
		}
		for( int i = s2; i <=e ; i++ ){
			if(b[i] < num)
				return 1;
		}
		
		total = total + check(b[s], s+1 ,s2-1);
		if(s2 <= e){
			total = total + check(b[s2],(s2+1),e);
		}
		return total;	
	}

}
