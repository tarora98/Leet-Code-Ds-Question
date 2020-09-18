import java.util.*;
public class Tree{
	public static class Node{
		int data=0;
		Node left=null;
		Node right=null;
		Node(int data){
			this.data=data;
		}
	}

	static int idx=0;
	public static Node constructorTree(int[] arr){
		if(idx>=arr.length || arr[idx]==-1){
			idx++;
			return null;
		}

		Node node= new Node(arr[idx++]);
		node.left=constructorTree(arr);
		node.right=constructorTree(arr);

		return node;
	}
	public static int size(Node node){ // find the no. of node
		return node==null? 0 :size(node.left)+size(node.right)+1;
	}
	public static boolean find(Node node, int element){
		if(node==null){
			return false;
		}
		if(node.data==element){
		return true;  
	    }
	    return find(node.left,element) || find(node.right,element);
	}



	public static void print(Node node){
		if(node==null){
			return;
		}
		StringBuilder sb = new StringBuilder();
        sb.append((node.left != null)?node.left.data:"." );
        sb.append("<-"+node.data + "->");
        sb.append((node.right!=null)?node.right.data:".");

		System.out.println(sb);
		print(node.left);
		print(node.right);
	}
public static void main(String[] args){
	int arr[]={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
	Node root=constructorTree(arr);
	print(root);
	System.out.println(size(root));
	System.out.println(find(root,90));
} 
}