object TypeLambda:
  // 型レベルでの無名関数的なものを直に書ける!!
  type IntEither = [R] =>> Either[Int, R]
  val er: IntEither[String] = Right("foo")
  val el: IntEither[String] = Left(42)
  def run(): Unit = println("type lambdaでは型レベルのラムダ式を書くことができる")
