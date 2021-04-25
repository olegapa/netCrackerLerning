package ru.skillbench.tasks.javaapi.collections;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TreeNodeImpl implements TreeNode {
    private Object current;
    private TreeNode parent;
    private Set<TreeNode> children;
    private boolean expanded;

    public TreeNodeImpl(){
        current = null;
        parent = null;
        children = new HashSet<>();
    }

    public TreeNodeImpl(Object obj){
        this();
        this.current =obj;
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if(parent == null)
            return null;
        TreeNode root = parent;
        while (root.getParent() != null)
            root = root.getParent();
        return root;
    }

    @Override
    public boolean isLeaf() {
        return children.size() == 0;
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return children.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        children.add(child);
        child.setParent(this);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if(children.contains(child)) {

            child.setParent(null);
            return children.remove(child);
        }
        return false;
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        for(TreeNode i: children)
            i.setExpanded(expanded);
    }

    @Override
    public Object getData() {
        return current;
    }

    @Override
    public void setData(Object data) {
        current = data;
    }

    @Override
    public String getTreePath() {
        String treePath = (current == null) ? "empty" :current.toString();
        if(parent == null)
            return treePath;
        return parent.getTreePath() + "->" + treePath;
    }

    @Override
    public TreeNode findParent(Object data) {
        if(current.equals(data))
            return this;
        if(parent == null)
            return null;
        return parent.findParent(data);
    }

    @Override
    public TreeNode findChild(Object data) {

        for(TreeNode i: children){
            if(i.getData() == null && data == null){
                return null;
            }
            if(i.getData() != null) {
                if (i.getData().equals(data))
                    return i;
            }
            else if (data == null)
                return null;

            else {
                TreeNode s = i.findChild(data);
                if(s != null)
                    return s;
            }

        }

        return null;
    }
}
