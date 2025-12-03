package com.paul.atlassian.tree;


/*
Day 5 — Tree Structures & Hierarchical Data (Jira Comments / Issues Theme)
    Atlassian products (Jira, Confluence) heavily use:
      - comment threads
      - nested replies
      - issue links (subtasks, parent/child)
      - page trees
      - document headings
      - permission inheritance
      - hierarchical configuration

So Day 5 is about building, traversing, and manipulating trees.


You are given a flat list of comments, each with:
  - id
  - parentId (null for root comments)
  - text

Example Input (unordered):

[
  { id=10, parentId=2, text="reply to comment 2" },
  { id=1,  parentId=null, text="root comment A" },
  { id=2,  parentId=1,    text="reply to A" },
  { id=3,  parentId=1,    text="another reply to A" },
  { id=4,  parentId=2,    text="reply to reply" }
]
or other tree structure


Comment(1)
 ├── Comment(2)
 │     ├── Comment(10)
 │     └── Comment(4)
 └── Comment(3)


Requirements:

  -  Build the tree efficiently (O(n))
  -  Handle multiple root comments (return a list of root nodes)
  -  Correctly attach replies under their parent
  -  Handle unordered input
  -  Throw an exception if:
      -  a comment references a non-existent parent
      -  there’s a self-cycle (id == parentId)

* */
/*        Map<Integer, List<Comment>> childerMap = new HashMap<>();
        for (Comment comment : comments) {
            int id = comment.id();
            int parentId = comment.parentId();

            if (childerMap.containsKey(parentId)) {
                List<Comment> children = childerMap.get(parentId);
                children.add(comment);
            } else {
                List<Comment> children = new ArrayList<>();
                children.add(comment);
                childerMap.put(parentId, children);
            }

        }

        childerMap.entrySet()
                .stream()
                .map(entry -> new CommentNode(entry.getKey(), hierarchyComments.get(entry.getKey()).text(), entry.getValue()))*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommentThreadTree {
    record Comment(
            int id,
            Integer parentId,// null for root
            String name,
            String text) {
    }

    record CommentNode (
        int id,
        String name,
        String text,
        List<CommentNode> replies){
    }

    public List<CommentNode> buildCommentTree(List<Comment> comments) {
        //  root
        //   /\
        //  1  2
        // /\  /\
        //3 4 5  6

        Map<Integer, CommentNode> nodeMap = new HashMap<>();
        for (Comment c : comments) {
            nodeMap.put(c.id(), new CommentNode(c.id(), c.name(), c.text(), new ArrayList<>()));
        }

        // 2. Attach children to parents
        List<CommentNode> roots = new ArrayList<>();

        for (Comment c : comments) {
            CommentNode node = nodeMap.get(c.id());

            if (c.parentId() == null) {
                // root comment
                roots.add(node);
            } else {
                CommentNode parent = nodeMap.get(c.parentId());

//                next validation and checking of cycle graph
                if (parent == null) {
                    throw new IllegalStateException(
                            "Comment id=" + c.id() + " references non-existent parent " + c.parentId());
                }
                if (c.id() == c.parentId()) {
                    throw new IllegalStateException("Self-cycle detected at comment " + c.id());
                }
                // the problem here, that record doesn't have the copy method which allows to create the copy object from existing one.
                parent.replies.add(node);
            }
        }

        return roots;
    }

    private static final Map<Integer, Comment> hierarchyComments = new HashMap<>();


    public static void main(String[] args) {
        //simplify the input comments
        String input = """
                        # Comment Thread Export (CSV)
                        # id,parentId,name,text
                        1,,Alice,"This is the first comment"
                        5,,Sarah,"Is anyone available for code review?"
                        2,1,Bob,"I agree with your point"
                        3,1,Charlie,"Thanks for starting this thread!"
                        4,2,Diana,"Can you elaborate on that?"
                        6,5,Tom,"I can review after lunch"
                        7,5,Kevin,"I'm available now"
                        8,6,Alice,"Thanks Tom!"
                        9,8,Bob,"+1"
                
                        # End of file
                """;


        //convert it to the List<Comment>
        List<Comment> comments = Arrays.stream(input.split("\n"))
                .map(String::trim)
                .filter(line -> !line.isBlank() && !line.startsWith("#"))
                .map(CommentThreadTree::buildComment)
                .collect(Collectors.toList());


        buildCommentHierarchy(comments);
        Comment root = findRootCommentById(9);
        System.out.println(root);

        CommentThreadTree threadTree = new CommentThreadTree();
        List<CommentNode> commentNodes = threadTree.buildCommentTree(comments);


        printTree(commentNodes);
    }

    private static Comment findRootCommentById(int id) {
        Comment curr = hierarchyComments.get(id);
        while (curr != null) {
            System.out.println("Comment id : " + curr.id() + ", comment:" + curr.text());
            if (curr.parentId() == null) {
                return curr;
            }
            curr = hierarchyComments.get(curr.parentId());
        }
        return curr;
    }

    private static void buildCommentHierarchy(List<Comment> comments) {
        //key = id, value is comment itself
        for (Comment comment : comments) {
            hierarchyComments.put(comment.id, comment);
        }
    }

    private static Comment buildComment(String line) {
        String[] columns = line.split(",");
        Integer parentId = null;
        if (!columns[1].isBlank()) {
            parentId = Integer.valueOf(columns[1]);
        }

        return new Comment(Integer.parseInt(columns[0]), parentId, columns[2], columns[3]);
    }

    private static void printTree(List<CommentNode> roots) {
        for (CommentNode root : roots) {
            printNode(root, 0);
        }
    }

    private static void printNode(CommentNode node, int depth) {
        System.out.println("  ".repeat(depth) + "- " + node.id + ": " + node.text);
        for (CommentNode child : node.replies) {
            printNode(child, depth + 1);
        }
    }

}
