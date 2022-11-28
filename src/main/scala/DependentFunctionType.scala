object DependentFunctionType:
  def run(): Unit =
    val getter = ConcreteEntityKeyGetter()
    getter.getKey(User(0, "windymelt"))
    getter.getKey(CompoundEntity(42, "foo", "value"))

class ConcreteEntityKeyGetter extends EntityKeyGetter:
  def getKey(e: Entity): e.K = e.key

trait EntityKeyGetter:
  def getKey(e: Entity): e.K

trait Entity:
  type K
  type V
  def key: K

case class User(id: Int, name: String) extends Entity:
  type K = Int
  type V = String
  def key = id

case class CompoundEntity(id1: Int, id2: String, value: String) extends Entity:
  type K = (Int, String)
  type V = String
  def key = id1 -> id2
