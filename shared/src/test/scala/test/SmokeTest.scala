package tests

import com.bryghts.ftypes._
import utest._
import utest.ExecutionContext.RunNow

import scala.concurrent.duration.Duration
import scala.concurrent.{Future, Await, Awaitable}

object FTypes extends ValExtensions
with BasicFlatteners

import FTypes._

/**
 * Created by Marc Esquerrà on 23/01/2016.
 */
object SmokeTest  extends TestSuite
                     with StringOps {
    val tests = TestSuite{
        "Basic Check" - {
            "Simple Comparisson" - {
                val x = async.Int(1)
                val y = async.Int(2)
                val r = x =!= y
                //                assert(await(r))
                r.future.map(r => assert(r))
            }
        }
        "Playing with Strings" - {
            val a = async.String(Future.successful("ABC"))
            val b = async.Int(3)
            val r1 = a + b
            val r2 = b + a
            r1.future.map(r => assert(r == "ABC3"))
            r2.future.map(r => assert(r == "3ABC"))
        }
    }

}
