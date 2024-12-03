
package days

import utils.Utils

object Day3 extends App {
  val input = (new Utils).readInputsAsLines(3)
  val conc = input.mkString
  val disableRegex = """don\'t\(\).*?do\(\)"""
  val enabledConc = conc.replaceAll(disableRegex, "")
  val regex = """mul\((\d{1,3}),(\d{1,3})\)""".r
  val filtered = regex.findAllIn(enabledConc).matchData.map(m => m.group(1).toInt * m.group(2).toInt)
  println(filtered.sum)
}
