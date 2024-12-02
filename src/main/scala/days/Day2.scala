package days

import utils.Utils
import scala.collection.immutable

object Day2 extends App {
  val input = (new Utils).readInputsFromConsole(2)
  //val input = List(List("1", "100", "200", "4", "5"))
  val inInts = input.map(l => l.map(s => s.toInt))
  val safe = inInts.map(lst => oneSmaller(lst).exists(sLst => isSafe(sLst, 0))) //(isDecreasing(lst) || isIncreasing(lst)) && isInRange(lst))
  val count = safe.foldRight(0)((b, cnt) => if (b) cnt + 1 else cnt)
  println(count)

  def isSafe(lst: List[Int], lastDiff: Integer): Boolean = lst match {
    case fst :: (rest@(snd :: next)) => 
      val diff = fst - snd
      val inRange = Math.abs(fst - snd) <= 3 && Math.abs(fst - snd) >= 1
      val safe = sameSign(diff, lastDiff) && inRange
      safe && isSafe(rest, diff)
    case _ => true
  }

  def sameSign(a: Int, b: Int): Boolean = (a <= 0 && b <= 0) || (a >= 0 && b >= 0)

  def oneSmaller(lst: List[Int]): List[List[Int]] = 
    lst match {
      case head :: next => next :: oneSmaller(next).map (lst => head :: lst) 
      case _ => List()
    }


}




