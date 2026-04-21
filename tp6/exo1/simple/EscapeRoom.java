package tp6.exo1.simple;

public class EscapeRoom {
    private String name;
    private int maxPlayers;
    private boolean active;
    private int totalScore;

    public EscapeRoom(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.active = false;
        this.totalScore = 0;
    }

    // =========================================================
    // 1. STATIC NESTED CLASS — RoomConfig
    // Justification: configuration data is independent of any
    // specific EscapeRoom instance; no outer 'this' is needed.
    // Created as: new EscapeRoom.RoomConfig(...)
    // =========================================================
    public static class RoomConfig {
        private String difficulty;
        private int timeLimitMinutes;

        public RoomConfig(String difficulty, int timeLimitMinutes) {
            this.difficulty = difficulty;
            this.timeLimitMinutes = timeLimitMinutes;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public int getTimeLimitMinutes() {
            return timeLimitMinutes;
        }

        public String toString() {
            return "Config[difficulty=" + difficulty + ", time=" + timeLimitMinutes + " min]";
        }
    }

    // =========================================================
    // 2. NON-STATIC INNER CLASS — Puzzle
    // Justification: a puzzle belongs to a specific room; it
    // directly reads/writes the outer room's name & totalScore.
    // Created as: room.new Puzzle(...)
    // =========================================================
    public class Puzzle {
        private String title;
        private int points;
        private boolean solved;

        public Puzzle(String title, int points) {
            this.title = title;
            this.points = points;
            this.solved = false;
        }

        public void solve() {
            if (solved) {
                System.out.println("  Puzzle '" + title + "' is already solved.");
                return;
            }
            solved = true;
            totalScore += points; // accessing outer class field directly
            System.out.println("  [" + name + "] Puzzle '" + title
                    + "' solved! +" + points + " pts | Total: " + totalScore);
        }

        public boolean isSolved() {
            return solved;
        }

        public String toString() {
            return "Puzzle['" + title + "', " + points + " pts, "
                    + (solved ? "SOLVED" : "unsolved") + "]";
        }
    }

    // =========================================================
    // 3. LOCAL CLASS inside applyRules() — GameRule
    // Justification: a rule exists only while the method runs;
    // it has no meaning outside this execution context.
    // =========================================================
    public void applyRules(String ruleName) {
        class GameRule {
            private String rule;

            GameRule(String rule) {
                this.rule = rule;
            }

            void enforce() {
                System.out.println("  [" + name + "] Rule applied: \"" + rule + "\"");
            }
        }

        GameRule gr = new GameRule(ruleName);
        gr.enforce();
        active = true;
    }

    // =========================================================
    // 4. ANONYMOUS CLASS — single-use alarm action
    // Justification: the alarm is used exactly once and needs no
    // reusable named type; defined and invoked inline.
    // =========================================================
    public void triggerAlarm() {
        Runnable alarm = new Runnable() {
            public void run() {
                System.out.println("  *** ALARM *** Room '" + name
                        + "' evacuated! Final score: " + totalScore + " pts");
                active = false;
            }
        };
        alarm.run();
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

    public String toString() {
        return "EscapeRoom['" + name + "', maxPlayers=" + maxPlayers
                + ", active=" + active + ", score=" + totalScore + "]";
    }
}
