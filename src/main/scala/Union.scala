/** Union typesについて
  */
object Union:
  type IS = Int | String // Union types
  val s: IS = "Union typesで型を合わせることができる。ISはIntかStringのどちらかである。"
  val i: IS = 42

  def checkType(x: IS): Unit = x match
    case i: Int    => println(s"$i は Int")
    case s: String => println(s"$s は String")

  def area(x: Box | Circle): Double = x match
    // case classやenumによるUnion Typesの場合、exhaustive checkがかかる
    case Box(w, h) => w * h
    case Circle(r) => Math.PI * (r * r)

  def run(): Unit =
    checkType(s)
    checkType(i)
    println(area(Box(42, 12)))

case class Box(w: Double, h: Double)
case class Circle(r: Double)
