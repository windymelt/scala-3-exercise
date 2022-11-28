object OptionalBraces:
  // エラーメッセージもかなりわかりやすくなってるな〜
  def introduce(): Unit = println("Optional braces https://dotty.epfl.ch/docs/reference/other-new-features/indentation.html について学ぶぞい")
  def run(): Unit =
    introduce()
    println("ObjectやClassなどはcolonでブロックを作る")
    println("メソッドのブロックはとくに何もつけなくてもよい")
    println("エディタによってはタブを入力すると補完しようとしてうまくいかないことがある(自分のEmacsだとちょっと設定が必要そう。エンターするたびに勝手にインデントを0にされる)")

    println("インデントを保つ範囲で空行が許されている")
    val xs = Seq(1, 2, 3, 4, 5)
    val ys = xs map (n => n * 2)

    println("for-comprehensionでは何もつけなくてよい")
    val xys =
      for
        x <- xs
        y <- ys
      yield x -> y
    println(xys)

    println("match式では何もつけなくてよい")
    xs match
      case Seq(a, b, c, d, e) => println(a + b + c + d + e)
      case _ => ???
    TemplateBody("foo")
    Scala33()

    val FooRx = """(foo)""".r.unanchored
    "foofoofoo" match
    case FooRx(s) => println("このように、特にcase文では、前段のmatchと同列のインデントが許可されている。")
    case otherwise => ???
    println("その場合は、caseでない文が来た時点でmatchが終わったものとみなされる。")
  end run // 分かりやすくするために endマーカを置いてもよい。

case class TemplateBody(x: String):
  println("classやobject、trait、packageの中身はtemplate bodyと呼ばれ、通常のブロックとは区別されている。")
  println("このようなtemplate bodyではコロンを用いてbraceを省略できる。")

class Scala33:
  println("Scala 3.3以降は、以下のようなメソッド引数に対するコロンが許可される:")
  // Seq(1, 2, 3).map: x =>
  //   x * 2
