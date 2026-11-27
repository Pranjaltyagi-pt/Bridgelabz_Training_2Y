package Assignment;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    /**
     * Practice Problem 1: Recursive directory size calculator.
     * Contains the recursive solution (with a call-stack trace), the iterative
     * solution (explicit stack) and a cycle-safe version for symbolic links.
     */
    public class DirectorySize {

        // A node is either a file (size > 0, no children) or a directory (has children)
        static class Node {
            String name;
            int sizeKb;                   // only used for files
            boolean isDirectory;
            List<Node> children = new ArrayList<>();

            Node(String name, int sizeKb) {          // file
                this.name = name;
                this.sizeKb = sizeKb;
                this.isDirectory = false;
            }

            Node(String name) {                      // directory
                this.name = name;
                this.isDirectory = true;
            }

            Node add(Node child) {
                children.add(child);
                return this;
            }
        }

        // ---------- (a) Recursive solution ----------
        static int totalSize(Node node) {
            // Base case: a file returns its own size
            if (!node.isDirectory) {
                return node.sizeKb;
            }
            // Recursive case: a directory is the sum of everything inside it
            int total = 0;
            for (Node child : node.children) {
                total += totalSize(child);
            }
            return total;
        }

        // ---------- (b) Same function, with a call-stack trace ----------
        static int totalSizeTraced(Node node, int depth) {
            String indent = "    ".repeat(depth);
            System.out.println(indent + "CALL   totalSize(" + node.name + ")   [stack depth " + (depth + 1) + "]");
            int result;
            if (!node.isDirectory) {
                result = node.sizeKb;
                System.out.println(indent + "BASE   file " + node.name + " -> returns " + result + " KB");
            } else {
                result = 0;
                for (Node child : node.children) {
                    result += totalSizeTraced(child, depth + 1);
                }
                System.out.println(indent + "RETURN directory " + node.name + " -> returns " + result + " KB");
            }
            return result;
        }

        // ---------- (d) Iterative solution using an explicit stack ----------
        static int totalSizeIterative(Node root) {
            int total = 0;
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node current = stack.pop();
                if (!current.isDirectory) {
                    total += current.sizeKb;
                } else {
                    for (Node child : current.children) {
                        stack.push(child);
                    }
                }
            }
            return total;
        }

        // ---------- (e) Cycle-safe version (symbolic links) ----------
        // Extra base case: if a directory was already visited, return 0
        static int totalSizeSafe(Node node, Set<Node> visited) {
            if (!node.isDirectory) {
                return node.sizeKb;
            }
            if (visited.contains(node)) {
                return 0;                 // cycle detected, do not count or enter again
            }
            visited.add(node);
            int total = 0;
            for (Node child : node.children) {
                total += totalSizeSafe(child, visited);
            }
            return total;
        }

        static Node buildProject() {
            Node guides = new Node("guides").add(new Node("setup.pdf", 200));
            Node docs = new Node("docs").add(new Node("readme.txt", 10)).add(guides);
            Node src = new Node("src").add(new Node("main.java", 100)).add(new Node("utils.java", 50));
            return new Node("project").add(src).add(docs).add(new Node("config.xml", 20));
        }

        public static void main(String[] args) {
            Node project = buildProject();

            System.out.println("=== (b) Execution trace ===");
            int traced = totalSizeTraced(project, 0);
            System.out.println("\nRecursive total   = " + totalSize(project) + " KB");
            System.out.println("Traced total      = " + traced + " KB");
            System.out.println("Iterative total   = " + totalSizeIterative(project) + " KB");

            // (e) Add a symbolic link: docs/guides/link_to_project -> project (a cycle)
            System.out.println("\n=== (e) Cycle with a symbolic link ===");
            Node guides = project.children.get(1).children.get(1);
            guides.add(project);          // guides now contains project again
            System.out.println("Cycle-safe total  = " + totalSizeSafe(project, new HashSet<>()) + " KB");
            try {
                totalSize(project);       // plain recursion never reaches a base case
            } catch (StackOverflowError e) {
                System.out.println("Plain recursion  -> StackOverflowError (infinite recursion)");
            }
        }
    }

