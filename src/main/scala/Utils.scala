package utils

import scala.io.StdIn
import java.io.File

class Utils {

  def readInputsFromConsole(day: Integer): List[List[String]] = {
    println(new File(".").getAbsolutePath)
    val source = scala.io.Source.fromFile("./inputs/Day" + day + ".txt")
    try {
      val lines = source.getLines 
      lines.toList.map(s => s.split("""\s+""").toList)
    } finally source.close()
    
  }

  def readInputsAsLines(day: Integer): List[String] = {
    println(new File(".").getAbsolutePath)
    val source = scala.io.Source.fromFile("./inputs/Day" + day + ".txt")
    try {
      val lines = source.getLines 
      lines.toList
    } finally source.close()
    
  }
}
