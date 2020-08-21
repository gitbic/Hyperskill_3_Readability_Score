package readability;

class TextProcessing {
    private String text;
    private double sentences;
    private double words;
    private double characters;
    private double syllables;
    private double polysyllables;
    private ScoreMap scoreMap = new ScoreMap();
    private FileIO fileIO = new FileIO();

    void readText(String path) {
        text = fileIO.read(path);
    }

    void printTextStats() {
        System.out.printf("Words: %d%n", (int) words);
        System.out.printf("Sentences: %d%n", (int) sentences);
        System.out.printf("Characters: %d%n", (int) characters);
        System.out.printf("Syllables: %d%n", (int) syllables);
        System.out.printf("Polysyllables: %d%n", (int) polysyllables);
    }

    void printText() {
        System.out.printf("The text is: %n%s%n%n", text);
    }

    void decomposeText() {
        sentences = text.split("[.!?]").length;
        words = text.split("\\s").length;
        characters = text.replaceAll("\\s", "").length();

        String str = text.toLowerCase();
        str = str.replaceAll("e\\b", "");
        str = str.replaceAll("[aeiouy]{1,}|\\b[^aeiouy ]+\\b", "a");
        String str2 = str.replaceAll("\\b(\\w*a){3,}\\w*\\b", "e");
        syllables = str.replaceAll("[^a]", "").length();
        polysyllables = str2.replaceAll("[^e]", "").length();
    }

    int calcARI() {
        double score = 4.71 * characters / words + 0.5 * words / sentences - 21.43;
        int age = scoreMap.getAge((int) Math.round(score));
        System.out.printf("Automated Readability Index: %.2f (about %d year olds).%n", score, age);
        return age;
    }

    int calcFK() {
        double score = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
        int age = scoreMap.getAge((int) Math.round(score));
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).%n", score, age);
        return age;
    }

    int calcSMOG() {
        double score = 1.043 * Math.sqrt(polysyllables * 30 / sentences) + 3.1291;
        int age = scoreMap.getAge((int) Math.round(score));
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).%n", score, age);
        return age;
    }

    int calcCL() {
        double score = 0.0588 * (characters / words * 100) - 0.296 * (sentences / words * 100) - 15.8;
        int age = scoreMap.getAge((int) Math.round(score));
        System.out.printf("Coleman–Liau index: %.2f (about %d year olds).%n", score, age);
        return age;
    }

    void calcAll() {
        double ageAverage = (double) (calcARI() + calcFK() + calcSMOG() + calcCL()) / 4;
        System.out.println();
        System.out.printf("This text should be understood in average by %.2f year olds.", ageAverage);
    }
}
