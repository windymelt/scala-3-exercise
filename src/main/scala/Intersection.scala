/**
  * Intersection types
  */
object Intersection:
  type Monoid[A] = Empty[A] & Semigroup[A]
  // やや強引だが、EmptyかつSemigroupな型であるMonoidを手で受け取ってreduceを実装してみる
  def reduce[A](xs: Seq[A], instance: Monoid[A]): A = xs.foldLeft(instance.empty){ case (b, a) => instance.combine(b, a) }
  def run(): Unit =
    println(reduce(Seq("foo", "bar", "buzz"), StringMonoidInstance()))

trait Empty[A]:
  def empty: A

trait Semigroup[A]:
  def combine(x: A, y: A): A

class StringMonoidInstance extends Empty[String] with Semigroup[String]:
  def combine(x: String, y: String): String = x ++ y
  def empty = ""
