package tp6.exo1.dev;

import java.util.ArrayList;
import java.util.List;

public class EscapeRoom {
    private String name;
    private int maxPlayers;
    private boolean active;
    private int totalScore;
    private List<Puzzle> puzzles;

    public EscapeRoom(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.active = false;
        this.totalScore = 0;
        this.puzzles = new ArrayList<Puzzle>();
    }

    // =========================================================
    // 1. STATIC NESTED CLASS — RoomConfig
    // Justification: stores room-level settings that exist before
    // and independently of any room instance.
    // Created as: new EscapeRoom.RoomConfig(...)
    // =========================================================
    public static class RoomConfig {
        private String difficulty;
        private int timeLimitMinutes;
        private int maxHints;

        public RoomConfig(String difficulty, int timeLimitMinutes, int maxHints) {
            this.difficulty = difficulty;
            this.timeLimitMinutes = timeLimitMinutes;
            this.maxHints = maxHints;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public int getTimeLimitMinutes() {
            return timeLimitMinutes;
        }

        public void setTimeLimitMinutes(int t) {
            this.timeLimitMinutes = t;
        }

        public int getMaxHints() {
            return maxHints;
        }

        public void setMaxHints(int h) {
            this.maxHints = h;
        }

        public String toString() {
            return "Config[difficulty=" + difficulty
                    + ", time=" + timeLimitMinutes + " min"
                    + ", maxHints=" + maxHints + "]";
        }
    }

    // =========================================================
    // 2. NON-STATIC INNER CLASS — Puzzle
    // Justification: a puzzle belongs to one room; it reads the
    // room's name and writes totalScore directly.
    // Created as: room.new Puzzle(...)
    // =========================================================
    public class Puzzle {
        private String title;
        private int points;
        private boolean solved;
        private int hintsUsed;

        public Puzzle(String title, int points) {
            this.title = title;
            this.points = points;
            this.solved = false;
            this.hintsUsed = 0;
        }

        public void solve() {
            if (solved) {
                System.out.println("  [!] Puzzle '" + title + "' is already solved.");
                return;
            }
            int earned = Math.max(0, points - hintsUsed * 10);
            solved = true;
            totalScore += earned; // directly modifies outer field
            System.out.println("  [" + name + "] Puzzle '" + title
                    + "' solved! +" + earned + " pts (hints used: " + hintsUsed
                    + ") | Room total: " + totalScore);
        }

        public void useHint() {
            hintsUsed++;
            System.out.println("  [Hint] Puzzle '" + title
                    + "' — hint #" + hintsUsed + " used (-10 pts penalty).");
        }

        public boolean isSolved() {
            return solved;
        }

        public String getTitle() {
            return title;
        }

        public int getPoints() {
            return points;
        }

        public int getHintsUsed() {
            return hintsUsed;
        }

        public String toString() {
            return "Puzzle['" + title + "', " + points + " pts"
                    + ", hints=" + hintsUsed
                    + ", " + (solved ? "SOLVED" : "unsolved") + "]";
        }
    }

    // =========================================================
    // 3. LOCAL CLASS inside applyRules() — GameRule
    // Justification: GameRule is only relevant during rule setup;
    // it captures the room name from the outer scope.
    // =========================================================
    public void applyRules(String[] ruleNames) {
        class GameRule {
            private String rule;
            private int priority;

            GameRule(String rule, int priority) {
                this.rule = rule;
                this.priority = priority;
            }

            void enforce() {
                System.out.println("  [Rule P" + priority + "] \""
                        + rule + "\" → applied to room '" + name + "'");
            }
        }

        System.out.println("Configuring rules for '" + name + "':");
        for (int i = 0; i < ruleNames.length; i++) {
            new GameRule(ruleNames[i], i + 1).enforce();
        }
        active = true;
    }

    // =========================================================
    // 4. ANONYMOUS CLASS — single-use alarm action
    // Justification: one-time behavior, no reuse needed,
    // directly references outer fields name & totalScore.
    // =========================================================
    public void triggerAlarm() {
        Runnable alarm = new Runnable() {
            public void run() {
                System.out.println("\n  *** EMERGENCY ALARM ***");
                System.out.println("  Room '" + name + "' is shutting down!");
                System.out.println("  Final score: " + totalScore + " pts");
                active = false;
            }
        };
        alarm.run();
    }

    public void addPuzzle(Puzzle p) {
        puzzles.add(p);
    }

    public List<Puzzle> getPuzzles() {
        return puzzles;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public boolean isActive() {
        return active;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int countSolved() {
        int count = 0;
        for (Puzzle p : puzzles)
            if (p.isSolved())
                count++;
        return count;
    }

    public String toString() {
        return "EscapeRoom['" + name + "', players=" + maxPlayers
                + ", active=" + active
                + ", puzzles=" + countSolved() + "/" + puzzles.size()
                + ", score=" + totalScore + "]";
    }
}
