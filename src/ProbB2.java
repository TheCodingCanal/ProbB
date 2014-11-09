import java.util.Scanner;


public class ProbB2 {

	public static void main(String[] args) {
		ProbB2 t = new ProbB2();
		t.run();
	}
	
	public void run() {
		caseNum = 0;
		
		Scanner in = new Scanner(System.in);
		
		clear();
		
		while(in.hasNext()) {
			int i = in.nextInt();
			if(i < 0) {
				clear();
				
			} else {
				tryAdd(i);
			}
		}
	}
	
	public void clear(){
		if(caseNum != 0 && !fail) System.out.println("Case "+caseNum+": yes");
		fail = false;
		root = new Node();
		caseNum += 1;
	}
	
	public void tryAdd(int i){
		if(fail) return;
		try {
			Node in = new Node();
			in.value = i;
			
			if(in.value < root.value) {
				root.left = in;
				root = in;
			} else if(in.value > root.value) {
				if(root.parent == null) {
					root.right = in;
					root = in;
				}
				if(in.value > root.parent.value) {
					root = root.parent;
					tryAdd(i);
				} else {
					root.right = in;
					root = in;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Case "+caseNum+": no");
			fail = true;
		}
	}
	
	public class Node{
		public Node right, left, parent;
		public int value;
	}
	
	public Node root;
	int caseNum;
	boolean fail;
}
