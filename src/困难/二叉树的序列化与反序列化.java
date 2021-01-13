package 困难;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Entity.TreeNode;

/**
*序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
示例: 
你可以将以下二叉树：
    1
   / \
  2   3
     / \
    4   5
序列化为 "[1,2,3,null,null,4,5]"
* @author hecai
* @date 2020年6月16日
*/
public class 二叉树的序列化与反序列化 {
	
	 String  deal1(TreeNode root, String str) {
		if(root == null) {
			str += "null,";
		}else {
			str += root.val+",";
			str = deal1(root.left, str);
			str = deal1(root.right, str);
		}
		return str;
	}
	 TreeNode deal2(List<String> data) {
		if(data.get(0).equals("null")) {
			data.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
		data.remove(0);
		root.left = deal2(data);
		root.right = deal2(data);
		return root;
	}

    public  String serialize(TreeNode root) {
    	String str = deal1(root, "");
        return str.substring(0, str.length()-1);
    }
    public TreeNode deserialize(String data) {
    	String[] split = data.split(",");
    	List<String> list = new LinkedList<>(Arrays.asList(split));
        return deal2(list);
    }
    
    public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		TreeNode a = new TreeNode(2);
//		TreeNode b = new TreeNode(3);
//		TreeNode c = new TreeNode(4);
//		TreeNode d = new TreeNode(5);
//		root.left = a;
//		root.right = b;
//		b.left = c;
//		b.right = d;
//		String str = serialize(root);
//		System.out.println(str);
		
	}
	
	
}
