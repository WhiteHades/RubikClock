//import java.util.Stack;
//import java.util.HashSet;
//
//public class RubikClockSolver {
//    private rubikModel model;
//    private Stack<rubikModel> stack;
//    private HashSet<rubikModel> visited;
//
//    public RubikClockSolver(rubikModel initialModel) {
//        this.model = initialModel;
//        this.stack = new Stack<>();
//        this.visited = new HashSet<>();
//    }
//
//    public void solve() {
//        stack.push(model);
//
//        while (!stack.isEmpty()) {
//            rubikModel currentState = stack.pop();
//            visited.add(currentState);
//
//            if (currentState.checkWin()) {
//                // You've found a solution!
//                printSolution(currentState);
//                return;
//            }
//
//            for (int i = 0; i < 2; i++) {
//                for (int j = 0; j < 2; j++) {
//                    rubikModel newState = new rubikModel(currentState); // Create a copy
//                    newState.pressButton(i, j);
//
//                    if (!visited.contains(newState)) {
//                        stack.push(newState);
//                    }
//                }
//            }
//        }
//
//        System.out.println("No solution found.");
//    }
//
//    private void printSolution(rubikModel finalState) {
//        // Implement code to print the sequence of moves to reach the solution.
//        // You can backtrack from the finalState to the initial state.
//        // This code would depend on how your rubikModel tracks moves and the game state.
//    }
//
//    public static void main(String[] args) {
//        rubikModel initialModel = new rubikModel();
//        RubikClockSolver solver = new RubikClockSolver(initialModel);
//        solver.solve();
//    }
//}
