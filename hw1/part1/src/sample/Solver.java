package sample;

public class Solver {
    private SolutionStrategy solutionStrategy;

    /**
     * Sets the solution strategy
     * @param solutionStrategy chosen strategy
     */
    public void setSolutionStrategy(SolutionStrategy solutionStrategy) {
        this.solutionStrategy = solutionStrategy;
    }

    /**
     * Starts solving the equation by the assigned method
     * @return teh roots of the equation
     */
    public StringBuilder solveEquation() {
        StringBuilder sb = solutionStrategy.solve();
        return sb;
    }
}
