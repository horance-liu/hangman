package cn.codingstyle.hangman

import org.scalatest._
import org.scalatest.Matchers._

class RuleSpec extends FunSpec {
  describe("start game") {
    it("try guess APPLE") {
      val hangman = new Hangman("APPLE");
	  hangman.tries should be (12)        
      hangman.used should be ("AEIOU")
      hangman.length should be (5)
      hangman.problem should be ("A___E")
    }
  }
}