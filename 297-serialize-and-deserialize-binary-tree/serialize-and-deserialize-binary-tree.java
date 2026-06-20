/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root , sb);
        return sb.toString();
    }
    private void serialize(TreeNode node, StringBuilder sb ){
        if(node == null){
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        serialize(node.left , sb);
        serialize(node.right , sb);
    }


        
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        for(String s : data.split(",")){
            if(!s.equals("")){
                q.offer(s);
            }
        }

        return deserialize(q);      
    }
    private TreeNode deserialize(Queue<String> q ){
        
        String val = q.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;



    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));