case class TestObj(name: String, testList: Seq[String])

object Driver {

  def main(args:Array[String]) = {
  // Setup the test list data
  val tList = Seq(TestObj("test", Seq("1", "2")))

  // Convert the list to a new data structure

  
  println(System.currentTimeMillis())
  var l3 = for {
      t <- tList
      if t.name equalsIgnoreCase "test"
      lv <- t.testList
    } yield Seq(lv).par
println(System.currentTimeMillis())

      println(System.currentTimeMillis())
  var l4 = for {
      t <- tList
      if t.name equalsIgnoreCase "test"
      lv <- t.testList
    } yield Seq(lv)
println(System.currentTimeMillis())
    
          println(System.currentTimeMillis())
  var l5 = for {
      t <- tList
      if t.name equalsIgnoreCase "test"
      lv <- t.testList
    } yield Seq(lv).par
println(System.currentTimeMillis())
    
    
  // Output the values of the new data structure
  for (listVals <- l3) {
    for (strVal <- listVals) {
      println("strval is " + strVal)
    }
    println("New list")
  }
  }
  
}