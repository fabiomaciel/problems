package com.fabiomaciel.dailycoding;

import java.util.Objects;

/**
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 *
 * For example, given the following Node class
 *
 * class Node:
 *     def __init__(self, val, left=None, right=None):
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *
 * The following test should pass:
 *
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */
public class Problem3 {

    public static final String ROOT_VALUE = "_";

    public static void main(String[] args) {
        Node root = new Node("root", new Node("left", new Node("left.left")), new Node("right"));


        System.out.println(deserialize(serialize(root)).left.left.value.equals("left.left"));
    }

    public static String serialize(Node root) {
        if(root == null) return ROOT_VALUE;

        return String.format("%s %s %s", root.value, serialize(root.left), serialize(root.right));
    }

    public static Node deserialize(String tree){
        return deserialize(tree.split(" "), new IntValue(0));
    }

    public static Node deserialize(String[] tree, IntValue index){
        if(tree[index.value].equals(ROOT_VALUE)){
            index.value++;
            return null;
        }

        Node node = new Node(tree[index.value++]);

        if(index.value >= tree.length) return node;
        node.left = deserialize(tree, index);

        if(index.value >= tree.length) return node;
        node.right = deserialize(tree, index);

        return node;
    }

}

class IntValue{
    int value;

    public IntValue(int value) {
        this.value = value;
    }
}

class Node{
    public String value;
    public Node left;
    public Node right;

    public Node(String value){
        this(value, null, null);
    }
    public Node(String value, Node left){
        this(value, left, null);
    }

    public Node(String value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        return Objects.equals(value, node.value)
                && Objects.equals(left, node.left)
                && Objects.equals(right, node.right);
    }
}
