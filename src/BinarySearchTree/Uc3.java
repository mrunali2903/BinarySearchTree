package BinarySearchTree;

import java.util.Scanner;

public class Uc3 {

    Scanner scanner = new Scanner(System.in);
    Node rootHead;
    BinarySearchTree(){// Constructor used to null the rootHead first.
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
        System.out.println("Enter '3' to Search Number.");
        System.out.println("Enter '0' to Exit.");
        System.out.print("Enter the Input : ");
        int input = scanner.nextInt();

        switch (input){
            case 0 :
                System.out.println("\nThank You.....!");
                exit();
                break;
            case 1 :
                pushOtherValue();
                break;
            case 2 :
                printTree();
                pushOtherValue();
                break;
            case 3 :
                searchNumInTree();
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
    public void searchNumInTree(){
        boolean checkInLeft=true;
        boolean checkInRight=true;
        System.out.println("Enter The Number That You Want to Search : ");
        int searchNum = scanner.nextInt();
        if (rootHead.data==searchNum){
            System.out.println(searchNum+" is Found. It is a Root Head Node Value.");
            checkInLeft=false;
            checkInRight=false;
        }else {
            check(rootHead,searchNum);
        }
        if (checkInLeft){
            Node node = rootHead;
            if (node != null) {
                Node tempLeft = node.left;
                if (tempLeft.data==searchNum){
                    System.out.println(searchNum+" is Found. And Is Left Side Of The Tree.");
                    checkInRight=false;
                }else {
                    System.out.println(searchNum+" is Not Found.");
                }
            }
        }
        if (checkInRight){
            Node node = rootHead;
            if (node != null) {
                Node tempRight = node.right;
                if (tempRight.data==searchNum){
                    System.out.println(searchNum+" is Found. And Is Right Side Of The Tree.");
                }else {
                    System.out.println(searchNum+" is Not Found.");
                }
            }
        }
    }
    public void printTree() {
        System.out.println("\nBST Tree:\n");
        System.out.println("Left-->Root<--Right\n");
        printInorder(rootHead);
    }

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            if (node.data<rootHead.data){
                System.out.print(node.data + "-->");
            }else {
                System.out.print(node.data + "<--");
            }
            printInorder(node.right);
        }
    }
    private void check(Node node, int searchNum) {
        if (node != null) {
            check(node.left,searchNum);
            if (node.data<rootHead.data){
                if (node.data==searchNum){
                    System.out.println(searchNum+" is Found. And Is Left Side Of The Tree.");
                }
            }else {
                if (node.data==searchNum){
                    System.out.println(searchNum+" is Found. And Is Right Side Of The Tree.");
                }
            }
            check(node.right,searchNum);
        }
    }
    private void exit(){}
}
}
