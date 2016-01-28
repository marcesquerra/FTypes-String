package com.bryghts.ftypes

import com.bryghts.ftypes.async.Flattener

import scala.concurrent.ExecutionContext

/**
 * Created by Marc Esquerrà on 26/01/2016.
 */
trait StringOps extends BasicFlatteners {


    implicit val implicitStringFlattener    : Flattener[async.String]       = async.String.implicitStringFlattener

    implicit class StringOpsImplicits[A <: async.Any[_, _]](in: A) {
        def toAsyncString(implicit show: Show[A] = DefaultShow, executionContext: ExecutionContext): async.String =
            show.toString(in)

        def + (other: async.String)(implicit show: Show[A] = DefaultShow): async.String =
            in +: other
    }
}


trait Show[-A <: async.Any[_, _]] {
    def toString(in: A)(implicit ec: ExecutionContext): async.String
}

object DefaultShow extends Show[async.Any[_, _]] {
    override def toString(in: async.Any[_, _])(implicit ec: ExecutionContext): async.String = {
        async.String(in.future.map(_.toString))
    }
}
