package immutablemutable

import java.util.Calendar

object Driver {

  def main(args: Array[String]) = {

    var javaList = new java.util.ArrayList[Int];
    for (i <- 0 until 10000) {
      javaList.add(2);
    }

    val scalaSeq = scala.collection.JavaConversions.asScalaBuffer(javaList)
    var before: Long = 0
    var after: Long = 0

    def nonParLoop = {
      println("Running nonParLoop")
       for (i <- scalaSeq) {
        scalaSeq.map(x => x * 1)
      }
    }
    
    def parLoop = {
      println("Running parLoop")
       for (i <- scalaSeq.par) {
        scalaSeq.par.map(x => x * 1)
      }
    }
    
    for (i <- 0 until 4) {
      println("******************************* New Loop Starting ************************************"+i)
      before = Calendar.getInstance().getTimeInMillis()
      println(before)
      if(i % 2 == 0) {
        parLoop
        
      }
      else {
        nonParLoop
      }
      after = Calendar.getInstance().getTimeInMillis()
      println(after)
      println(after - before)
    }

  }

}