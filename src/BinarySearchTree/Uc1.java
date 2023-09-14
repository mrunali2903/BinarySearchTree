package BinarySearchTree;

import org.w3c.dom.Node;

import java.util.Scanner;

public class Uc1 {
    Scanner scanner = new Scanner(System.in);
    Node rootHead;
    void BinarySearchTree(){// Constructor used to null the rootHead first.
        rootHead=null;
    }
    public void welcomePage(){
        System.out.println("Welcome to Binary Search Tree.");

        System.out.print("Enter the Root Node : ");
        int rootNodeNum = scanner.nextInt();
        Node newNode = new Node(rootNodeNum);
        if (rootHead==null){
            rootHead=newNode;
        }
        pushOtherValue();
    }
    Node pushValue(Node node , int value){
        if (node == null) {
            node = new Node(value);
            return node;
        }
        // tree
        if (value < node.data){
            node.left = pushValue(node.left, value);
        } else if (value > node.data){
            node.right = pushValue(node.right, value);
        }

        System.out.println("\nEnter '1' to Add Other Node.");
        System.out.println("Enter '2' to display the tree.");
        System.out.println("Enter '0' to Exit.");
        System.out.print("Enter the Input : ");
        int input = scanner.nextInt();

        switch (input){
            case 0 :
                System.out.println("\nThank You.....!");
                pushValue(null,0);
                break;
            case 1 :
                pushOtherValue();
                break;
            case 2 :
                break;
            default :
                System.out.println("\nPlease Enter Valid input.\n");
                rootHead=null;
                welcomePage();
                break;
        }

        // Return
        return node;
    }
    public void pushOtherValue(){
        System.out.print("\nEnter the other Node : ");
        int otherNodeNum = scanner.nextInt();
        pushValue(rootHead,otherNodeNum);
    }

}

