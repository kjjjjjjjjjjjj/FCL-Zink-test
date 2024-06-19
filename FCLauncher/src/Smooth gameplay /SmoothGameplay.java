public class SmoothGameplay {

    // Player variables
    private float playerX;
    private float playerY;
    private float playerSpeed = 5.0f;

    // Constructor
    public SmoothGameplay() {
        playerX = 0.0f;
        playerY = 0.0f;
    }

    // Method to update player position
    public void updatePlayerPosition(float deltaTime, float horizontalInput, float verticalInput) {
        // Calculate movement
        float deltaX = horizontalInput * playerSpeed * deltaTime;
        float deltaY = verticalInput * playerSpeed * deltaTime;

        // Update player position
        playerX += deltaX;
        playerY += deltaY;
    }

    // Example: Smooth enemy movement method
    public void smoothEnemyMovement(float enemyX, float enemyY, float targetX, float targetY, float speed, float deltaTime) {
        // Calculate direction towards the target
        float directionX = targetX - enemyX;
        float directionY = targetY - enemyY;
        float distance = (float) Math.sqrt(directionX * directionX + directionY * directionY);

        // Normalize direction
        if (distance != 0.0f) {
            directionX /= distance;
            directionY /= distance;
        }

        // Calculate movement towards the target
        float moveX = directionX * speed * deltaTime;
        float moveY = directionY * speed * deltaTime;

        // Update enemy position
        enemyX += moveX;
        enemyY += moveY;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        SmoothGameplay gameplay = new SmoothGameplay();
        
        // Example: Update player position in game loop
        float deltaTime = 0.016f; // Example delta time (in seconds)
        float horizontalInput = 1.0f; // Example horizontal input (e.g., from keyboard or controller)
        float verticalInput = 0.5f; // Example vertical input
        
        gameplay.updatePlayerPosition(deltaTime, horizontalInput, verticalInput);

        // Example: Update enemy position in game loop
        float enemyX = 10.0f;
        float enemyY = 5.0f;
        float targetX = 20.0f;
        float targetY = 15.0f;
        float enemySpeed = 3.0f;

        gameplay.smoothEnemyMovement(enemyX, enemyY, targetX, targetY, enemySpeed, deltaTime);
        
        // Print updated positions (for testing)
        System.out.println("Player position: (" + gameplay.playerX + ", " + gameplay.playerY + ")");
        System.out.println("Enemy position: (" + enemyX + ", " + enemyY + ")");
    }
  }
