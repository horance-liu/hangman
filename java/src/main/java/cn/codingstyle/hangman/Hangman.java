package cn.codingstyle.hangman;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class Hangman {
  private List<String> used = new ArrayList<String>() {{
    add("AEIOU");
  }};

  private int tries = 12;
  private List<String> solution;

  public Hangman(String solution) {
    this.solution = toCharSequence(solution);
  }

  private static List<String> toCharSequence(String str) {
    return new ArrayList<String>() {{
      for (int i = 0; i < str.length(); i++)
        add(valueOf(str.charAt(i)));
    }};
  }

  private Hangman(List<String> solution, List<String> used, int tries) {
    this.solution = solution;
    this.used = used;
    this.tries = tries;
  }

  public Hangman tryChar(char ch) {
    return new Hangman(solution, newUsed(ch), newTries(ch));
  }

  private List<String> newUsed(char ch) {
    return new ArrayList<String>() {{
      addAll(used); add(valueOf(ch)); }};
  }

  private int newTries(char ch) {
    return solution.contains(valueOf(ch)) ? tries : tries - 1;
  }

  public boolean won() {
    return problem().equals(toStr(solution));
  }

  public boolean lost() {
    return tries == 0;
  }

  public String used() {
    return toStr(used);
  }

  public String problem() {
    return toStr(mapToProblem());
  }

  private List<String> mapToProblem() {
    return solution.stream()
        .map(ch -> used.contains(ch) ? ch : "_")
        .collect(toList());
  }

  private static String toStr(List<String> chars) {
    return String.join("", chars);
  }

  public int tries() {
    return tries;
  }

  public int length() {
    return solution.size();
  }
}
