import cats.effect.{IO, IOApp}

import scala.util.Random

object Example extends IOApp.Simple {

  def fib(n: Int, a: Long = 0, b: Long = 1): IO[Long] =
    IO(a + b).flatMap { b2 =>
      if (n > 0)
        fib(n - 1, b, b2)
      else
        IO.pure(b2)
    }

  def program: IO[Unit] =
    for {
      x <- fib(20)
      _ <- IO(println(s"The 20th fibonacci number is $x"))
      _ <- IO(Random.nextBoolean())
        .ifM(IO.raiseError(new Throwable("Boom!")), IO.unit)
    } yield ()

  @main override def run: IO[Unit] =
    program
}

