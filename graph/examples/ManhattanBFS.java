public static void traverseByManhattanDistance(int[][] arr, int startX, int startY) {
    // Define a 2D array to mark visited coordinates
    boolean[][] visited = new boolean[arr.length][arr[0].length];

    // Define the directions to move in to visit adjacent coordinates
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Traverse the array in order of increasing distance to (startX, startY)
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{startX, startY});

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int x = curr[0];
        int y = curr[1];
        if (visited[x][y]) {
            continue;
        }
        visited[x][y] = true;
        System.out.println("Visiting (" + x + ", " + y + ")");

        // Add the unvisited adjacent coordinates to the queue
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[newX].length && !visited[newX][newY]) {
                queue.offer(new int[]{newX, newY});
            }
        }
    }
}

public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    // Test case 1: Starting at (0, 0)
    System.out.println("Test case 1:");
    traverseByManhattanDistance(arr, 0, 0);

    // Test case 2: Starting at (1, 1)
    System.out.println("Test case 2:");
    traverseByManhattanDistance(arr, 1, 1);

    // Test case 3: Starting at (2, 2)
    System.out.println("Test case 3:");
    traverseByManhattanDistance(arr, 2, 2);
}
