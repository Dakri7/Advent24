
package days

import utils.Utils

object Day1 extends App {
  val input = (new Utils).readInputsFromConsole(1)
  val fst = input.map(l => l(0).toInt).sorted
  val snd = input.map(l => l(1).toInt).sorted
  val zipped = fst zip snd
  val totalDist = zipped.map({case (a, b) => Math.abs(a-b)}).sum

  val groupedSnd = snd.groupBy(identity).mapValues(_.size)
  val weightedFst = fst.map(i => i * (groupedSnd.get(i) getOrElse 0))
  println(totalDist)
  println(weightedFst.sum)
}

