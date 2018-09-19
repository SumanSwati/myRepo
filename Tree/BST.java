class BST {
 
 
    // Root of BST
    Node root;
 
    // Constructor
    BST() { 
        root = null; 
    }
 
    // This method mainly calls insertRec()
    void insert(int key) {
       root = insertRec(root, key);
    }
     
    void delete(int key) {
    	deleteRecur(root, key);
    }
    
    boolean search(int key){
    	if(searchKey(root, key).key == key){
    		return true;
    	}
    	else
    		return false;
    }
    
    Node searchKey(Node root, int key){
    	if(root == null || root.key == key){
    		return root;
    	} 
    	if(key < root.key){
    		return searchKey(root.left, key);
    	}
    	else
    		return searchKey(root.right, key);
    	
    }
    
    Node deleteRecur(Node root, int key){
    	if(root == null){
    		return root;
    	}
    	if(key < root.key){
    		return deleteRecur(root.left, key);
    	}
    	else if(key > root.key){
    		return deleteRecur(root.right, key);
    	}
    	else{
    		if(root.left == null)
    			return root.right;
    		if(root.right == null)
    			return root.left;
    		
    		root.key = minVal(root.right);//swap with inorder successor for two children
    		
    		root.right = deleteRecur(root.right, key);
    	}
		return root;
    	
    }
    private int minVal(Node root) {
		// TODO Auto-generated method stub
    	int minVal = root.key;
    	while(root.left != null){
    		minVal = root.left.key;
    		root = root.left;
    	}
		return minVal;
	}

	/* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            return new Node(key);
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        BST tree = new BST();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.delete(70);
        if(tree.search(50)){
        	System.out.println("found");
        } else{
        	System.out.println("Not found");
        }
 
        // print inorder traversal of the BST
        tree.inorder();
    }
}