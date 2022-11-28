/** Intersection types と Union typesについて
  */
object InterUnion:
  type IS = Int | String // Union types
  val s: IS = "Union typesで型を合わせることができる。ISはIntかStringのどちらかである。"
  val i: IS = 42

  def checkType(x: IS): Unit = x match
    case i: Int    => println(s"$i は Int")
    case s: String => println(s"$s は String")

  def checkShape(x: Box | Circle): Unit = x match
    // case classやenumによるUnion Typesの場合、exhaustive checkがかかる
    case Box(l)    => println("box")
    case Circle(r) => println("circle")

  def run(): Unit =
    checkType(s)
    checkType(i)
    checkShape(Box(42))

case class Box(len: Double)
case class Circle(r: Double)
