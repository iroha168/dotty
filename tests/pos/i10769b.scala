package stm

trait STMLike[F[_]] {
  import Internals._

  sealed abstract class Txn[+A] {}

  object Txn {
    def abort[A](e: Throwable): Txn[A] = Abort(e)
  }

  object Internals {
    case class Abort(error: Throwable) extends Txn[Nothing]
    case object Noop extends Txn[Nothing]
  }

  class Foo {
    case class Abort(error: Throwable) extends Txn[Nothing]
    case object Noop extends Txn[Nothing]
  }
}
