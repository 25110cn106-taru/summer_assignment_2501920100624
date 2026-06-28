import java.io.*;
import java.util.*;

public class QuizApplication {

    // ─── Inner class to hold one question ───────────────────────────────────
    static class Question {
        String question;
        String[] options = new String[4];
        char correctAnswer;

        Question(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options  = options;
            this.correctAnswer = correctAnswer;
        }
    }

    // ─── Load questions from file ────────────────────────────────────────────
    static List<Question> loadQuestions(String filename) throws IOException {
        List<Question> questions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String questionText = line;
            String[] options = new String[4];
            for (int i = 0; i < 4; i++) {
                options[i] = br.readLine().trim();
            }
            char answer = br.readLine().trim().toUpperCase().charAt(0);
            questions.add(new Question(questionText, options, answer));
        }
        br.close();
        return questions;
    }

    // ─── Save result to file ─────────────────────────────────────────────────
    static void saveResult(String filename, String name, int score,
                           int total, List<String> log) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true)); // append mode
        bw.write("==========================================");
        bw.newLine();
        bw.write("          QUIZ RESULT REPORT              ");
        bw.newLine();
        bw.write("==========================================");
        bw.newLine();
        bw.write("Name  : " + name);
        bw.newLine();
        bw.write("Score : " + score + " / " + total);
        bw.newLine();
        bw.write("Grade : " + getGrade(score, total));
        bw.newLine();
        bw.write("------------------------------------------");
        bw.newLine();
        bw.write("Detailed Answers:");
        bw.newLine();
        for (String entry : log) {
            bw.write(entry);
            bw.newLine();
        }
        bw.write("==========================================");
        bw.newLine();
        bw.newLine();
        bw.close();
        System.out.println("\nResult saved to: " + filename);
    }

    // ─── Grade logic ─────────────────────────────────────────────────────────
    static String getGrade(int score, int total) {
        double percent = (score * 100.0) / total;
        if (percent >= 90) return "A+ (Excellent!)";
        else if (percent >= 80) return "A  (Very Good)";
        else if (percent >= 70) return "B  (Good)";
        else if (percent >= 60) return "C  (Average)";
        else if (percent >= 50) return "D  (Pass)";
        else return "F  (Fail — Keep Studying!)";
    }

    // ─── Main ────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String questionsFile = "questions.txt";   // input file
        String resultsFile   = "results.txt";     // output file

        System.out.println("==========================================");
        System.out.println("     QUIZ APPLICATION - FILE HANDLING     ");
        System.out.println("==========================================");

        // ── Load questions ──
        List<Question> questions;
        try {
            questions = loadQuestions(questionsFile);
            System.out.println("Questions loaded from: " + questionsFile);
            System.out.println("Total Questions: " + questions.size());
        } catch (IOException e) {
            System.out.println("ERROR: Could not load '" + questionsFile + "'");
            System.out.println("Make sure the file exists in the same directory.");
            scanner.close();
            return;
        }

        // ── Get player name ──
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine().trim();
        System.out.println("\nGood luck, " + name + "! Quiz starting...\n");

        int score = 0;
        List<String> answerLog = new ArrayList<>();

        // ── Quiz loop ──
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ". " + q.question);
            for (String option : q.options) {
                System.out.println("   " + option);
            }

            char userAnswer = ' ';
            while (true) {
                System.out.print("Your answer (A/B/C/D): ");
                String input = scanner.nextLine().trim().toUpperCase();
                if (input.length() == 1 && "ABCD".contains(input)) {
                    userAnswer = input.charAt(0);
                    break;
                }
                System.out.println("Invalid input! Please enter A, B, C, or D.");
            }

            boolean correct = (userAnswer == q.correctAnswer);
            if (correct) {
                score++;
                System.out.println("✔ Correct!\n");
                answerLog.add("Q" + (i + 1) + ": Your answer = " + userAnswer
                        + " | Correct = " + q.correctAnswer + " | CORRECT");
            } else {
                System.out.println("✘ Wrong! Correct answer: " + q.correctAnswer + "\n");
                answerLog.add("Q" + (i + 1) + ": Your answer = " + userAnswer
                        + " | Correct = " + q.correctAnswer + " | WRONG");
            }
        }

        // ── Display result on screen ──
        System.out.println("==========================================");
        System.out.println("Quiz Completed!");
        System.out.printf("%-10s : %s%n", "Name", name);
        System.out.printf("%-10s : %d / %d%n", "Score", score, questions.size());
        System.out.printf("%-10s : %s%n", "Grade", getGrade(score, questions.size()));
        System.out.println("==========================================");

        // ── Save result to file ──
        try {
            saveResult(resultsFile, name, score, questions.size(), answerLog);
        } catch (IOException e) {
            System.out.println("WARNING: Could not save result to file. " + e.getMessage());
        }

        scanner.close();
    }
}