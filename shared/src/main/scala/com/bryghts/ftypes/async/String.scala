package com.bryghts.ftypes
package async

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by Marc Esquerrà on 23/01/2016.
 */
class String private(override                    val future:           Future[java.lang.String])
                    (         implicit protected val executionContext: ExecutionContext, bf: async.Flattener[async.Byte], sf: async.Flattener[async.String], cf: async.Flattener[async.Char])  extends async.Any[java.lang.String, async.String]{
//    public int length()
    def length:async.Int =
        async.Int(future.map(_.length))

//    public boolean isEmpty()
    def isEmpty: async.Boolean =
        async.Boolean(future.map(_.isEmpty))

//    public char charAt(int index)
    def charAt(index: async.Int): async.Char =
        async.Char(
            for {
                i <- index.future
                s <- future
            } yield s.charAt(i)
        )

//    public int codePointAt(int index)
    def codePointAt(index: async.Int): async.Int =
        async.Int(
            for {
                i <- index.future
                s <- future
            } yield s.codePointAt(i)
        )

//    public int codePointBefore(int index)
    def codePointBefore(index: async.Int): async.Int =
        async.Int(
            for {
                i <- index.future
                s <- future
            } yield s.codePointBefore(i)
        )

//    public int codePointCount(int beginIndex, int endIndex)
    def codePointCount(beginIndex: async.Int, endIndex: async.Int): async.Int =
        async.Int(
            for {
                b <- beginIndex.future
                e <- endIndex.future
                s <- future
            } yield s.codePointCount(b, e)
        )

//    public int offsetByCodePoints(int index, int codePointOffset)
    def offsetByCodePoints(index: async.Int, codePointOffset: async.Int): async.Int =
        async.Int(
            for {
                i <- index.future
                p <- codePointOffset.future
                s <- future
            } yield s.offsetByCodePoints(i, p)
        )

//    public byte[] getBytes(String charsetName)
    def getBytes(charsetName: async.String): async.Array[async.Byte] =
        async.Array.from[async.Byte](
            for {
                c <- charsetName.future
                s <- future
            } yield s.getBytes(c).map(async.Byte.apply)
        )(executionContext, bf)

//    public byte[] getBytes(Charset charset)

//    public byte[] getBytes()
    def getBytes(): async.Array[async.Byte] =
        async.Array.from[async.Byte](
            for {
                s <- future
            } yield s.getBytes().map(async.Byte.apply)
        )(executionContext, bf)

//    public boolean equalsIgnoreCase(String anotherString)
    def equalsIgnoreCase(anotherString: async.String): async.Boolean =
        async.Boolean(
            for {
                a <- anotherString.future
                s <- future
            } yield s.equalsIgnoreCase(a)
        )

//    public int compareTo(String anotherString)
    def compareTo(anotherString: async.String): async.Int =
        async.Int(
            for {
                a <- anotherString.future
                s <- future
            } yield s.compareTo(a)
        )

//    public int compareToIgnoreCase(String str)
    def compareToIgnoreCase(str: async.String): async.Int =
        async.Int (
            for {
                s  <- future
                s2 <- str.future
            } yield s.compareToIgnoreCase(s2)
        )

//    public boolean regionMatches(int toffset, String other, int ooffset, int len)
    def regionMatches(toffset: async.Int, other: async.String, ooffset: async.Int, len: async.Int): async.Boolean  =
        async.Boolean  (
            for {
                s <- future
                t <- toffset.future
                o <- other.future
                f <- ooffset.future
                l <- len.future
            } yield s.regionMatches(t, o, f, l)
        )

//    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
    def regionMatches(ignoreCase: async.Boolean, toffset: async.Int, other: async.String, ooffset: async.Int, len: async.Int): async.Boolean  =
        async.Boolean  (
            for {
                s <- future
               i <-  ignoreCase.future
               t <-  toffset.future
               o <-  other.future
               f <-  ooffset.future
               l <-  len.future
            } yield s.regionMatches(i, t, o, f, l)
        )

//    public boolean startsWith(String prefix, int toffset)
    def startsWith(prefix: async.String, toffset: async.Int): async.Boolean  =
        async.Boolean  (
            for {
                s <- future
               p <-  prefix.future
               t <-  toffset.future
            } yield s.startsWith(p, t)
        )

//    public boolean startsWith(String prefix)
    def startsWith(prefix: async.String): async.Boolean  =
        async.Boolean  (
            for {
                s <- future
               p <-  prefix.future
            } yield s.startsWith(p)
        )

//    public boolean endsWith(String suffix)
    def endsWith(suffix: async.String): async.Boolean  =
        async.Boolean  (
            for {
                s <- future
               f <-  suffix.future
            } yield s.endsWith(f)
        )

//    public int indexOf(int ch)
    def indexOf(ch: async.Int): async.Int  =
        async.Int  (
            for {
                s <- future
               c <-  ch.future
            } yield s.indexOf(c)
        )

//    public int indexOf(int ch, int fromIndex)
    def indexOf(ch: async.Int, fromIndex: async.Int): async.Int  =
        async.Int  (
            for {
                s <- future
               c <-  ch.future
               f <-  fromIndex.future
            } yield s.indexOf(c, f)
        )

//    public int lastIndexOf(int ch)
    def lastIndexOf(ch: async.Int): async.Int  =
        async.Int  (
            for {
                s <- future
               c <-  ch.future
            } yield s.lastIndexOf(c)
        )

//    public int lastIndexOf(int ch, int fromIndex)
    def lastIndexOf(ch: async.Int, fromIndex: async.Int): async.Int  =
        async.Int  (
            for {
                s <- future
               c <-  ch.future
               f <-  fromIndex.future
            } yield s.lastIndexOf(c, f)
        )

//    public int indexOf(String str)
    def indexOf(str: async.String): async.Int  =
        async.Int  (
            for {
                s <- future
               t <-  str.future
            } yield s.indexOf(t)
        )

//    public int indexOf(String str, int fromIndex)
    def indexOf(str: async.String, fromIndex: async.Int): async.Int  =
        async.Int  (
            for {
                s <- future
               t <-  str.future
               f <-  fromIndex.future
            } yield s.indexOf(t, f)
        )

//    public int lastIndexOf(String str)
    def lastIndexOf(str: async.String): async.Int  =
        async.Int  (
            for {
                s <- future
               t <-  str.future
            } yield s.lastIndexOf(t)
        )

//    public int lastIndexOf(String str, int fromIndex)
    def lastIndexOf(str: async.String, fromIndex: async.Int): async.Int  =
        async.Int  (
            for {
                s <- future
               t <-  str.future
               f <-  fromIndex.future
            } yield s.lastIndexOf(t, f)
        )

//    public String substring(int beginIndex)
    def substring(beginIndex: async.Int): async.String  =
        async.String  (
            for {
                s <- future
               b <-  beginIndex.future
            } yield s.substring(b)
        )

//    public String substring(beginIndex: async.Int, endIndex: Int)
    def substring(beginIndex: async.Int, endIndex: async.Int): async.String  =
        async.String  (
            for {
                s <- future
               b <-  beginIndex.future
               e <-  endIndex.future
            } yield s.substring(b, e)
        )

//    public String concat(String str)
    def concat(str: async.String): async.String  =
        async.String  (
            for {
                s <- future
               t <-  str.future
            } yield s.concat(t)
        )

    def + [B <: async.Any[_, _]](other: B)(implicit show: Show[B] = DefaultShow): async.String  =
        concat(show.toString(other))

    def +: [B <: async.Any[_, _]](other: B)(implicit show: Show[B] = DefaultShow): async.String  =
        show.toString(other).concat(this)


//    public String replace(char oldChar, char newChar)
    def replace(oldChar: async.Char, newChar: async.Char): async.String  =
        async.String  (
            for {
                s <- future
               o <-  oldChar.future
               n <-  newChar.future
            } yield s.replace(o, n)
        )

//    public boolean matches(String regex)
    def matches(regex: async.String): async.Boolean  =
        async.Boolean  (
            for {
                s <- future
               r <-  regex.future
            } yield s.matches(r)
        )

//    public boolean contains(CharSequence s)
    def contains(str: async.String): async.Boolean  =
        async.Boolean  (
            for {
                s <- future
                t <-  str.future
            } yield s.contains(t)
        )

//    public String replaceFirst(String regex, String replacement)
    def replaceFirst(regex: async.String, replacement: async.String): async.String  =
        async.String  (
            for {
                s <- future
               x <-  regex.future
               r <-  replacement.future
            } yield s.replaceFirst(x, r)
        )

//    public String replaceAll(String regex, String replacement)
    def replaceAll(regex: async.String, replacement: async.String): async.String  =
        async.String  (
            for {
                s <- future
               x <-  regex.future
               r <-  replacement.future
            } yield s.replaceAll(x, r)
        )

//    public String replace(CharSequence target, CharSequence replacement)
    def replace(target: async.String, replacement: async.String): async.String  =
        async.String  (
            for {
                s <- future
               t <-  target.future
               r <-  replacement.future
            } yield s.replace(t, r)
        )

//    public String[] split(String regex, int limit)
    def split(regex: async.String, limit: async.Int): async.Array[async.String] =
        async.Array.from[async.String](
            for {
                s <- future
               r <-  regex.future
               l <-  limit.future
            } yield s.split(r, l).map(Future.successful).map(f => async.String.apply(f))
        )(executionContext, sf)

//    public String[] split(String regex)
    def split(regex: async.String): async.Array[async.String] =
        async.Array.from[async.String](
            for {
                s <- future
               r <-  regex.future
            } yield s.split(r).map(Future.successful).map(f => async.String(f))
        )

//    public String toLowerCase(Locale locale)
//    def toLowerCase(Locale locale): async.String  = ???

//    public String toLowerCas
def toLowerCase(): async.String  =
        async.String  (
            for {
                s <- future
            } yield s.toLowerCase()
        )

//    public String toUpperCase(Locale locale)
//    def toUpperCase(Locale locale): async.String  = ???

//    public String toUpperCase()
    def toUpperCase(): async.String  =
        async.String  (
            for {
                s <- future
            } yield s.toUpperCase()
        )

//    public String trim()
    def trim(): async.String  =
        async.String  (
            for {
                s <- future
            } yield s.trim()
        )

//    public char[] toCharArray()
    def toCharArray(): async.Array[async.Char] =
        async.Array.from[async.Char](
            for {
                s <- future
            } yield s.toCharArray().map(Future.successful).map(c => async.Char(c))
        )

}

object String {

    private object Creator extends BasicFlatteners {
        implicit val StringFlattener =
            BasicFlattener(implicit ec => async.String.apply)

        def String(in: Future[java.lang.String])(implicit ec: ExecutionContext) =
            new async.String(in)
    }

    implicit val implicitStringFlattener    : Flattener[async.String]       =
        Creator.StringFlattener

    def apply(in: Future[java.lang.String])(implicit executionContext: ExecutionContext): async.String =
        Creator.String(in)

}
