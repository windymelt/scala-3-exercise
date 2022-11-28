@main def hello: Unit =
  println("Hello world!")
  println(msg)
  println("https://dotty.epfl.ch/docs/reference/index.html を参考にScala 3の機能をなぞっていくぞい")
  OptionalBraces.run()
  Union.run()
  Intersection.run()
  TypeLambda.run()
  DependentFunctionType.run()

def msg = "I was compiled by Scala 3. :)"
